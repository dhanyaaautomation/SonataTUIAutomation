# Sonata TUI Mobile Automation Framework

## Overview

This project is a mobile test automation framework developed using:

* Appium Java Client 10.x
* Java 17
* Maven
* Cucumber BDD
* TestNG
* Page Object Model (POM)

The framework automates critical user journeys of the TUI Challenge Android application and is designed to run on:

* Android Emulator
* Real Android Devices
* BrowserStack Cloud Devices

---

## Framework Design

### Design Patterns

* Page Object Model (POM)
* Driver Factory Pattern
* Externalized Test Data using JSON
* Reusable Utility Classes
* Cucumber BDD Layer

## Automated Test Scenarios

The following 5 scenarios were selected to provide maximum confidence in a release:

### Login Module

1. Verify successful login using valid credentials
2. Verify user can select Date of Birth using date picker
3. Verify validation messages for mandatory fields

### Home Module

4. Verify user can scroll through search results without application crash
5. Verify Home screen tabs (All, Hotels, Holidays) are displayed and accessible

These scenarios cover:

* Application launch
* User authentication
* Form validation
* Core navigation
* Stability during scrolling
* Key business functionality

---

## Prerequisites

Install the following:

* Java 17+
* Maven 3.9+
* Android Studio
* Android SDK
* Appium Server 2.x

Verify installation:

java -version

mvn -version

adb devices

appium -v

---

## Project Setup

Clone repository:

git clone <repository-url>

Navigate to project:

cd SonataTUIMobileApp

Place application APK under:

src/test/resources/apps/

Update configuration if required:

src/test/resources/config/config.properties

---

## Running Tests

Execute all scenarios:

mvn clean test

Execute only smoke tests:

mvn clean test -Dcucumber.filter.tags="@smoke"

Execute only regression tests:

mvn clean test -Dcucumber.filter.tags="@regression"

---

## Reports

After execution, Cucumber HTML report is generated at:

target/cucumber-report.html

Open the report in a browser to review execution results.

---

## BrowserStack Support

The framework supports execution on BrowserStack cloud devices through the BrowserStackDriver implementation.

Update BrowserStack capabilities and credentials before execution.

Change the mode to BS in config.properties file

---

## Assumptions

* Application APK is available under resources/apps.
* Android emulator or real device is connected before execution.
* Appium server is running before test execution.

---

## Author
Dhanyaa N

Senior Automation Engineer

Specialization:
* Selenium
* Appium
* Mobile Automation
* Test Framework Development
