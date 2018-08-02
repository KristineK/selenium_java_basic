package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://kristinek.github.io/test-sample/index2.html");
        System.out.println(chromeDriver.getTitle());
        chromeDriver.get("https://google.com");
        System.out.println(chromeDriver.getCurrentUrl());
        chromeDriver.close();
//         TODO:
//         define driver
//         go to https://kristinek.github.io/test-sample/index2.html
//         get title of page
//         get URL of current page
//         close browser
    }
}
