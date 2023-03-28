import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TablePageTest {

    WebDriver driver;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
    }

    @Test
    public void tablePageTest() throws InterruptedException {

        String word = "in progress";

        TablePage tablePage = new TablePage(driver);
        tablePage.navigate();
        tablePage.giveInput(word);
        String[] actualResult = tablePage.getTasks();
        String[] expectedResult = {"Wireframes", "Bootstrap 3", "Big fixing"};

        Assertions.assertArrayEquals(expectedResult, actualResult);

    }
}
