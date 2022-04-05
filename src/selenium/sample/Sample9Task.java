package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        //System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement startGreen = driver.findElement(By.id("start_green"));
//         * 1) click on start loading green button
        startGreen.click();
//         * 2) check that button does not appear,
        assertFalse(startGreen.isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        assertTrue(loadingGreen.isDisplayed());
        assertEquals("Loading green...",loadingGreen.getText());

//         * 3) check that both button
        Thread.sleep(5000);
        WebElement finishGreen = driver.findElement(By.id("finish_green"));
        assertFalse(startGreen.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());

        assertTrue(finishGreen.isDisplayed());
        assertEquals("Green Loaded",finishGreen.getText());

//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement startGreen = driver.findElement(By.id("start_green"));
        //WebElement finishGreen = driver.findElement(By.id("finish_green"));
//         * 1) click on start loading green button
        startGreen.click();
//         * 2) check that button does not appear,
        assertFalse(startGreen.isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
        assertTrue(loadingGreen.isDisplayed());
        assertEquals("Loading green...",loadingGreen.getText());
        WebElement finishGreen = driver.findElement(By.id("finish_green"));

//         * 3) check that both button
        assertTrue(finishGreen.isDisplayed());
        assertEquals("Green Loaded",finishGreen.getText());
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//         * and loading text is not seen,
        assertFalse(loadingGreen.isDisplayed());
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
       // WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,5 ).ignoring(StaleElementReferenceException);
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
    }

}