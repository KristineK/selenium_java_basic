package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

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
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed
        String numberToEnter = "9";
        driver.findElement(By.name("vfb-9")).clear();
        driver.findElement(By.name("vfb-9")).sendKeys(numberToEnter);
        assertFalse(driver.findElement(By.id("clear_result_button_number")).isEnabled());
        assertFalse(driver.findElement(By.id("result_number")).isDisplayed());
        driver.findElement(By.id("result_button_number")).click();
        assertTrue(driver.findElement(By.id("result_number")).isDisplayed());
        assertEquals("You entered number: \"" + numberToEnter +"\"",driver.findElement(By.id("result_number")).getText());
        assertTrue(driver.findElement(By.id("clear_result_button_number")).isEnabled());
        driver.findElement(By.id("clear_result_button_number")).click();
        assertEquals("",driver.findElement(By.id("result_number")).getText());
        assertFalse(driver.findElement(By.id("result_number")).isDisplayed());

    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage
        String homepage = "https://kristinek.github.io/site/";
        assertEquals(base_url,driver.getCurrentUrl());
        driver.findElement(By.id("homepage_link")).click();
        assertNotEquals(base_url,driver.getCurrentUrl());
        assertEquals(homepage,driver.getCurrentUrl());
    }
}
