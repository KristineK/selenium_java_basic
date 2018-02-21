package selenium.sample;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Sample9 {

    WebDriver driver;
    private static WebDriverWait wait;
    static long startTime;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 3).ignoring(StaleElementReferenceException.class);
        driver.get("https://kristinek.github.io/test-sample/examples/sync");
        System.out.println(driver.findElement(By.id("magic_text")).getText());
        assertEquals("This text magicly changes color", driver.findElement(By.id("magic_text")).getText());
        startTime = System.currentTimeMillis();
    }

    @After
    public void closeBrowser() {
        System.out.println(driver.findElement(By.id("magic_text")).getText());
        assertEquals("What is this magic? It's dev magic~", driver.findElement(By.id("magic_text")).getText());
        long endTime = System.currentTimeMillis();
        System.out.println("Total time was: " + (endTime - startTime));
        driver.quit();
    }

    @Test
    public void sleepExample() throws Exception {
        Thread.sleep(10000);
    }

    @Test
    public void implicitWaitExample() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='magic_text']/*[text()=\"What is this magic? It's dev magic~\"]"));
    }

    @Test
    public void explicitWaitExample() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='magic_text1']/*[text()=\"What is this magic? It's dev magic~\"]")));
    }
}


