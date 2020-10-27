package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
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
        int actual = driver.findElements(By.className("test")).size();
        assertEquals(expected, actual);

//         check that value of second button is "This is also a button"
        String expected2 = "This is also a button";
        String actual2 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected2, actual2);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertTrue(elementTextOnPage.equals("this is also a button"));
        assertTrue(elementTextOnPage.equalsIgnoreCase("tHIS IS ALSO A BUTTON"));
        assertTrue("Expecting the element with name 'randomButton2' to have text of value 'this is also a button'", elementTextOnPage.contains("this is also a button"));




    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String elementTextOnPage = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(elementTextOnPage.equals("This is a button"));


    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190

        List <WebElement> allElements = driver.findElements(By.className("test"));
        for (WebElement a : allElements){
            assertFalse(a.getText().contains("190"));
        }
    }
}
