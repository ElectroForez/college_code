import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestIndex {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///home/vladt/WebstormProjects/pract_web/individual_site/index.html");
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
    public void navbarItemShare() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a"));
        var actualResult = element.getText();
        var expectedResult = "Поделиться историей";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void historyLink() {
        WebElement link = driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[2]/a"));
        link.click();
        WebElement historyContent = driver.findElement(By.xpath("//*[contains(@class, \"history\")]"));
        Assert.assertNotEquals(null, historyContent);
    }

    @Test
    public void cardName() {
        WebElement element = driver.findElement(By.xpath("/html/body/section/div[3]/div/div[2]/div/div[2]/h4/a"));
        var actualResult = element.getText();
        var expectedResult = "Площадь Святого Марка";
        Assert.assertEquals(expectedResult, actualResult);
    }


}