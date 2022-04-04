package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class extra1Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/act";
    String new_url = "https://kristinek.github.io/site/examples/link1";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
      //  System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void navigateBack() throws Exception {

                  String currentURL = null;
//        TODO

//        open page with url "https://kristinek.github.io/site/examples/po"
        driver.get("https://kristinek.github.io/site/examples/po");
//        click "More > " for the top left element
        String previousURL = driver.getCurrentUrl();
     if(  driver.findElement(By.cssSelector("a[href$='po1']")).isDisplayed()){
         driver.findElement(By.cssSelector("a[href$='po1']")).click();

            currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
        }
//        check that the url now "https://kristinek.github.io/site/examples/po1"
//        using driver navigation go back to "https://kristinek.github.io/site/examples/po"
        assertEquals("https://kristinek.github.io/site/examples/po1",currentURL);
        driver.navigate().back();
        System.out.println(previousURL + " "+driver.getCurrentUrl());
        currentURL = driver.getCurrentUrl();
        assertEquals("https://kristinek.github.io/site/examples/po",currentURL);
//        check that the page now is "https://kristinek.github.io/site/examples/po"


    }

    @Test
    public void navigateForward() throws Exception {
//        TODO
//        open page with url "https://kristinek.github.io/site/examples/po"
//        click "More > " for the top left element
//        using driver navigation go back to "https://kristinek.github.io/site/examples/po"
//        using driver navigation go forward to "https://kristinek.github.io/site/examples/po1"
//        check that the page now is "https://kristinek.github.io/site/examples/po1"

        String currentURL = null;

        driver.get("https://kristinek.github.io/site/examples/po");

        String previousURL = driver.getCurrentUrl();
        if(  driver.findElement(By.cssSelector("a[href$='po1']")).isDisplayed()){
            driver.findElement(By.cssSelector("a[href$='po1']")).click();

            currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
        }


        assertEquals("https://kristinek.github.io/site/examples/po1",currentURL);
        driver.navigate().back();
        System.out.println(previousURL + " "+driver.getCurrentUrl());
        currentURL = driver.getCurrentUrl();
        assertEquals("https://kristinek.github.io/site/examples/po",currentURL);
        driver.navigate().forward();
        currentURL = driver.getCurrentUrl();
        assertEquals("https://kristinek.github.io/site/examples/po1",currentURL);



    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://kristinek.github.io/site/examples/act"
        driver.get("https://kristinek.github.io/site/examples/act");
//        click on "Show" button in 'Button' section
        WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show_text")));
        if(  driver.findElement(By.id("show_text")).isEnabled()) {
            driver.findElement(By.id("show_text")).click();
        }

//        check that text "I am here!" is seen
        assertEquals("I am here!",driver.findElement(By.id("show_me")).getText());
//        refresh page
        driver.navigate().refresh();
//        check that text "I am here!" is not seen
        assertFalse(driver.findElement(By.id("show_me")).isDisplayed());


    }
}
