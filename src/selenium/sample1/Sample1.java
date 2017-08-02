package selenium.sample1;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1 {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open google homepage
        driver.get("https://google.com/");

        //get title of page
        System.out.println(driver.getTitle());

        //get UR of current page
        System.out.println(driver.getCurrentUrl());

        //Sleep for 10 seconds
        Thread.sleep(10000);

        //Close browser
        driver.close();
    }
}
