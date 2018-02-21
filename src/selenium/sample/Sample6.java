package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample6 {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
        System.out.println(
                driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class, 'amazing')]")).getText());
        // amazing sample text

        System.out.println(
                driver.findElement(By.xpath("//p[@class='text' and @id='dummy']")).getText());
        // dummy text
    }

    @Test
    public void findElementByCssName() throws Exception {
        System.out.println(
                driver.findElement(By.cssSelector("div#nonStandartText > .amazing")).getText());
        System.out.println(
                driver.findElement(By.cssSelector(".text#dummy")).getText());
    }
}
