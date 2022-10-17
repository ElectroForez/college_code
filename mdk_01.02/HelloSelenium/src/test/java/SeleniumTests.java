import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;


public class SeleniumTests {

    @Test
    public void testHelloVasya() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        BasicConfigurator.configure();
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}

