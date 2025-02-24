package org.example.pages;

import org.example.models.DepositTransaction;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.example.core.DriverHolder.getDriver;

public class DepositTransactionListPage {

    private static final By DEPOSIT_TRANSACTION_LIST_HEADER_LOCATOR = By.xpath("//h1[text()='Deposit Transaction List']");
    private static final By DEPOSIT_ROW_LOCATOR = By.xpath("//tbody/tr");
    private static final By TRANSACTION_REFERENCE_COLUMN_LOCATOR = By.xpath("./td[position()=1]");
    private static final By TRANSACTION_DATE_COLUMN_LOCATOR = By.xpath("./td[position()=2]");
    private static final By PUPPY_NAME_COLUMN_LOCATOR = By.xpath("./td[position()=3]");
    private static final By DEPOSITE_AMOUNT_COLUMN_LOCATOR = By.xpath("./td[position()=4]");
    private static final By START_BALANCE_COLUMN_LOCATOR = By.xpath("./td[position()=5]");
    private static final By NEW_BALANCE_COLUMN_LOCATOR = By.xpath("./td[position()=6]");
    private static final By CURRENCY_COLUMN_LOCATOR = By.xpath("./td[position()=7]");
    private static final String ERROR_TEXT = "Date string does not match any known formats: ";
    private static final String DATE_FORMAT = "MMMM d, uuuu";
    private static final String DATE_FORMAT_DOT = "MMM. d, uuuu";

    public DepositTransactionListPage checkDepositTransactionListIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(DEPOSIT_TRANSACTION_LIST_HEADER_LOCATOR).isDisplayed());
        return this;
    }

    public DepositTransactionListPage checkTransactionListContainsTransaction(String transactionId) {
        Assertions.assertTrue(
                getDepositTransactions().stream().anyMatch(
                        withdrawTransaction -> withdrawTransaction.getTransactionReference().equals(transactionId)
                )
        );
        return this;
    }

    private List<DepositTransaction> getDepositTransactions() {
        return getDriver().findElements(DEPOSIT_ROW_LOCATOR).stream()
                .map(row -> mapDepositTransaction(row))
                .collect(Collectors.toList());
    }

    private DepositTransaction mapDepositTransaction(WebElement row) {
        DepositTransaction.DepositTransactionBuilder depositTransaction = DepositTransaction.builder();
        depositTransaction
                .transactionReference(row.findElement(TRANSACTION_REFERENCE_COLUMN_LOCATOR).getText())
                .transactionDate(parseDate(row.findElement(TRANSACTION_DATE_COLUMN_LOCATOR).getText()))
                .puppyName(row.findElement(PUPPY_NAME_COLUMN_LOCATOR).getText())
                .depositAmount(Float.parseFloat(row.findElement(DEPOSITE_AMOUNT_COLUMN_LOCATOR).getText()))
                .startBalance(Float.parseFloat(row.findElement(START_BALANCE_COLUMN_LOCATOR).getText()))
                .newBalance(Float.parseFloat(row.findElement(NEW_BALANCE_COLUMN_LOCATOR).getText()))
                .currency(row.findElement(CURRENCY_COLUMN_LOCATOR).getText());
        return depositTransaction.build();
    }

    private Date parseDate(String stringDage) {
        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH),
                DateTimeFormatter.ofPattern(DATE_FORMAT_DOT, Locale.ENGLISH)
        );
        LocalDate localDate = parseDate(stringDage, formatters);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(defaultZoneId).toInstant();
        return Date.from(instant);
    }

    private static LocalDate parseDate(String dateString, List<DateTimeFormatter> formatters) {
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
            }
        }
        throw new IllegalArgumentException(ERROR_TEXT + dateString);
    }
}
