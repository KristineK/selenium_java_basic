package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2 {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void findElementByID() throws Exception {
        // works:
        System.out.println(driver.findElement(By.id("heading_1")).getText());
        // will fail with error NoSuchElementException
        // no such element:
        // Unable to locate element: {"method":"id","selector":"headingasdga"}
//        System.out.println(driver.findElement(By.id("headingasdga")).getText());
    }

    @Test
    public void findElementByName() throws Exception {
        // From page:
        // <input type="button" value="This is a button" name="randomButton" />
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value")); // "This is a button"
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("type")); // "button"
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("name")); // "randomButton"
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("id")); // empty
        // Unable to locate element: {"method":"name","selector":"randomButton123"}:
//        System.out.println(driver.findElement(By.name("randomButton123")).getAttribute("value"));
    }

    @Test
    public void findElementByClassFirst() throws Exception {
        System.out.println(driver.findElement(By.className("text")).getText()); // "sample text 1"
    }

    @Test
    public void findElementByClassAll() throws Exception {
        System.out.println(driver.findElements(By.id("headingasdga")).size()); // 0
        System.out.println(driver.findElements(By.className("text")).size()); // 5
        List<WebElement> allElementsWithClass = driver.findElements(By.className("text"));
//
        for (WebElement elementWithClass : allElementsWithClass) {
            System.out.println(elementWithClass.getText());
            //            sample text 1
            //            sample text 2
            //            unbelievable sample text
            //            amazing sample text
            //            dummy text
        }
        System.out.println("-----------------------");
        System.out.println(driver.findElements(By.className("text")).get(0).getText());
        System.out.println(driver.findElements(By.className("text")).get(2).getText()); // "unbelievable sample text"
    }
}
