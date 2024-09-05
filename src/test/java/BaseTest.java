import org.example.DriverHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setup() {
        DriverHolder.initDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverHolder.killDriver();
    }

    public void dummyWait(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
