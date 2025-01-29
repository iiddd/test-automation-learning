package org.example.pages;

import org.example.models.rest.TransferTransaction;
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

public class TransferTransactionListPage extends BasePage{

    private static final By TRANSFER_TRANSACTION_LIST_LOCATOR = By.xpath("//h1[text()='Transfer Transaction List']");
    private static final By TRANSFER_ROW_LOCATOR = By.xpath("//tbody/tr");
    private static final By TRANSACTION_REFERENCE_COLUMN_LOCATOR = By.xpath("./td[position()=1]");
    private static final By TRANSACTION_DATE_COLUMN_LOCATOR = By.xpath("./td[position()=2]");
    private static final By FROM_PUPPY_ACCOUNT_COLUMN_LOCATOR = By.xpath("./td[position()=3]");
    private static final By TO_PUPPY_ACCOUNT_COLUMN_LOCATOR = By.xpath("./td[position()=4]");
    private static final By TRANSFER_AMOUNT_COLUMN_LOCATOR = By.xpath("./td[position()=5]");
    private static final By CURRENCY_COLUMN_LOCATOR = By.xpath("./td[position()=6]");
    private static final String ERROR_TEXT = "Date string does not match any known formats: ";
    private static final String DATE_FORMAT = "MMMM d, uuuu";
    private static final String DATE_FORMAT_DOT = "MMM. d, uuuu";

    public TransferTransactionListPage checkToTransactionListPage() {
        Assertions.assertTrue(getDriver().findElement(TRANSFER_TRANSACTION_LIST_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionListPage checkTransactionListContainsTransaction(String transactionId) {
        Assertions.assertTrue(
                getTransferTransactions().stream().anyMatch(
                        withdrawTransaction -> withdrawTransaction.getTransactionReference().equals(transactionId)
                )
        );
        return this;
    }

    private List<TransferTransaction> getTransferTransactions() {
        return getDriver().findElements(TRANSFER_ROW_LOCATOR).stream()
                .map(row -> mapTransferTransaction(row))
                .collect(Collectors.toList());
    }

    private TransferTransaction mapTransferTransaction(WebElement row) {
        TransferTransaction.TransferTransactionBuilder transferTransaction = TransferTransaction.builder();
        transferTransaction
                .transactionReference(row.findElement(TRANSACTION_REFERENCE_COLUMN_LOCATOR).getText())
                .transactionDate(parseDate(row.findElement(TRANSACTION_DATE_COLUMN_LOCATOR).getText()))
                .fromPuppyAccount(row.findElement(FROM_PUPPY_ACCOUNT_COLUMN_LOCATOR).getText())
                .toPuppyAccount(row.findElement(TO_PUPPY_ACCOUNT_COLUMN_LOCATOR).getText())
                .transferAmount(Float.parseFloat(row.findElement(TRANSFER_AMOUNT_COLUMN_LOCATOR).getText()))
                .currency(row.findElement(CURRENCY_COLUMN_LOCATOR).getText());
        return transferTransaction.build();
    }

    private Date parseDate(String stringDate) {
        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH),
                DateTimeFormatter.ofPattern(DATE_FORMAT_DOT, Locale.ENGLISH)
        );
        LocalDate localDate = parseDate(stringDate, formatters);
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
        throw new IllegalArgumentException( ERROR_TEXT + dateString);
    }
}