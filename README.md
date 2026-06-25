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

> 45-day SDET journey: Java → JUnit → Selenium → TestNG → API → CI/CD
 
A hands-on repository documenting my daily progress from manual tester to SDET, with production-grade code, unit tests, and automated CI. All tests run headless in GitHub Actions.

## 🗓️ 45-Day SDET Learning Journey

Each day = working code + CI proof.  Focus: production patterns, not tutorials.
 
---
 
### Tech Stack
- **Language:** Java 17
- **Build:** Maven 3.9
- **Testing:** JUnit 5 (Parameterized) + TestNG 7.9.0 (Parallel, DataProvider, Listeners)
- **UI Automation:** Selenium 4.25.0 + Chrome Headless + WebDriverManager
- **Framework Patterns:** Page Object Model, ThreadLocal WebDriver, RetryAnalyzer, ITestListener
- **Reporting:** Allure Framework
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

### ✅ Day 13
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
 
### ✅ Day 14
**Focus:** Data-driven testing & test design
**What I did:**
- Added `junit-jupiter-params:5.10.2` dependency to pom.xml
- Built `LoginDataDrivenTest` using JUnit5 `@ParameterizedTest` + `@CsvSource`
- Covered 3 login scenarios in one method: valid, invalid password, invalid username
- Refactored all page objects to accept `WebDriver` via constructor (POM best practice)
- Made all test methods `public void` for reliable Maven Surefire discovery
- **Commit:** `feat: implement data-driven login with parameterized tests`

### ✅ Day 15 – JUnit5 Extensions & Screenshot on Failure
**Topic:** JUnit5 Parallel Execution, Custom Extensions, Screenshot Utility
 
**What I Learned:**
- JUnit5 `@RegisterExtension` vs TestNG Listeners
- How to implement `AfterTestExecutionCallback` for auto-screenshots
- Maven Surefire parallel config (`junit.jupiter.execution.parallel.enabled=true`)
- Thread-safety issues with static WebDriver in parallel runs
- Using WebDriverManager to resolve driver version mismatches
 
**Practical Work:**
- Created `ScreenshotWatcher` class implementing `AfterTestExecutionCallback`
- Built `ScreenshotUtil.takeScreenshot()` to save PNGs to `target/screenshots/`
- Added `ScreenshotTest` to validate failure capture (intentional assert)
- Fixed `LocatorsDeepDiveTest` – added WebDriverManager setup, corrected `By.className("heading*")` to `By.cssSelector("h1.heading")`
- Configured `junit-platform.properties` for parallel methods
 
**Key Code:**
- `src/test/java/oop/junit/ScreenshotTest.java`
- `src/test/java/oop/junit/utils/ScreenshotWatcher.java`
- `src/test/resources/junit-platform.properties`
 
**Outcome:**
- All 34 JUnit tests run in parallel without `DevToolsActivePort` errors
- Screenshots automatically saved on failure for debugging
- Foundation ready for TestNG migration (Day 16)
 
**Commit:** `test(junit): add screenshot extension and fix parallel execution issues`

### ✅ Day 16 – TestNG Framework Integration (Parallel Execution)
 
**What I did:**
- Kept existing JUnit5 tests intact — added TestNG 7.9.0 alongside (no breaking changes)
- Added `allure-testng` dependency for unified reporting
- Configured `maven-surefire-plugin 3.2.5` with both `junit-platform` and `testng` providers
- Created `testng.xml` suite with `parallel="methods" thread-count="4"`
- Built `BaseTestNG` with `ThreadLocal<WebDriver>` for thread-safe parallel runs
- Simplified ChromeOptions (removed UUID user-data-dir) to fix `DevToolsActivePort` errors
- Migrated `Login` test to TestNG using `@DataProvider(parallel = true)`
- **Result:** `mvn clean test` → 34 JUnit + 2 TestNG tests, 100% pass
 
**Commit:** `feat(testng): add TestNG framework alongside JUnit5 for parallel execution`
 
---
### ✅ Day 17 – TestNG Advanced: Listeners & Retry Analyzer
 
**What I did:**
- Implemented `IRetryAnalyzer` (RetryAnalyzer.java) – auto-retries flaky tests up to 2 times
- Implemented `ITestListener` (TestListener.java) – captures screenshot on failure and attaches to Allure
- Fixed access issue: changed `BaseTestNG.getDriver()` from `protected` to `public` for cross-package listener
- Updated `testng.xml` to register listeners
- Added retry to `@Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)`
- Cleaned repo: removed accidentally committed `.allure/` binaries, updated `.gitignore` for `allure-results/`, `allure-report/`, `.allure/`
- **Result:** CI pipeline green, data-driven login runs twice (valid + invalid) with parallel safety
 
**Commit:** `feat(testng): add RetryAnalyzer and ITestListener for auto-retry and screenshots`
 
---
### 🔧 Fixes Applied (during Day 16-17)
- Fixed `LocatorsDeepDiveTest` timeout – added WebDriverManager, removed invalid `By.className("heading*")` → `By.cssSelector("h1.heading")`
- Fixed `ScreenshotTest` intentional failure for CI stability
- Resolved Chrome 148 CDP warnings by standardizing ChromeOptions

### 📊 Current Stats (Day 17)
 
| Metric | Status |
| --- | --- |
| **Languages** | Java 17 |
| **Build Tool** | Maven |
| **Unit Testing** | JUnit 5 + TestNG 7.9.0 (Dual Framework) |
| **UI Automation** | Selenium 4.25 + Chrome Headless + WebDriverManager |
| **CI/CD** | GitHub Actions ✅ |
| **Tests in CI** | 36 (34 JUnit + 2 TestNG data-driven) ✅ |
| **Locators Mastered** | 9: id, name, css, xpath, linkText, partialLinkText, tagName, className, attribute |
| **SDET Practices** | ThreadLocal driver, parallel execution, RetryAnalyzer, ITestListener, Allure reporting, explicit waits, Actions chains, frame/alert/window handling, conventional commits |

---

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
