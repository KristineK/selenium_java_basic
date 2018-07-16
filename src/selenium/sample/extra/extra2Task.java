package selenium.sample.extra;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class extra2Task {
    WebDriver driver;
    String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void runningOnFirefox() throws  Exception {
        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();
//        TODO
//        go to page https://kristinek.github.io/test-sample/examples/po
//        check the background color of h1 element
    }

    @Test
    public void  runningOnChrome() throws  Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
//        TODO
//        go to page https://kristinek.github.io/test-sample/examples/po
//        check the background color of h1 element
    }

    @Test
    public void  runningOnIE() throws  Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
//        TODO
//        go to page https://kristinek.github.io/test-sample/examples/po
//        check the background color of h1 element
    }

    @Test
    public void  runningOnPhantomJS() throws  Exception {
        System.setProperty("phantomjs.binary.path", libWithDriversLocation + "phantomjs.exe");
        driver = new PhantomJSDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
//        TODO
//        go to page https://kristinek.github.io/test-sample/examples/po
//        check the background color of h1 element
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshot.jpg"));
    }
}
