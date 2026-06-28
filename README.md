# Sonata TUI Mobile Automation Framework

## Overview

This project is a mobile automation framework developed for the **TUI Android application** using:

* **Java 17**
* **Maven**
* **Appium Java Client 10.x**
* **Cucumber BDD**
* **TestNG**
* **Page Object Model (POM)**
* **Log4j2**

The framework automates key user journeys of the application and supports execution on:

* **Android Emulator**
* **Real Android Devices**
* **BrowserStack Cloud Devices**

---

# Framework Design

The framework follows industry-standard design patterns and best practices.

## Design Patterns

* **Page Object Model (POM)**
* **Driver Factory Pattern**
* **Thread-safe Driver Management**
* **Cucumber BDD Architecture**
* **Externalized Test Data using JSON**
* **Reusable Utility Classes**

---

# Prerequisites

Before running the framework, ensure the following software is installed:

* **Java 17 or later**
* **Maven 3.9+**
* **Android Studio**
* **Android SDK**
* **Node.js**
* **Appium Server 2.x**

## Verify Installation

### Verify Java

```bash
java -version
```

### Verify Maven

```bash
mvn -version
```

### Verify Node

```bash
node -v
```

### Verify Connected Android Device

Ensure an **Android Emulator** or **Real Android Device** is connected before running the tests.

```bash
adb devices
```

### Verify Appium

```bash
appium -v
```

## Before Running the Framework

Ensure that:

* **Appium Server** is running.
* An **Android Emulator** or **Real Android Device** is connected.
* The required execution mode and device details are configured in **src/test/resources/config/config.properties**.
* BrowserStack credentials are configured if running on BrowserStack.
* The required test data is available in the JSON files under **src/test/resources/testdata**.

---

# Project Setup

## Step 1: Clone the Repository

```bash
git clone https://github.com/dhanyaaautomation/SonataTUIAutomation
```

## Step 2: Open the Project

Open the project in any IDE and allow Maven to download all project dependencies.

---

# Framework Configuration

All execution-related settings are maintained in:

```text
src/test/resources/config/config.properties
```
Update this file before executing the framework.

## Local Execution

Update the following properties:

```properties
mode=local

local.device=emulator-5554
local.app.package=com.tui.qa.challenge
local.app.activity=com.tui.qa.challenge.MainActivity
```

### Note

If you are using a **Real Android Device**, update **local.device** with the device name returned by:

```bash
adb devices
```

## BrowserStack Execution

To execute the tests on BrowserStack, update the following properties:

```properties
mode=bs

browserstack.user=<username>
browserstack.key=<access-key>
browserstack.device=<device-name>
browserstack.os.version=<os-version>
browserstack.app=<BrowserStack App ID>
```

### Note

To switch between **Local** and **BrowserStack** execution, simply update the **mode** property. No code changes are required.

---

# Test Data

The framework uses **externalized JSON test data**, allowing test values to be updated without modifying the automation code.

## JSON File Location

```text
src/test/resources/testdata
```

Update the required JSON files to modify test data such as user inputs.

The framework reads JSON data using the reusable **JsonUtils** utility class.

---

# Logging

The framework uses **Log4j2** for logging.

## Log4j Configuration

```text
src/test/resources/log4j2.xml
```

## Execution Logs

Execution logs are generated at:

```text
Reports/Execution.log
```

---

# Running the Tests

## Step 1: Start the Appium Server

```bash
appium
```

## Step 2: Connect an Android Emulator or Real Device

Verify that the device is connected.

```bash
adb devices
```

## Step 3: Navigate to the Project Directory

Open a terminal or command prompt and navigate to the project root folder.

```bash
cd SonataTUIMobileApp
```

## Step 4: Execute All Tests

```bash
mvn clean test
```

### Execute Smoke Tests

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

### Execute Regression Tests

```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

---

# Test Reports

After execution, the following reports are generated.

## Cucumber Report

```text
target/cucumber-report.html
```

## Execution Log

```text
Reports/Execution.log
```

---

# Future Enhancements

* Add **iOS support** using Appium XCUITest.
* Support **parallel execution** across Android and iOS.
* Integrate with **Jenkins** or **GitHub Actions**.
* Integrate **Extent Reports** with Cucumber.
* Implement a **Retry Mechanism** for flaky tests.
* Capture **screenshots automatically** for failed test cases.

---

# Author

**Dhanyaa N**

**Senior Automation Engineer**