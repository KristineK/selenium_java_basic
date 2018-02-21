package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // TODO
        // go to https://kristinek.github.io/test-sample/index2.html
        driver.get("https://kristinek.github.io/test-sample/index2.html");
        // get title of page
        System.out.println(driver.getTitle());
        // get URL of current page
        System.out.println(driver.getCurrentUrl());

        //Close browser
        driver.close();
    }
}
