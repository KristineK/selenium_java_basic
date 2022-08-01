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
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
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
        int expected = 5;
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
        int actual = allElementsWithClass.size();
//        driver.findElements(By.className("test")).size();_
        assertEquals(expected, actual);
//         check that value of second button is "This is also a button"
        assertEquals("This is also a button", driver.findElement(By.id("buttonId")).getAttribute("value"));
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        assertTrue("Some custom error", driver.findElement(By.id("buttonId"))
                .getAttribute("value")
                .equalsIgnoreCase("this is Also a Button"));
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"

//        assertEquals("This is a button", driver.findElement(By.id("buttonId"))
//                .getAttribute("value"));  XXX

        String valueOfBtn = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertFalse(valueOfBtn.equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190

//        assertTrue(190, driver.findElement(By.id("buttonId"))
//                .getAttribute("value")); XXX

        List <WebElement> elems = driver.findElements((By.className("test")));
        elems.forEach(webEl -> {
            if(webEl.getText().contains("190")){
                fail();
            }
        });
    }
}
