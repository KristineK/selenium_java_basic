package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @Test
    public void goToHomepage() throws Exception {
//        TODO:
//         define driver
        //recommended                                                                           ON LINUX WE NOT USED TO WRITE THIS THING
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        WebDriver driver = new ChromeDriver();
//         go to https://kristinek.github.io/site/index2.html
        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/index2.html");
        driver.get("https://sergei-rogozinnikov.web.app/index.html");
//         get title of page
        System.out.println(driver.getTitle());
//         get URL of current page
        System.out.println(driver.getCurrentUrl());
//         close browser
        Thread.sleep(5000);
        driver.quit();
    }
}
