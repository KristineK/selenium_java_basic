package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4 {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

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

    @Test
    public void clickLink() throws Exception {
        assertEquals(base_url, driver.getCurrentUrl());
        driver.findElement(By.id("link1")).click();
        assertEquals("Link Page 1", driver.findElement(By.id("h1")).getText());
        assertFalse(driver.getCurrentUrl().equals(base_url));
        assertEquals("https://kristinek.github.io/site/examples/link1", driver.getCurrentUrl());
    }

    @Test
    public void clickButtonAndSeeOrHideText() throws Exception {
        WebElement text = driver.findElement(By.id("show_me"));
        WebElement showButton = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.name("hide_text"));

        assertFalse(text.isDisplayed()); // "I am here!" is NOT seen
        assertTrue(showButton.isEnabled()); // "Show" button is enabled (clickable)
        assertFalse(hideButton.isEnabled()); // "Hide" button is NOT enabled (clickable)

        showButton.click(); // clicking on "Show" button

        assertTrue(text.isDisplayed()); // "I am here!" is seen
        assertFalse(showButton.isEnabled()); // "Show" button is NOT enabled (clickable)
        assertTrue(hideButton.isEnabled()); // "Hide" button is enabled (clickable)

        hideButton.click(); // clicking on "Hide" button

        assertFalse(text.isDisplayed()); // "I am here!" is NOT seen
        assertTrue(showButton.isEnabled()); // "Show" button is enabled (clickable)
        assertFalse(hideButton.isEnabled()); // "Hide" button is NOT enabled (clickable)
    }

    @Test
    public void enterTextInTextArea() throws Exception {
        WebElement textArea = driver.findElement(By.id("text_area"));
        String originalTextInTextArea = "This is a text area";
        String newTextOne = " sending some keys";
        String newTextTwo = "New text in text area\nOn two lines";

        assertEquals(textArea.getText(), originalTextInTextArea); // checking that getText is "This is a text area"
        assertEquals(textArea.getAttribute("value"), originalTextInTextArea); // checking that value is "This is a text area"

        textArea.sendKeys(newTextOne); // sending keys " sending some keys"

        assertEquals(textArea.getText(), originalTextInTextArea); // checking that getText is "This is a text area"
        assertEquals(textArea.getAttribute("value"), originalTextInTextArea + newTextOne);
        // checking that value is "This is a text area" + " sending some keys"

        textArea.clear();

        assertEquals(textArea.getText(), originalTextInTextArea); // checking that getText is "This is a text area"
        assertEquals(textArea.getAttribute("value"), ""); // checking that value is empty or ""

        textArea.sendKeys(newTextTwo);

        assertEquals(textArea.getText(), originalTextInTextArea); // checking that getText is "This is a text area"
        assertEquals(textArea.getAttribute("value"), newTextTwo); // checking that value is "New text in text area"
        assertFalse(textArea.getAttribute("value").contains(originalTextInTextArea));
        // checking that value is NOT "This is a text area"
    }

    @Test
    public void enterTextInTextBox() throws Exception {
        WebElement textInput = driver.findElement(By.id("text"));
        String originalText = "This is a text box";
        String sendKeyOne = " bla-bla";

        assertEquals(textInput.getText(), ""); // checking that getText is empty
        assertEquals(textInput.getAttribute("value"), originalText); // checking that value is "This is a text box"

        textInput.sendKeys(sendKeyOne);

        assertEquals(textInput.getText(), ""); // checking that getText is empty
        assertEquals(textInput.getAttribute("value"), originalText + sendKeyOne);
        // checking that value is "This is a text box" + " bla-bla"

        textInput.clear();
        assertEquals(textInput.getText(), ""); // checking that getText is empty
        assertEquals(textInput.getAttribute("value"), ""); // checking that value is also empty

        textInput.sendKeys(sendKeyOne);

        assertEquals(textInput.getText(), ""); // checking that getText is empty
        assertEquals(textInput.getAttribute("value"), sendKeyOne);
        // checking that value is "This is a text box" + " bla-bla"
        assertFalse(textInput.getAttribute("value").contains(originalText));
    }
}
