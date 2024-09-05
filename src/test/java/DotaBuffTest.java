
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.example.DriverHolder.getDriver;

public class DotaBuffTest extends BaseTest {

    private final static boolean IS_GDPR = false;
    public static final String DOTA_BUFF_URL = "https://www.dotabuff.com/";

    @Test
    public void test1() {
        getDriver().get(DOTA_BUFF_URL);
        if (IS_GDPR) {
            dummyWait(1);
            getDriver().findElement(By.xpath("//button[@mode='primary']")).click();
        }
        getDriver().findElement(By.xpath("//input[@id='q'][@tabindex='1']")).sendKeys("Nyx");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//header[@style='position: relative'][contains(text(),'1 Heroes')]")).isDisplayed());
    }
}
