package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample3 {
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
        driver.close();
    }

    @Test
    public void assertEqualsExampleString() throws Exception {
        String expected = "Heading 1";
        String actual = driver.findElement(By.id("heading_1")).getText();
        assertEquals(expected, actual);
    }

    @Test
    public void assertEqualsFailingExampleString() throws Exception {
        String expected = "Not base page";
        String actual = driver.findElement(By.id("heading_1")).getText();

        // fails:
//        org.junit.ComparisonFailure:
//        Expected :Not base page
//        Actual   :Base page
        assertEquals(expected, actual);
    }

    @Test
    public void assertEqualsExampleInt() throws Exception {
        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("text")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);
    }

    @Test
    public void assertTrueExamples() throws Exception {
        String elementTextOnPage = driver.findElement(By.cssSelector(".unbelievable")).getText();
        assertTrue(elementTextOnPage.equals("unbelievable sample text"));
        assertTrue("Expecting the element with class 'unbelievable' to have text 'ajshdka'", elementTextOnPage.contains("ajshdka"));
        assertTrue(elementTextOnPage.equalsIgnoreCase("unBELIEVable sAMPle Text"));
        // pass:
        assertTrue(true);
        // fail:
//        assertTrue(false);
    }

    @Test
    public void assertFalseExample() throws Exception {
        String elementTextOnPage = driver.findElement(By.cssSelector(".unbelievable")).getText();
        assertFalse(!elementTextOnPage.equals("unbelievable sample text"));
        assertFalse(elementTextOnPage.equals("wrong text"));
        assertFalse(elementTextOnPage.contains("wrong text"));
        // fail:
//        assertFalse(true);
        // pass:
        assertFalse(false);
    }

    @Test
    public void failExampleWithDefaultError() throws Exception {
        fail();
        // will throw an java.lang.AssertionError
    }

    @Test
    public void failExampleWithCustomError() throws Exception {
        fail("I want this test to fail, so will!");
        // will throw an java.lang.AssertionError: I want this test to fail, so will!
    }

    @Test
    public void assertEqualsExampleWithDefaultError() throws Exception {
        try {
            assertEquals(3, 4);
        } catch (AssertionError e) {
            System.err.println("We failed ");
            e.printStackTrace();
//            We failed
//            java.lang.AssertionError: expected:<3> but was:<4>
        }
    }

    @Test
    public void assertEqualsExampleWithCustomError() throws Exception {
        try {
            assertEquals("custom message", 3, 4);
        } catch (AssertionError e) {
            System.err.println("We failed with custom message”");
            e.printStackTrace();
        }
//        We failed with custom message”
//        java.lang.AssertionError: custom message expected:<3> but was:<4>
    }
}
