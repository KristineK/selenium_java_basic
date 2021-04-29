package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        WebDriver driver = new ChromeDriver();

        //open test homepage
        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/");
        System.out.println(driver.findElement(By.id("h1")).getText());
        //get title of page
        System.out.println(driver.getTitle());
        //get URL of current page
        System.out.println(driver.getCurrentUrl());
        //Sleep for 10 seconds
        Thread.sleep(10000);

        //Close browser
        driver.quit();
    }
}
