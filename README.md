# java-sdet-practice
 
[![CI](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml/badge.svg)](https://github.com/goutham-sdet/java-sdet-practice/actions)
![Java](https://img.shields.io/badge/Java-17-orange)
![JUnit 5](https://img.shields.io/badge/Testing-JUnit_5-25A162?logo=junit5&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.25-green)
![Maven](https://img.shields.io/badge/Build-Maven-blue)

> 45-day SDET journey: Java → JUnit → Selenium → TestNG → API → CI/CD
 
A hands-on repository documenting my daily progress from manual tester to SDET, with production-grade code, unit tests, and automated CI. All tests run headless in GitHub Actions.

## 🗓️ 45-Day SDET Learning Journey

Each day = working code + CI proof.  Focus: production patterns, not tutorials.
 
---
 
### Tech Stack

- **Language:** Java 17
- **Build:** Maven
- **Testing:** JUnit 5 (Parameterized)
- **UI Automation:** Selenium 4.25.0 + Chrome Headless
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
- Added GitHub Actions workflow `.github/workflows/maven.yml`
- Automated build on every push to `main`
- First green build achieved

#### ✅ Day 6: CI Validation
- Intentionally broke a test to verify CI failure detection
- Fixed and restored green pipeline
- Proved end-to-end TDD workflow

#### ✅ Day 7: Data-Driven Testing with Parameterized Tests
- **Refactored** `BankAccountTest` from 4 separate methods to 2 data-driven tests
- Implemented JUnit 5 `@ParameterizedTest` with `@CsvSource`
- Now covers **9 scenarios** with zero code duplication
- CI updated automatically — `mvn test` reports 9/9 passing

#### ✅ Day 8: First Selenium Test + Headless Chrome for CI
- `GoogleTest` / `LoginTest`: browser automation smoke check
- `ChromeOptions` tuned for CI: `--headless=new`, `--no-sandbox`, `--disable-dev-shm-usage`
- Defensive `@AfterEach`: `if (driver != null) driver.quit()` prevents resource leaks

#### ✅ Day 9: Locators Deep Dive – 9 Strategies
- `LoginTest`: id, name, cssSelector, xpath with valid/invalid flows
- `LocatorsDeepDiveTest`: linkText, partialLinkText, tagName, className, attribute CSS
- **Debugging win:** Fixed `partialLinkText` ambiguity by targeting specific text
- **SDET habit:** Assertions check URL/element text, never static page titles

#### ✅ Day 10: Waits – Explicit & Fluent
- **ExplicitWaitTest:** `visibilityOfElementLocated`, `elementToBeClickable`, `textToBePresent`
- **FluentWaitTest:** custom polling 500ms, ignoring `NoSuchElementException`, lambda conditions
- Replaced all flaky `findElement` calls with `WebDriverWait`
- **Key learning:** Explicit wait solves 95% of timing issues; never use `Thread.sleep`

#### ✅ Day 11: Actions Class & Select Dropdowns
- **DropdownTest:** `Select` with `selectByVisibleText`, `selectByValue`, `getOptions`, `isMultiple`
- **MouseHoverTest:** `moveToElement` with pause, `dragAndDrop`, `contextClick`
- **Debugging win:** Headless hover failed → fixed by targeting inner `<img>` + 800ms pause for CSS transition
- All action tests stable in CI

#### ✅ Day 12: Frames, Alerts & Windows
- **FramesAlertsTest:**
    - `switchTo().frame()` and `defaultContent()` verified
    - JS Alert accept, Confirm dismiss, Prompt sendKeys with `alertIsPresent()`
    - **Real-world fix:** TinyMCE hit read-only quota on herokuapp → migrated iframe test to stable `demoqa.com/frames`
    - Replaced `clear()` on contenteditable with `Ctrl+A` + `Delete` via Actions
- **WindowHandlesTest:**
    - `getWindowHandles()` loop, `switchTo().window()`, `close()` and return to parent
- Context switching always guarded by explicit waits

### ✅ Day 13 – 31 May 2026
**Focus:** Framework foundation – centralized driver management
**What I did:**
- Created `BaseTest.java` with `@BeforeEach` / `@AfterEach` lifecycle
- Integrated **WebDriverManager 5.8.0** for automatic driver binaries
- Added headless Chrome support for CI (`--headless=new`, `--no-sandbox`, `--disable-dev-shm-usage`)
- Implemented unique Chrome profile per thread to fix `DevToolsActivePort` errors:
    - `UUID.randomUUID()` for `--user-data-dir`
    - Random `--remote-debugging-port` (9222-11222)
- Set implicit wait to 0, enforcing explicit waits only
- **Commit:** `feat: add BaseTest with parallel-safe Chrome options`
 
### ✅ Day 14 – 01 June 2026
**Focus:** Data-driven testing & test design
**What I did:**
- Added `junit-jupiter-params:5.10.2` dependency to pom.xml
- Built `LoginDataDrivenTest` using JUnit5 `@ParameterizedTest` + `@CsvSource`
- Covered 3 login scenarios in one method: valid, invalid password, invalid username
- Refactored all page objects to accept `WebDriver` via constructor (POM best practice)
- Made all test methods `public void` for reliable Maven Surefire discovery
- **Commit:** `feat: implement data-driven login with parameterized tests`

### 📊 Current Stats (Day 12)

| Metric | Status |
| --- | --- |
| **Languages** | Java 17 |
| **Build Tool** | Maven |
| **Unit Testing** | JUnit 5 Parameterized |
| **UI Automation** | Selenium 4.25 + Chrome Headless |
| **CI/CD** | GitHub Actions ✅ |
| **Tests in CI** | 20+ (9 unit scenarios + 11 UI) ✅ |
| **Locators Mastered** | 9: id, name, css, xpath, linkText, partialLinkText, tagName, className, attribute |
| **SDET Practices** | Defensive teardown, explicit waits, Actions chains, frame/alert/window handling, conventional commits |

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

# Run UI suite only
mvn test -Dtest=LoginTest,LocatorsDeepDiveTest,ExplicitWaitTest,FluentWaitTest,DropdownTest,MouseHoverTest,FramesAlertsTest,WindowHandlesTest
