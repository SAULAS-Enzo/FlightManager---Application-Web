# Flight Manager ✈️

Application web fullstack conçue pour les pilotes de simulation aérienne utilisant le réseau **IVAO**, développée dans le cadre du **BUT Informatique**.

---

## 🛠️ Stack Technique

* **Front-End :** React.js, HTML5, CSS3, JavaScript ES6+ (NPM)
* **Back-End :** Java 21, Spring Boot, Spring Data JDBC (Maven)
* **Base de Données :** MariaDB / MySQL
* **Méthodologie & DevOps :** Agile (Kanban & Issues GitHub), Git, Docker & Kubernetes.

---

## 📁 Architecture du Projet

```text
FlightManager---Application-Web/
├── backend/            # Projet Spring Boot (API REST Java 21)
│   ├── src/main/java   # Code source Java (Controller, DTO, Model, Repository, Service)
│   ├── src/main/resources # Configuration (application.properties, templates, static)
│   ├── pom.xml         # Configuration Maven & Dépendances
│   └── HELP.md
├── frontend/           # Application React (Vite / Node.js)
│   ├── src/            # Composants React, API HTTP client, App.jsx
│   ├── public/         # Ressources publiques
│   ├── package.json    # Dépendances NPM
│   └── vite.config.js  # Configuration Vite
├── Cahier des Charges - Flight Manager.pdf
└── README.md
```

---

## ⚙️ Prérequis

Assurez-vous d'avoir installé sur votre environnement :
* **Java JDK 21** (déclaré dans le `JAVA_HOME` et sélectionné via `alternatives` sous Linux/Fedora)
* **Apache Maven 3.8+** (pour le build et le lancement du Back-End)
* **Node.js 18+ & NPM** (pour le Front-End)
* **MariaDB** (serveur local ou conteneur Docker)

---

## 🚀 Guide d'Installation et de Configuration

### 1. Configuration de la Base de Données (MariaDB)

Connectez-vous à votre serveur MariaDB et exécutez la commande SQL suivante pour créer la base de données :

```sql
CREATE DATABASE IF NOT EXISTS flightmanager;
```

### 2. Configuration du Back-End (Spring Boot)

Naviguez dans le dossier `backend` et créez votre fichier de configuration local :

```bash
cd backend
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Éditez `src/main/resources/application.properties` pour renseigner vos identifiants MariaDB :

```properties
# ----- Database Connection -----
spring.datasource.url=jdbc:mariadb://localhost:3306/flightmanager
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# ----- Initialization & Logging -----
spring.sql.init.mode=always
logging.level.fr.univ.orleans.saulas.flightmanager=DEBUG

# ----- OpenAPI / Swagger -----
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

---

## 🖥️ Commandes de Lancement

### Back-End (Java 21 / Maven)

Depuis le répertoire `backend/` :

* **Nettoyer et compiler (avec exécution des tests unitaires) :**
  ```bash
  mvn clean install
  ```

* **Démarrer l'application Spring Boot :**
  ```bash
  mvn spring-boot:run
  ```
  *L'API REST est accessible sur `http://localhost:8080`.*  
  *La documentation Swagger UI est disponible sur `http://localhost:8080/swagger-ui.html`.*

---

### Front-End (React / NPM)

Ouvrez un second terminal et naviguez dans le répertoire `frontend/` :

* **Installer les dépendances NPM :**
  ```bash
  npm install
  ```

* **Démarrer le serveur de développement React (Vite) :**
  ```bash
  npm run dev
  ```
  *L'interface web est accessible sur `http://localhost:5173`.*

---

## 🧪 Synthèse des Commandes Utiles

| Composant | Action | Commande |
| :--- | :--- | :--- |
| **Back-End** | Nettoyer et compiler le projet | `mvn clean install` |
| **Back-End** | Lancer l'API Spring Boot | `mvn spring-boot:run` |
| **Back-End** | Exécuter uniquement les tests | `mvn test` |
| **Front-End** | Installer les paquets Node | `npm install` |
| **Front-End** | Lancer l'application React | `npm run dev` |
| **Front-End** | Générer le build de production | `npm run build` |

---

## 🧑‍💻 Équipe et Contact

* **Chef de Projet & Lead Développeur :** Enzo SAULAS
* **Email :** [enzo.saulas@etu.univ-orleans.fr](mailto:enzo.saulas@etu.univ-orleans.fr)
* **Établissement :** IUT d'Orléans — BUT Informatique