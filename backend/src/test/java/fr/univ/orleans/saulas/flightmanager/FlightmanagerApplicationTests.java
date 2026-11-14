package fr.univ.orleans.saulas.flightmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
	void loginPageRenders() throws Exception {
		mockMvc.perform(get("/login"))
				.andExpect(status().isOk())
				.andExpect(content().string(org.hamcrest.Matchers.containsString("<h1>Login</h1>")));
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
