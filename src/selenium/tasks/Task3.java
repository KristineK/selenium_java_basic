package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
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
    public void loadGreen(){
		/* TODO:
		 * 1) click on start loading green button
		 * 2) check that button does not appear, but loading text is seen instead
		 * 3) check that both button and loading text is not seen, success is seen instead
		 */
    }

    @Test
    public void loadGreenAndBlue(){
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