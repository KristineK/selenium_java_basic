package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sample5 {
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
    public void alertOnOpeningPage() throws Exception {
        driver.get("https://kristinek.github.io/site/examples/al_p");
//        org.openqa.selenium.UnhandledAlertException: unexpected alert open:
//        driver.findElement(By.id("heading")).getText();
        Alert alert = driver.switchTo().alert();
        assertEquals("Booooooooo!", alert.getText());

        alert.accept();
        assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
    }

    @Test
    public void alertOnclickingButton() throws Exception {
        driver.findElement(By.className("w3-red")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("I am an alert box!", alert.getText());

        alert.accept();
        assertEquals("", driver.findElement(By.id("textForAlerts")).getText());
    }


    @Test
    public void popUpConform() throws Exception {
        driver.findElement(By.className("w3-teal")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Press a button!", alert.getText());

        alert.accept();
        assertEquals("Why on earth have you agreed to it?!", driver.findElement(By.id("textForAlerts")).getText());
    }

    @Test
    public void popUpDeny() throws Exception {
        driver.findElement(By.className("w3-teal")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Press a button!", alert.getText());

        alert.dismiss();
        assertEquals("You have dared to deny me!!!", driver.findElement(By.id("textForAlerts")).getText());
    }


    @Test
    public void popUpEnterNumber() throws Exception {
        String enterKeys = "5";
        driver.findElement(By.className("w3-khaki")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Please enter a number", alert.getText());

        alert.sendKeys(enterKeys);
        alert.accept();
        assertTrue(driver.findElement(By.id("textForAlerts")).getText().contains("instead of " + enterKeys));
    }
}
