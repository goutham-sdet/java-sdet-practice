# java-sdet-practice
 
[![Java CI with Maven](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml/badge.svg)](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-17-orange)
![Testing](https://img.shields.io/badge/Testing-JUnit5%20%7C%20TestNG-brightgreen)
![Selenium](https://img.shields.io/badge/Selenium-4.25-green)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![Allure](https://img.shields.io/badge/Reporting-Allure-purple)
![WebDriverManager](https://img.shields.io/badge/Driver-WebDriverManager-yellow)
[![Allure Report](https://img.shields.io/badge/Allure_Report-Live-brightgreen?logo=allure&logoColor=white)](https://goutham-sdet.github.io/java-sdet-practice/allure/)
[![API Tests](https://img.shields.io/badge/API-Parallel_4_threads-blue)](#)

This repository documents my transition from QA Engineer to Software Development Engineer in Test (SDET).
 
The project follows a structured roadmap covering Core Java, JUnit 5, TestNG, Selenium WebDriver, Design Patterns, API Testing, and CI/CD.
 
Instead of tutorial code, every implementation focuses on production-style automation practices including Page Object Model, ThreadLocal WebDriver, parallel execution, retry mechanisms, reporting, and GitHub Actions.

---
 
## 🛠️ Tech Stack
 
### Core
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
 
### UI Automation
![Selenium](https://img.shields.io/badge/Selenium-4.18-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.8-FF6C37?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit5-5.10-25A162?style=for-the-badge&logo=junit5&logoColor=white)
 
### API Automation
![RestAssured](https://img.shields.io/badge/REST_Assured-5.4-000000?style=for-the-badge)
![JSON Schema](https://img.shields.io/badge/JSON_Schema-Validator-blue?style=for-the-badge)
![WireMock](https://img.shields.io/badge/WireMock-Mocking-orange?style=for-the-badge)
 
### Framework & Design
![POM](https://img.shields.io/badge/Page_Object_Model-Implemented-success?style=for-the-badge)
![Parallel](https://img.shields.io/badge/Parallel-4_Threads-informational?style=for-the-badge)
 
### DevOps & CI/CD
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-CI/CD-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)
 
### Reporting & Logging
![Allure](https://img.shields.io/badge/Allure-Report-FF4F8B?style)

---

## 📂 Repository Structure
 
This repository includes practical implementations covering:
 
### ☕ Core Java
- OOP Concepts
- Collections Framework
- Exception Handling
- File Handling
- Java 8 Features
- Multithreading
- Coding Practice
 
### 🌐 UI Automation
- Selenium WebDriver
- Web Elements
- Wait Strategies
- Frames
- Windows
- Alerts
- Actions Class
- JavaScript Executor
- Page Object Model (POM)
- Data-Driven Testing
 
### 🔗 API Automation
- REST Assured
- CRUD Operations
- Authentication
- Serialization & Deserialization
- JSON Schema Validation
- Request & Response Validation
 
### 🧪 Test Frameworks
- TestNG
- JUnit 5
- Assertions
- Annotations
- Listeners
- Parallel Execution
 
### ⚙️ Build & DevOps
- Maven
- Docker (Basics)
- GitHub Actions (CI)

---

## 📊 Current Stats 
 
| **Metric** | **Value** |
|------------|-----------|
| **Total Automated Tests** | **31+** (12 API • 19 UI) |
| **Java Classes** | 45+ |
| **Framework Layers** | 8 (POM, API Base, Utils, Listeners, DataFactory, Config, POJO, Schemas) |
| **Execution Time** | API suite: ~35s (parallel 4 threads) |
| **CI/CD Pipelines** | 2 (Maven Tests + Docker Build) |
| **Test Data Strategy** | JSON + JavaFaker (zero hardcoding) |
| **Reporting** | Allure with steps, retries, screenshots |
| **Build Success** | 100% (last 10 runs) |
 
### ✅ What Works Today
- **API Automation:** RestAssured with Specs, Chaining, OAuth2, JWT, Schema Validation, WireMock, POJO, Data-Driven
- **UI Automation:** Selenium 4 POM, Explicit/Fluent Waits, Actions, JSExecutor, ShadowDOM, Frames/Alerts, Windows
- **Framework:** TestNG Parallel, RetryAnalyzer, TestListener, ConfigManager, TokenManager
- **DevOps:** GitHub Actions on every push, Dockerized test execution, Maven cache
- **Core Java:** 8 DSA basics (Factorial, Fibonacci, Palindrome, etc.) + OOP (BankAccount)

---

## 👨‍💻 About Me
 
**Goutham T**
 
Test Engineer with 3 years of experience in Manual + Automation Testing at LG Soft India, continuosly transitioning into an SDET role by building hands-on automation projects and continuously improving software engineering skills.
 
LinkedIn:
https://www.linkedin.com/in/goutham-t-5a20ba279
 
GitHub:
https://github.com/goutham-sdet

### How to Run
 
```bash
# Clone
git clone https://github.com/goutham-sdet/java-sdet-practice.git
cd java-sdet-practice
 
# Run ALL tests (JUnit5 + TestNG)
mvn clean test
 
# Run only JUnit5 tests
mvn test -Dtest="*Test"
 
# Run only TestNG suite (with listeners & retry)
mvn test -DsuiteXmlFile=testng.xml
 
# Run single test (JUnit example)
mvn test -Dtest=BankAccountTest
 
# Run single TestNG test with data-provider
mvn test -Dtest=LoginTestNG
 
# Run UI suite only (parallel, headless)
mvn test -Dtest=LoginTest,LocatorsDeepDiveTest,ExplicitWaitTest,FluentWaitTest,DropdownTest,HoverTest,FrameSwitchTest
 
# Generate Allure report after run
mvn allure:serve


