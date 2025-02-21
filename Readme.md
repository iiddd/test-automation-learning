# Test automation sandbox

## Contents:
- Test automation sandbox training repo

## Installation:
- Java 22 is required
- Setup as Maven project

## Preconditions:
- Start Docker instance

## Tests:
- Login test

## Run commands:
- ``mvn clean test`` to run tests
- ``mvn allure:serve`` to generate Allure report and start local server (After test run)
- ``mvn allure:report`` to generate Allure report only without local server start (After test run)
- ``mvn clean surefire-report:report`` to run tests and generate surefire report

## Reports:
- Maven-surefire-report-plugin is used as a reporting tool
- Reports can be found in target/reports folder
- Open surefire.html in web browser to see a report
- Allure is added as a primary reporting tool

## Contributors:
- ElKordel
- ElPaniqer
- ElManuya
- ElGelerter