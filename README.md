# java-sdet-practice
 
[![Java CI](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml/badge.svg)](https://github.com/goutham-sdet/java-sdet-practice/actions/workflows/maven.yml)
 
> 45-day SDET journey: Java → Selenium → TestNG → API → CI/CD
 
A hands-on repository documenting my daily progress from manual tester to SDET, with production-grade code, unit tests, and automated CI.
 
---
 
### Tech Stack
- **Language:** Java 17
- **Build:** Maven
- **Testing:** JUnit 5
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
