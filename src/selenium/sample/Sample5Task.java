package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        //  System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
//        switch to alert
//        click ok
        driver.switchTo().alert().accept();
//        switch to second alert
//        verify alert text
        Alert newAlert = driver.switchTo().alert();
        assertEquals("Booooooooo!", newAlert.getText());
//        click ok on second alert
        newAlert.accept();
//        verify that the correct page is opened
        assertEquals("https://kristinek.github.io/site/examples/alerted_page",driver.getCurrentUrl());
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
//        switch to alert
//        click cancel
        driver.switchTo().alert().dismiss();
//        verify the text on page
        assertEquals("So you desided to say? Good!",driver.findElement(By.id("textForAlerts")).getText());
    }
}
