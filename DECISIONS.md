# DECISIONS.md

# Automation Framework Decisions

## 1. Why I Chose This Project Structure

The framework follows a layered design using Page Object Model (POM) and uses a Driver Factory pattern to allow execution on local devices, emulators, and BrowserStack cloud devices.

Reasons for this structure:

* Improves maintainability and readability
* Keeps locators separate from test logic
* Encourages code reuse
* Simplifies onboarding for new contributors
* Supports future scalability for additional screens and platforms

The framework follows industry-standard design patterns and best practices:

- Page Object Model (POM)
- Driver Factory Pattern
- Thread-safe Driver Management
- Externalized Test Data using JSON
- Cucumber BDD Architecture
- Enum-based constants for framework-wide standardization

---

## 2. AI Usage and Corrections

AI tools were used as an assistant during framework development for:

* Initial project structure suggestions
* Cucumber feature file drafting
* README documentation generation
* Maven dependency validation

---

## 3. What I Would Add Given More Time

The following enhancements would improve the framework further:

* Extent Reports integration
* Jenkins Integration
* Failure screenshots embedded into reports
* Parallel execution support across multiple devices
* Cross-platform execution support for Android and iOS using configurable capabilities

---

## 4. CI Execution with Parallel Android and iOS Runs

For CI execution, I would use Jenkins integrated with BrowserStack.
To support parallel execution across Android and iOS, I would use BrowserStack cloud devices with separate device configurations for each platform.

The framework uses a Driver Factory and thread-safe driver management, allowing multiple Appium sessions to run independently.

Execution approach:

* Configure BrowserStack capabilities for Android and iOS devices.
* Create separate platform configurations for Android and iOS.
* Start independent Appium sessions for each platform.
* Execute the same Cucumber feature files against both platforms simultaneously.
* Generate separate execution reports for each platform.


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
