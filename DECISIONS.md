# DECISIONS.md

# Automation Framework Decisions

## 1. Why I Chose This Project Structure

I followed the **Page Object Model (POM)** with a modular architecture to make the framework maintainable, reusable, and scalable. Each package has a single responsibility, making the framework easier to understand and extend.

## Package Structure

* **pages** – Contains Page Object classes with UI locators and page-specific actions.
* **drivers** – Implements the Driver Factory pattern to support both Local and BrowserStack execution.
* **stepdefinitions** – Contains Cucumber step definition classes.
* **hooks** – Handles test setup and teardown using Cucumber hooks.
* **utils** – Provides reusable utility classes such as PropertyUtils, JsonUtils, WaitUtils, ScreenshotUtils, and Log.
* **constants / enums** – Stores application constants and enumerations.
* **resources** – Contains feature files, configuration files, test data, and Log4j configuration.

## Why this structure?

* Promotes code reusability.
* Separates framework and business logic.
* Makes maintenance easier.
* Supports execution on multiple environments.
* Allows new pages and features to be added with minimal changes.

The framework follows industry-standard design patterns and best practices:

- Page Object Model (POM)
- Driver Factory Pattern
- Thread-safe Driver Management
- Externalized Test Data using JSON
- Cucumber BDD Architecture
- Enum-based constants for framework-wide standardization

---

## 2. AI Usage and Corrections

### AI Suggestion On Project Structure

* Suggested a generic Selenium Page Object Model structure.

### Correction Made

* Modified the structure specifically for an Appium mobile automation framework.
* Introduced DriverFactory, DriverManager, LocalDriver, and BrowserStackDriver.
* Added utility classes for logging, configuration, JSON handling, waits, and screenshots.
* Organized Cucumber feature files, hooks, and step definitions separately.

### AI Suggestion On Feature Files

* Generated initial Gherkin scenarios.

### Correction Made

* Removed duplicate scenarios.
* Updated steps to match the actual application flow.
* Improved scenario readability using proper Given/When/Then format.
* Selected scenarios based on business-critical functionality rather than UI coverage alone.

### AI Suggestion On Documentation

* Generated the initial README and DECISIONS document.

### Correction Made

* Updated the documentation to accurately describe the framework architecture.
* Added execution instructions.
* Improved explanations of design decisions.
* Included AI usage and corrections as required.

---

## 3. What I Would Add Given More Time

The following enhancements would improve the framework further:

* Parallel execution across multiple devices
* Cross-platform execution support for Android and iOS using configurable capabilities
* Retry mechanism for flaky tests
* Automatic screenshot capture for failed steps
* Extent Reports integration with Cucumber
* Jenkins or GitHub Actions pipeline
* Failure screenshots embedded into reports

---

## 4. How I would run this in CI with parallel execution across iOS and Android

The current implementation supports **Android automation only**. iOS support has **not** been implemented as part of this assessment. However, the framework uses the **Driver Factory pattern**, making it easy to extend to additional platforms without changing the Page Objects, Step Definitions, or Hooks.

### Current Implementation

* Supports Local Android execution using `LocalDriver`.
* Supports Android cloud execution using `BrowserStackDriver`.
* Uses Driver Factory for driver creation.
* Stores execution settings in `config.properties`.

### How I would add iOS support

To support iOS, I would:

* Create an `IOSLocalDriver` using Appium's `XCUITestOptions`.
* Create an `IOSBrowserStackDriver` for BrowserStack execution.
* Extend the Driver Factory to return Android or iOS drivers based on the configured platform.
* Add iOS capabilities such as device name, platform version, automation name, and app details to the configuration.

### CI/CD Pipeline

I would configure a GitHub Actions or Jenkins pipeline to:

* Checkout the source code.
* Install Java and Maven dependencies.
* Configure BrowserStack credentials.
* Execute Android and iOS tests.
* Generate Cucumber and Extent reports.
* Archive test reports as build artifacts.

### Parallel Execution

Once iOS support is implemented, Android and iOS tests can run in parallel by:

* Running separate Android and iOS jobs.
* Passing platform-specific capabilities through configuration.
* Using the existing ThreadLocal DriverManager for independent driver instances.
* Executing tests simultaneously on BrowserStack.

### Current Limitation

This framework currently automates **Android only**. The CI/CD and parallel execution approach described above outlines how the framework would be extended to support both Android and iOS in the future.


## 5. Why These 5 Scenarios Were Selected

1. Verify Successful Login
Reason:
Login is the primary entry point to the application. If users cannot authenticate successfully, most application functionality becomes inaccessible.

2. Verify User Can Select Date of Birth Using Date Picker
Reason:
The date picker is a key input control used during user registration/profile setup. Mobile applications often encounter issues with date picker interactions across devices and OS versions.

3. Verify Validation When Mandatory Fields Are Empty

Reason:
Validating mandatory fields ensures the application prevents invalid or incomplete data submission and provides appropriate feedback to users.

4. Verify User Can Scroll Through Search Results

Reason:
Search results represent dynamic content that users interact with frequently. Scrolling validates content loading, rendering, and application stability under user interaction.

5. Verify Home Screen Tabs Are Displayed and Accessible

Reason:
The Home screen acts as the primary navigation hub. Users rely on tabs to access different sections of the application.
