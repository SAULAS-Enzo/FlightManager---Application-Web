# CAHIER DES CHARGES — FLIGHT MANAGER (IVAO)
**Document de cadrage projet & compétences BUT Informatique**
**Version 1.2**

---

## 1. PRÉSENTATION DU PROJET & ÉQUIPE

### Équipe de Développement
- **Chef de Projet & Lead Développeur :** Enzo SAULAS
- **Contact :** enzo.saulas@etu.univ-orleans.fr
- **Établissement :** Université d'Orléans — IUT Informatique
- **Réseau Cible :** IVAO (International Virtual Aviation Organisation)

### Objectifs Académiques
Le projet **Flight Manager** vise à réunir et valider l'ensemble des compétences développées durant le BUT Informatique à travers la réalisation d'une application web fullstack dédiée aux pilotes virtuels sur le réseau IVAO.

### Livrables Prévus & Documentation Future
1. **Cahier des Charges :** Document de cadrage technique et fonctionnel (Présent document).
2. **Dossier des Spécifications Techniques (DST) :** Documentation d'architecture détaillée, schémas de base de données (MCD/MLD) et règles métier.
3. **Manuel Utilisateur :** Guide d'utilisation et de prise en main de l'interface pour les pilotes.

---

## 2. GESTION DE PROJET & MÉTHODOLOGIE

- **Développement Agile :** Découpage du travail en Sprints Agiles avec ajustements continus.
- **Gestion des Tâches :** Suivi des fonctionnalités et retours via **GitHub Issues**.
- **Tableau de Bord :** Pilotage du flux de développement sur un **Kanban GitHub Projects** (To Do, In Progress, Review, Done).
- **Gestion de Version :** Contrôle de code source sous **Git** avec structuration des branches (Gitflow).
- **Dépôt Distant :** Hébergement et stockage centralisé sur **GitHub**.

---

## 3. ARCHITECTURE TECHNIQUE & DÉPLOIEMENT

| Couche | Technologie / Outil | Gestionnaire de dépendances | Rôle & Environnement |
| :--- | :--- | :--- | :--- |
| **Front-End** | React.js (HTML, CSS, JS ES6+) | **NPM** | Interface Single Page Application (SPA) réactive. |
| **Back-End** | Java 21 (Spring Boot) | **Apache Maven** | API RESTful HTTP et logique applicative métier. |
| **Accès Données**| JDBC Native (Pattern DAO) | Driver JDBC MariaDB | Exécution de requêtes SQL préparées (`PreparedStatement`). |
| **Base de Données**| MariaDB (MySQL Open-Source) | SQL Standard | Stockage relationnel persistant (100% gratuit). |
| **Déploiement** | Docker & Kubernetes | Manifests / Helm | Conteneurisation et orchestration des services. |

*Note : L'utilisation de Maven est exclusivement réservée au Back-End Java et NPM au Front-End React. L'infrastructure repose sur des briques open-source gratuites.*

---

## 4. ARBORESCENCE DES MENUS & FONCTIONNALITÉS
*(Note : L'organisation ci-dessous est donnée à titre indicatif et reste **sujet à modifications** au cours des Sprints du projet).*

| Menu Principal | Sous-Menu / Option | Fonctionnalités & Détails Opérationnels |
| :--- | :--- | :--- |
| **1. Opérationnel** *(Préparation & Suivi de vol)* | Vue d'ensemble du vol | Visualisation synthétique des paramètres de vol et météo rapide. |
| | Communication ATC | Bloc-notes pour les clairances ATC (Mise en route, taxi, montée) & suivi des fréquences. |
| | Informations ATIS | Consultation des données ATIS (Pistes en service, QNH, transition). |
| | Plan de Vol (FPL) | Saisie du plan de vol OACI complet (Champs 7 à 19), export `.fpl` et intégration Webeye. |
| | Calculateur & PTA | Calculs de carburant, Top of Descent (TOD), performances et fiches PTA. |
| | Cartes VAC | Consultation directe des cartes d'atterrissage à vue (SIA/IGN). |
| **2. Encyclopédie** *(Base de connaissances)* | Fiches VFR / IFR / Mémos | Fiches théoriques sur les régimes de vol, règles de l'air et procédures. |
| | Fiches Favorites | Accès direct aux fiches mises en favoris par l'utilisateur. |
| | Importation & Signalement | Importation de fiches personnelles PDF et signalement de fiches obsolètes. |
| **3. Quizz** *(Entraînement aux examens)* | QCM FS1 / FS2 / FS3 | Entraînement progressif aux ratings de pilote IVAO. |
| | Examens PP / SPP / CP | Mises en situation pour les examens Private Pilot, Senior PP et Commercial Pilot. |
| **4. Profil & Gestion** *(Compte utilisateur)* | Gestion du Hangar | Configuration des avions (Indicatif, catégorie de turbulence, équipements OACI, transpondeur). |
| | Historique & Plans de Vol | Sauvegarde des anciens plans de vol et gestion des vols futurs. |

---

## 5. MATRICE DES COMPÉTENCES BUT INFORMATIQUE

- **C1 - Développer :** Conception d'une interface React réactive et mise en place d'une API REST Java 21.
- **C2 - Optimiser :** Optimisation des requêtes SQL et structuration algorithmique des calculs de vol.
- **C3 - Administrer :** Déploiement conteneurisé via Docker et orchestration Kubernetes.
- **C4 - Gérer la donnée :** Structuration du schéma relationnel MariaDB et accès natif JDBC sécurisé.
- **C5 - Conduire un projet :** Pilotage Agile, gestion du Kanban/Issues GitHub et redaction des DST et Manuels.
- **C6 - Collaborer :** Travail sous Git, respect des standards de développement et documentation logicielle.