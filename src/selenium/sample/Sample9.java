package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Sample9 {

    WebDriver driver;
    private static WebDriverWait wait;
    static long startTime;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();

        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

        driver.get("https://kristinek.github.io/site/examples/sync");

        System.out.println(driver.findElement(By.id("magic_text")).getText());
        assertEquals("This text magicly changes color", driver.findElement(By.id("magic_text")).getText());

        startTime = System.currentTimeMillis();
    }

    public void magicTextCheck() {
        System.out.println(driver.findElement(By.id("magic_text")).getText());
        assertEquals("What is this magic? It's dev magic~", driver.findElement(By.id("magic_text")).getText());
    }

    @After
    public void closeBrowser() {
        long endTime = System.currentTimeMillis();
        System.out.println("Total time was: " + (endTime - startTime));
        driver.quit();
    }

    @Test
    public void sleepExample() throws Exception {
        Thread.sleep(10000);
        magicTextCheck();
    }

    @Test
    public void implicitWaitExample() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]"));
//        driver.findElement(By.id("asd"));
        magicTextCheck();
    }

    @Test
    public void explicitWaitExample1() throws Exception {
//        check that the element is present on page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]")));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("asd")));
//        driver.findElement(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]"));
        magicTextCheck();
    }

    @Test
    public void explicitWaitExample2() throws Exception {
//        check that the element is not visible on page
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]")));
        magicTextCheck();
    }

    @Test
    public void explicitWaitExample3() throws Exception {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Test
    public void explicitWaitExample4() throws Exception {
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119);"));
        magicTextCheck();
    }

    @Test
    public void explicitWaitExample5() throws Exception {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p"), "dev"));
        magicTextCheck();
    }
}


