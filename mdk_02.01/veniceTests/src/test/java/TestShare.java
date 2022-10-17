import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestShare {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///home/vladt/WebstormProjects/pract_web/individual_site/share.html");
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
    public void form() {
        WebElement inputName = driver.findElement(By.id("inputName"));
        inputName.sendKeys("Владислав");

        WebElement historyTextArea = driver.findElement(By.id("historyTextArea"));
        historyTextArea.sendKeys("Венеция - самое прекрасное, что я видел в своей жизни");

        WebElement formButton  = driver.findElement(By.xpath("//*/form/button"));
        formButton.click();
    }

    @Test
    public void footerWiki() {
        WebElement link = driver.findElement(By.xpath("//*/footer/section/div/div/div[2]/ul/li[1]/a"));
        link.click();

        var expectedResult = "https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BD%D0%B5%D1%86%D0%B8%D1%8F";
        var curUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, curUrl);
    }


}