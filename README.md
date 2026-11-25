<div align="center">
  <h1>Flight Manager</h1>
  <p><strong>Application web full-stack conçue pour les pilotes de simulation aérienne sur le réseau IVAO</strong></p>
  <p><em>Projet développé dans le cadre du BUT Informatique — IUT d'Orléans</em></p>

  <p>
    <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21" />
    <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB" alt="React" />
    <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white" alt="MariaDB" />
  </p>

  <p>
    <a href="https://github.com/SAULAS-Enzo/FlightManager---Application-Web">Dépôt GitHub</a> •
    <a href="https://github.com/SAULAS-Enzo/FlightManager---Application-Web/projects">Kanban & Issues</a> •
    <a href="https://www.ivao.fr/fr">IVAO France</a>
  </p>
</div>

---

## Architecture Technique

Le schéma ci-dessous illustre le fonctionnement global et les flux de données de l'application :

```mermaid
graph LR
    User([👨‍✈️ Pilote IVAO]) -->|Navigation Web| Front[⚛️ Front-End React<br/>Vite • Port 5173]
    Front -->|Requêtes HTTP / JSON| Back{🍃 API REST Spring Boot<br/>Java 21 • Port 8080}
    Back -->|Spring Data JDBC| DB[(🗄️ Base de données<br/>MariaDB / MySQL)]
    Back -.->|Documentation| Swagger[📄 Swagger UI<br/>/swagger-ui.html]
    Back -.->|Données Aéronautiques| IVAO[🌐 Réseau IVAO]

---

## Stack Technique
 - Front-End : React.js, HTML5, CSS3, JavaScript ES6+ (Vite / NPM)
 - Back-End : Java 21, Spring Boot, Spring Data JDBC, OpenAPI / Swagger (Maven)
 - Base de Données : MariaDB / MySQL
 - Méthodologie & DevOps : Agile (Kanban & Issues GitHub), Git, Docker & Kubernetes

---
## Structure du Projet

```Plaintext
FlightManager---Application-Web/
├── backend/                   # Projet Spring Boot (API REST Java 21)
│   ├── src/main/java          # Code source Java (Controller, DTO, Model, Repository, Service)
│   ├── src/main/resources     # Configuration (application.properties, templates, static)
│   ├── pom.xml                # Configuration Maven & Dépendances
│   └── HELP.md
├── frontend/                  # Application React (Vite / Node.js)
│   ├── src/                   # Composants React, client HTTP API, App.jsx
│   ├── public/                # Ressources publiques
│   ├── package.json           # Dépendances NPM
│   └── vite.config.js         # Configuration Vite
├── Cahier des Charges - Flight Manager.pdf
└── README.md
```

---
## Prérequis

Assurez-vous d'avoir installé sur votre environnement :

 - Java JDK 21 (déclaré dans le JAVA_HOME et sélectionné via alternatives sous Linux/Fedora)
 - Apache Maven 3.8+ (pour le build et le lancement du Back-End)
 - Node.js 18+ & NPM (pour le Front-End)
 - MariaDB (serveur local ou conteneur Docker)

---
## Guide d'Installation et de Configuration
1. Configuration de la Base de Données (MariaDB)
Connectez-vous à votre serveur MariaDB pour créer la base de données et exécuter vos scripts d'initialisation :

```bash
# Se connecter à MariaDB
mysql -u root -p

-- Créer la base de données
CREATE DATABASE IF NOT EXISTS flightmanager;
USE flightmanager;
```
2. Configuration du Back-End (Spring Boot)
Naviguez dans le dossier backend et créez votre fichier de configuration local :
```bash
cd backend
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Éditez src/main/resources/application.properties pour renseigner vos identifiants MariaDB :
```Properties
# ----- Database Connection -----
spring.datasource.url=jdbc:mariadb://localhost:3306/flightmanager
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# ----- Logging & Debug -----
logging.level.fr.univ.orleans.saulas.flightmanager=DEBUG

# ----- OpenAPI / Swagger -----
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

## Commandes de Lancement
### Back-End (Java 21 / Maven)
Depuis le répertoire backend/ :

Nettoyer et compiler (avec exécution des tests unitaires) :

```bash
mvn clean install
```


Démarrer l'application Spring Boot :

```bash
mvn spring-boot:run
```

L'API REST est accessible sur http://localhost:8080.

La documentation interactive Swagger UI est disponible sur http://localhost:8080/swagger-ui.html.

### Front-End (React / NPM)
Ouvrez un second terminal et naviguez dans le répertoire frontend/ :

Installer les dépendances NPM :

```bash
npm install
```

Démarrer le serveur de développement React (Vite) :

```bash
npm run dev
```

L'interface web est accessible sur http://localhost:5173.

Créer la version finale optimisée du site :

```bash
npm run build
```

Tester la version buildée localement :

```bash
npm run preview
```

