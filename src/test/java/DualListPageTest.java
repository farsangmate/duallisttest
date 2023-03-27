import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DualListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DualListPageTest {

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
    public void testDualList()
    {
        DualListPage dualListPage = new DualListPage(driver);
        dualListPage.navigate();
        dualListPage.inputMessage("bootstrap");
        dualListPage.clickSelectBtn1();
        dualListPage.clickAddItem();
        Assertions.assertTrue(dualListPage.findRightListItem("bootstrap"));
    }


}
