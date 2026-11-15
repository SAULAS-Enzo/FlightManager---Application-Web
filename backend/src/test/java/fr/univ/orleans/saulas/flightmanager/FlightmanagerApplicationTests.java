package fr.univ.orleans.saulas.flightmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FlightmanagerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void invalidLoginReturnsJsonError() throws Exception {
		mockMvc.perform(post("/req/connexion")
				.param("nomUtilisateur", "utilisateur-inexistant")
				.param("motDePasse", "mot-de-passe-invalide"))
				.andExpect(status().isUnauthorized())
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$.message").value("Nom d'utilisateur ou mot de passe invalide."));
	}

	@Test
	void incompleteRegistrationReturnsBadRequest() throws Exception {
		mockMvc.perform(post("/req/inscription")
				.contentType("application/json")
				.content("{\"nomUtilisateur\":\"nouveau\",\"adresseMail\":\"nouveau@example.com\"}"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Tous les champs sont obligatoires."));
	}

	@Test
	void utilisateurTableIsCreatedInConfiguredDatabase() {
		Integer tableCount = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM information_schema.tables "
						+ "WHERE table_schema = DATABASE() AND table_name = 'UTILISATEUR'",
				Integer.class);

		assertEquals(1, tableCount, "Hibernate should create the utilisateur table in the configured database");
	}

}
