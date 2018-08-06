package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Sample9Task {
    WebDriver driver;

    @Before
    public void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task2");
    }

    @After
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("loading_green")).getText(), "Loading green...");
        Thread.sleep(5000);
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
        assertEquals(driver.findElement(By.id("finish_green")).getText(), "Green Loaded");

        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenImplicit() throws Exception {
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
        /* TODO:
         * 1) click on start loading green button
         * 2) check that button does not appear,
         * but loading text is seen instead
         * 3) check that both button
         * and loading text is not seen,
         * success is seen instead
         */
    }

    @Test
    public void loadGreenAndBlueBonus(){
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