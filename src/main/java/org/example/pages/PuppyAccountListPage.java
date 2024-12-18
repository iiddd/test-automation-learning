package org.example.pages;

import org.example.models.PuppyAccount;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.core.DriverHolder.getDriver;

public class PuppyAccountListPage {
    private static final By ACCOUNT_ROW_LOCATOR = By.xpath("//tbody/tr");
    private static final By FIRST_NAME_COLUMN_LOCATOR = By.xpath("./td[position()=1]");
    private static final By LAST_NAME_COLUMN_LOCATOR = By.xpath("./td[position()=2]");
    private static final By ACCOUNT_NUMBER_COLUMN_LOCATOR = By.xpath("./td[position()=3]");
    private static final By EMAIL_ADDRESS_COLUMN_LOCATOR = By.xpath("./td[position()=4]");
    private static final By BALANCE_COLUMN_LOCATOR = By.xpath("./td[position()=5]");

    public String getAccountBalance(float accountBalance) {
        return getPuppyAccounts().stream().anyMatch(puppyAccount -> puppyAccount.getFirstName().)
    }

    public PuppyAccountListPage compareAccountBalance() {
        Assertions.assertTrue(getPuppyAccounts().);
    }

    private List<PuppyAccount> getPuppyAccounts() {
        return getDriver().findElements(ACCOUNT_ROW_LOCATOR).stream()
                .map(row -> mapPuppyAccount(row))
                .collect(Collectors.toList());
    }

    private PuppyAccount mapPuppyAccount(WebElement row) {
        PuppyAccount.PuppyAccountBuilder puppyAccount = PuppyAccount.builder();
        puppyAccount
                .firstName(row.findElement(FIRST_NAME_COLUMN_LOCATOR).getText())
                .lastName(row.findElement(LAST_NAME_COLUMN_LOCATOR).getText())
                .accountNumber(row.findElement(ACCOUNT_NUMBER_COLUMN_LOCATOR).getText())
                .emailAddress(row.findElement(EMAIL_ADDRESS_COLUMN_LOCATOR).getText())
                .balance(Float.parseFloat(row.findElement(BALANCE_COLUMN_LOCATOR).getText()));
        return puppyAccount.build();
    }
}
