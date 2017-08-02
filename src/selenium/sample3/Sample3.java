package selenium.sample3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample3 {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void assertEqualsExampleString() throws Exception {
        String expected = "Base page";
        String actual = driver.findElement(By.id("heading")).getText();
        assertEquals(expected, actual);

        // fails:
//        org.junit.ComparisonFailure:
//        Expected :Not base page
//        Actual   :Base page
        expected = "Not base page";
        assertEquals(expected, actual);
    }

    @Test
    public void assertEqualsExampleInt() throws Exception {
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("text")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);
    }

    

//            assertTrueExample (assertTrue with “String.equals()”, “String.contains()”, “String. equalsIgnoreCase()”)
//    assertFalseExample (assertFalse with “!String.equals()”, “String.equals(“not”)”, “String. contains(“not”)”)
//    failExampleWithDefaultError (see how fail() works)
//    failExampleWithCustomError (see how fail(“w/m”) works)
//    assertEqualsExampleWithDefaultError (try { assertEquals(exp, act) } catch (ComparisonFailure e) { System.err.println(); e.printStackTrace(); } )
//    assertEqualsExampleWithCustomError (try { assertEquals(“custom message”, ext, act) } catch (ComparisonFailure e) { System.err.println(); e.printStackTrace(); }) Push all your changes to git
}
