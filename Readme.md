# Test automation sandbox

## Description:
A training project on automated testing. As part of the project, students learn Java and testing tools such as Selenium,
reporting tools (Surefire, Allure), Cucumber, SQL, and API from scratch. The pre-prepared Puppy Bank environment is used as 
a test environment (created by Vince Reyes and modified for work with the backend by Andrey Merkulov).

## Contents:
- Test automation sandbox training repo

## Installation:
- Java 22 is required
- Setup as Maven project
- Latest version of Google Chrome

### Plugins:
- Docker
- Lombok
- Cucumber for Java
- Gherkin

## Preconditions:
- Start Docker instance

## Project architecture:
- All constants and variables are moved outside of methods
- Methods are contained in separate classes

## Tests:

<details>
<summary>List of Login Page tests:</summary>

- [Happy flow login test](src/test/java/org/example/tests/puppy/login/LoginTest.java)
- [Empty credentials test](src/test/java/org/example/tests/puppy/login/EmptyCredentialsTest.java)
- [Empty login field test](src/test/java/org/example/tests/puppy/login/EmptyLoginTest.java)
- [Empty password field test](src/test/java/org/example/tests/puppy/login/EmptyPasswordTest.java)
- [Wrong credentials test](src/test/java/org/example/tests/puppy/login/WrongCredentialsTest.java)
- [Wrong login test](src/test/java/org/example/tests/puppy/login/WrongLoginTest.java)
- [Wrong password test](src/test/java/org/example/tests/puppy/login/WrongPasswordTest.java)
- [Layout login page test](src/test/java/org/example/tests/puppy/login/LoginLayoutTest.java)
</details>
<details>
<summary>List of Registration Page tests:</summary>

- [Happy flow registration test](src/test/java/org/example/tests/puppy/registration/RegistrationHappyFlowTest.java)
- [Empty username field test](src/test/java/org/example/tests/puppy/registration/RegistrationEmptyUsernameFieldTest.java)
- [Empty password field test](src/test/java/org/example/tests/puppy/registration/RegistrationEmptyPasswordFieldTest.java)
- [Empty repeat password field test](src/test/java/org/example/tests/puppy/registration/RegistrationEmptyRepeatPasswordFieldTest.java)
- [Different passwords test](src/test/java/org/example/tests/puppy/registration/RegistrationDifferentPasswordsTest.java)
- [Only digits in password test](src/test/java/org/example/tests/puppy/registration/RegistrationPasswordOnlyDigitsTest.java)
- [Too short password test](src/test/java/org/example/tests/puppy/registration/RegistrationShortPasswordTest.java)
- [Exceeded characters in username test](src/test/java/org/example/tests/puppy/registration/RegistrationUsernameALotOfCharactersTest.java)
- [Same login and password test](src/test/java/org/example/tests/puppy/registration/RegistrationUsernameAndPasswordSimilarTest.java)
- [Forbidden characters in username test](src/test/java/org/example/tests/puppy/registration/RegistrationUsernameForbiddenCharactersTest.java)
- [Layout registration page test](src/test/java/org/example/tests/puppy/registration/RegistrationLayoutTest.java)
</details>
<details>
<summary>List of Deposit Page tests:</summary>

- [Happy flow deposit transaction test](src/test/java/org/example/tests/puppy/deposit/DepositTransactionHappyFlowTest.java)
- [Empty fields test](src/test/java/org/example/tests/puppy/deposit/DepositTransactionEmptyFieldsTest.java)
- [Balance change test](src/test/java/org/example/tests/puppy/deposit/ChangingAccountBalanceTest.java)
- [Deposit excess test](src/test/java/org/example/tests/puppy/deposit/ExceedingValueDepositAmountTest.java)
- [Letters in the deposit field test](src/test/java/org/example/tests/puppy/deposit/LettersInDepositAmountTest.java)
- [Symbols in the deposit field test](src/test/java/org/example/tests/puppy/deposit/SymbolsInsteadNumbersTest.java)
- [Zero deposit test](src/test/java/org/example/tests/puppy/deposit/ZeroDepositAmountFieldTest.java)
</details>
<details>
<summary>List of Withdraw Page tests:</summary>

- [Happy flow withdraw transaction test](src/test/java/org/example/tests/puppy/withdraw/WithdrawTransactionHappyFlowTest.java)
- [Empty fields test](src/test/java/org/example/tests/puppy/withdraw/WithdrawTransactionEmptyFieldsTest.java)
- [Balance change test](src/test/java/org/example/tests/puppy/withdraw/ChangingAccountBalanceTest.java)
- [Withdraw excess test](src/test/java/org/example/tests/puppy/withdraw/TooMuchAmountTest.java)
- [Letters in the withdrawal field test](src/test/java/org/example/tests/puppy/withdraw/LettersInAmountTest.java)
- [Symbols in the withdrawal field test](src/test/java/org/example/tests/puppy/withdraw/SymbolsInsteadNumbersTest.java)
- [Zero withdraw test](src/test/java/org/example/tests/puppy/withdraw/ZeroWithdrawAmountFieldTest.java)
</details>
<details>
<summary>List of Transfer Page tests:</summary>

- [Happy flow transfer transaction test](src/test/java/org/example/tests/puppy/transfer/NewTransferHappyFlowTest.java)
- [Empty fields test](src/test/java/org/example/tests/puppy/transfer/EmptyFieldsTest.java)
- [Balance change test](src/test/java/org/example/tests/puppy/transfer/ChangingAccountsBalanceTest.java)
- [Transfer excess test](src/test/java/org/example/tests/puppy/transfer/ExceedingTransferAmountTest.java)
- [Symbols in the transfer field test](src/test/java/org/example/tests/puppy/transfer/SymbolsInsteadNumbersTest.java)
- [Zero transfer test](src/test/java/org/example/tests/puppy/transfer/ZeroTransferAmountTest.java)
- [Single account use Test](src/test/java/org/example/tests/puppy/transfer/UsageOnePuppyAccountTest.java)
</details>

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
- IIDDD aka Andrey Merkulov - teacher
- Kordel aka Maksim Gradinar - student
- Manuya aka Anastasia Gradinar - student
- Gelerter aka Nikolay Rosenfeld - student