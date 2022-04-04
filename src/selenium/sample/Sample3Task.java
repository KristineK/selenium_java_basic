package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        // System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        List<WebElement> testElements = driver.findElements(By.className("test"));
        assertEquals(testElements.size(),5);
        WebElement button = driver.findElement(By.id("buttonId"));
        assertEquals(button.getAttribute("value"),"This is also a button");
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String errorText = "Some error text";
        String expectedString = "this is also a button";
        WebElement button = driver.findElement(By.id("buttonId"));
        assertTrue(button.getAttribute("value").equalsIgnoreCase(expectedString) );
        assertTrue(errorText,button.getAttribute("value").equalsIgnoreCase(expectedString) );

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        assertFalse(driver.findElement(By.id("buttonId")).getAttribute("value").equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> testElements = driver.findElements(By.className("test"));
        for(WebElement testElement : testElements){
            if(testElement.getText().contains("190")){
                fail();
            }
        }
    }
}
