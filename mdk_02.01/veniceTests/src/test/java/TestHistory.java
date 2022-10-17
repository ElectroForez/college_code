import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestHistory {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///home/vladt/WebstormProjects/pract_web/individual_site/history.html");
    }

    @After
    public void close(){
        driver.quit();
    }

    @Test
    public void navbarBrandName() {
        WebElement element = driver.findElement(By.className("navbar-brand"));
        var actualResult = element.getText();
        var expectedResult = "Венеция";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void navbarItemMain() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[1]/a"));
        var actualResult = element.getText();
        var expectedResult = "Главная";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void navbarItemHistory() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[2]/a"));
        var actualResult = element.getText();
        var expectedResult = "О городе";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shareLink() {
        WebElement link = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a"));
        link.click();
        WebElement shareContent = driver.findElement(By.xpath("//*[contains(@class, \"share\")]"));
        Assert.assertNotEquals(null, shareContent);
    }


    @Test
    public void mainLink() {
        WebElement link = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[1]/a"));
        link.click();
        WebElement mainContent = driver.findElement(By.xpath("//*[contains(@class, \"main\")]"));
        Assert.assertNotEquals(null, mainContent);
    }

    @Test
    public void contentHeader() {
        WebElement element = driver.findElement(By.cssSelector("body > section > div > div:nth-child(1) > h1"));
        var actualResult = element.getText();
        var expectedResult = "Город Венеция (Италия)";
        Assert.assertEquals(expectedResult, actualResult);
    }

}