package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample5Task {
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
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
        Thread.sleep(10000);

//        switch to alert
        Alert alert = driver.switchTo().alert();


//        click ok
        alert.accept();
        Thread.sleep(4000);

//        switch to second alert
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(4000);

//        verify alert text
        assertEquals("Booooooooo!", alert2.getText());
        Thread.sleep(4000);

//        click ok on second alert
        alert2.accept();

//        verify that the correct page is opened
        assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
        Thread.sleep(4000);
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
        Thread.sleep(4000);

//        switch to alert
        Alert alert = driver.switchTo().alert();

//        click cancel
        alert.dismiss();

//        verify the text on page
        assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());
        Thread.sleep(4000);
    }
}
