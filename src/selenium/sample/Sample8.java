package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample8 {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/styles");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void styleChecks() throws Exception {
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        assertEquals("block", h1.getCssValue("display"));
        assertEquals("rgba(0, 0, 0, 1)", h1.getCssValue("color"));
        assertEquals("64px", h1.getCssValue("font-size"));
        assertEquals("rgba(0, 0, 0, 0)", h1.getCssValue("background-color"));

        WebElement div_h1 = driver.findElement(By.xpath("//div[h1]"));
        assertEquals("rgba(241, 241, 241, 1)", div_h1.getCssValue("background-color"));
    }
}
