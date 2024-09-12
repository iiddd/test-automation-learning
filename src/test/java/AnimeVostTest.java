import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.DriverHolder.getDriver;

public class AnimeVostTest extends BaseTest {
    @Test
    public void Test2()

    {
        getDriver().get("https://animevostorg.ru/");
        getDriver().findElement(By.xpath("//input[@id='story']")).sendKeys("Bleach");
        getDriver().findElement(By.xpath("//button[@class='search-btn']")).click();
        getDriver().findElement(By.xpath("//a[@href='https://animevostorg.ru/7235-blich-tysjacheletnjaja-krovavaja-vojna-proschanie.html']")).click();
        getDriver().findElement(By.xpath("//div[@class='y809545c6']")).click();
        getDriver().findElement(By.xpath("//div[@class='slideviri d-flex img-fit-cover']/div[@class='slideviri__desc flex-grow-1 d-flex fd-column']/div[@class='slideviri__btns flex-grow-1 d-flex ai-flex-end jc-space-between']/div[@class='slideviri__btn btn js-scroll-to']")).click();
        // Нужно нажать на кнопку запуска видео, но пока не получилось.
        // Код попытка ниже
        // getDriver().findElement(By.xpath("//a[@class='play_button']")).click();

    }
}

