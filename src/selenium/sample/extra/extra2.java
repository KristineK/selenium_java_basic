package selenium.sample.extra;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class extra2 {
    WebDriver driver;
    String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    public void pageCheck() throws  Exception {
        driver.get("https://kristinek.github.io/test-sample/examples/st");
//        WebElement h1 = driver.findElement(By.xpath("//h1"));
//        assertEquals("block", h1.getCssValue("display"));
//        assertEquals("rgba(0, 0, 0, 1)", h1.getCssValue("color"));
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Lorem ipsum");
        System.out.println(driver.findElement(By.tagName("h1")).getCssValue("color"));
        System.out.println(driver.findElement(By.tagName("h1")).getCssValue("background-color"));
    }

    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void runningOnFirefox() throws  Exception {
        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();
        pageCheck();
    }

    @Test
    public void  runningOnChrome() throws  Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        pageCheck();
    }

    @Test
    public void  runningOnIE() throws  Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        pageCheck();
    }

    @Test
    public void  runningOnPhantomJS() throws  Exception {
        System.setProperty("phantomjs.binary.path", libWithDriversLocation + "phantomjs.exe");
        driver = new PhantomJSDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        pageCheck();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshot.jpg"));
    }
}
