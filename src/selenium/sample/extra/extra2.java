package selenium.sample.extra;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;

import static org.junit.Assert.assertEquals;


public class extra2 {
    WebDriver driver;
    String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    public void pageCheck() throws Exception {
        driver.get("https://kristinek.github.io/site/examples/styles");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        assertEquals("block", h1.getCssValue("display"));
        assertEquals(Color.fromString("rgba(0, 0, 0, 1)"), Color.fromString(h1.getCssValue("color")));
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Lorem ipsum");
        System.out.println(driver.findElement(By.tagName("h1")).getCssValue("color"));
        System.out.println(driver.findElement(By.tagName("h1")).getCssValue("background-color"));
    }

    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void runningOnFirefox() throws Exception {
        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();
        pageCheck();
    }

    @Test
    public void runningOnChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        pageCheck();
    }

    @Test
    public void runningOnIE() throws Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        pageCheck();
    }
}
