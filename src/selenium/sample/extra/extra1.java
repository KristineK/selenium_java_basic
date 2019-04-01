package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class extra1 {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";
    String new_url = "https://kristinek.github.io/site/examples/link1";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    //    1. navigateBack (which will check current url,
    // click on element with css selector “a[title='Link 1']”,
    // check current url, navigate back and check the url again)
    @Test
    public void navigateBack() throws Exception {
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[title='Link 1']")).click();
        assertEquals(new_url, driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals(base_url, driver.getCurrentUrl());
    }

    //2. navigateForward (which will check current url,
    // click on element with css selector “a[title='Link 1']”,
    // check current url, navigate back, check the url,
    // navigate forward and doa final check of url)
    @Test
    public void navigateForward() throws Exception {
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[title='Link 1']")).click();
        assertEquals(new_url, driver.getCurrentUrl());
        driver.navigate().back();
        assertEquals(base_url, driver.getCurrentUrl());
        driver.navigate().forward();
        assertEquals(new_url, driver.getCurrentUrl());
    }

    //3. refresh (which will check the url,
// get value of text box, send some keys to the text box,
// check that the text box value was changed, do a refresh,
// check the url and that the text box is now again with default value)
    @Test
    public void refresh() throws Exception {
        String originalText = "This is a text box";
        WebElement getTextBox = driver.findElement(By.name("vfb-5"));
        assertEquals(base_url, driver.getCurrentUrl());
        assertEquals(getTextBox.getAttribute("value"), originalText);
        getTextBox.sendKeys(" asd");
        assertEquals(getTextBox.getAttribute("value"), originalText + " asd");
        driver.navigate().refresh();
        assertEquals(driver.findElement(By.name("vfb-5")).getAttribute("value"), originalText);
    }
}
