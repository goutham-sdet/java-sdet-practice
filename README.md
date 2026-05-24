# java-sdet-practice
 
[![CI](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml/badge.svg)](https://github.com/goutham-sdet/java-sdet-practice/actions)
![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Selenium](https://img.shields.io/badge/UI-Selenium_4.21-green)
![TestNG](https://img.shields.io/badge/Testing-TestNG-red)
 
> 45-day SDET journey: Java → JUnit → Selenium → TestNG → API → CI/CD
 
A hands-on repository documenting my daily progress from manual tester to SDET, with production-grade code, unit tests, and automated CI. All tests run headless in GitHub Actions.

## 🗓️ 45-Day SDET Learning Journey

Each day = working code + CI proof.  Focus: production patterns, not tutorials.
 
---
 
### Tech Stack
- **Language:** Java 17
- **Build:** Maven
- **Testing:** JUnit 5 (Parameterized)
- **CI/CD:** GitHub Actions
- **IDE:** IntelliJ IDEA
 
---
 
### Progress Tracker
 
#### ✅ Day 1: Environment Setup
- JDK 17 installed and configured
- IntelliJ IDEA + Maven project initialized
- Git + GitHub connected
- First Java program running
 
#### ✅ Day 2: Project Structure Cleanup
- Fixed nested folder issue (`java-sdet-practice/java-sdet-practice`)
- Created proper Maven standard layout
- Added `.gitignore` for Java/Maven/IntelliJ
 
#### ✅ Day 3: Core Java OOP
- Implemented `BankAccount` class (encapsulation, deposit, withdraw)
- Created `MainTransaction` demo runner
- Practiced constructors, methods, and validation logic
 
#### ✅ Day 4: Unit Testing with JUnit 5
- Added `BankAccountTest` with 4 independent tests:
    - `depositIncreasesBalance`
    - `withdrawDecreasesBalance`
    - `overdrawIsPrevented`
    - `negativeDepositIsIgnored`
- All tests run via `mvn test`
 
#### ✅ Day 5: Continuous Integration
- Added GitHub Actions workflow (`.github/workflows/maven.yml`)
- Automated build on every push to `main`
- First green build achieved
 
#### ✅ Day 6: CI Validation
- Intentionally broke a test to verify CI failure detection
- Fixed and restored green pipeline
- Proved end-to-end TDD workflow

#### ✅ Day 7: Data-Driven Testing with Parameterized Tests
- **Refactored** `BankAccountTest` from 4 separate methods to 2 data-driven tests
- Implemented JUnit 5 `@ParameterizedTest` with `@CsvSource`
- Now covers **9 scenarios** (deposits, withdrawals, overdrafts, negatives) with zero code duplication
- Learned core SDET pattern: one test logic, many data sets
- CI updated automatically — `mvn test` reports 9/9 passing

#### ✅ Day 8: First Selenium Test + Headless Chrome for CI**  
- `GoogleTest`: browser automation smoke check
- `ChromeOptions` tuned for CI: `--headless=new`, `--no-sandbox`, `--disable-dev-shm-usage`
- Defensive `@AfterEach`: `if (driver != null) driver.quit()` prevents resource leaks

#### ✅ Day 9: Locators Deep Dive – 9 Strategies, 2 Programs**  
- `LoginTest`: id, name, cssSelector, xpath with valid/invalid flows
- `LocatorsDeepDiveTest`: linkText, partialLinkText, tagName, className, attribute CSS
- **Debugging win:** Fixed `partialLinkText` ambiguity by targeting specific text
- **SDET habit:** Assertions check URL/element text, never static page titles


### 📊 Current Stats (Day 9)
| Metric | Status |
| --- | --- |
| **Languages** | Java 17 |
| **Build Tool** | Maven |
| **Unit Testing** | JUnit 5 |
| **UI Automation** | Selenium 4.21 + Chrome Headless |
| **CI/CD** | GitHub Actions ✅ |
| **Tests in CI** | 6 (2 unit, 4 UI) ✅ |
| **Locators Mastered** | 9: id, name, css, xpath, linkText, partialLinkText, tagName, className, attribute |
| **SDET Practices** | Defensive teardown, CI-specific flags, conventional commits |

---
 
### How to Run
```bash
# Clone
git clone https://github.com/goutham-sdet/java-sdet-practice.git
cd java-sdet-practice
 
# Run all tests
mvn test
 
# Run single test
mvn test -Dtest=BankAccountTest
