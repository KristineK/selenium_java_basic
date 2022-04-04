package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        //System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        String heading2 = "Heading 2 text";
        assertEquals(heading2,driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        assertEquals(heading2,driver.findElement(By.xpath("//h2[contains(text(),'"+ heading2 +"')]")).getText());
//        1-2 ways to find text: "Test Text 1"
        String testText1 = "Test Text 1";
        assertEquals(testText1,driver.findElement(By.xpath("//div[@id='test1']/p[@class='test']")).getText());
//        1-2 ways to find text: "Test Text 2"
        String testText2 = "Test Text 2";
        assertEquals(testText2,driver.findElement(By.xpath("//*[@id='test1']/p[2]")).getText());
        assertEquals(testText2,driver.findElement(By.xpath("//*[@class=\"twoTest\"]")).getText());
//        1-2 ways to find text: "Test Text 3"
        String testText3 = "Test Text 3";
        assertEquals(testText3,driver.findElement(By.xpath("//*[@id='test3']/p[1]")).getText());
//        1-2 ways to find text: "Test Text 4"
        String testText4 = "Test Text 4";
        assertEquals(testText4,driver.findElement(By.xpath("//p[@class='test' and contains(text(),'4')]")).getText());
        /* 1-2 ways to find text: "Test Text 5" */
        String testText5 = "Test Text 5";
        assertEquals(testText5,driver.findElement(By.xpath("//*[@class='Test']")).getText());
//        1-2 ways to find text: "This is also a button"
        String button2 = "This is also a button";
        assertEquals(button2,driver.findElement(By.xpath("//input[@name='randomButton2']")).getAttribute("value"));
        assertEquals(button2,driver.findElement(By.xpath("//*[@type=\"button\" and @id=\"buttonId\"]")).getAttribute("value"));

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        String heading2 = "Heading 2 text";
        assertEquals(heading2,driver.findElement(By.cssSelector("h2#heading_2")).getText());
//        1-2 ways to find text: "Test Text 1"
        String testText1 = "Test Text 1";
        assertEquals(testText1,driver.findElement(By.cssSelector("#test1 > .test")).getText());
//        1-2 ways to find text: "Test Text 2"
        String testText2 = "Test Text 2";
        assertEquals(testText2,driver.findElement(By.cssSelector(".twoTest")).getText());

//        1-2 ways to find text: "Test Text 3"
        String testText3 = "Test Text 3";
        assertEquals(testText3, driver.findElements(By.cssSelector("#test3 > .test")).get(0).getText());
//        1-2 ways to find text: "This is also a button"
        String button2 ="This is also a button";
        assertEquals(button2,driver.findElement(By.cssSelector("#buttonId")).getAttribute("value"));
        assertEquals(button2,driver.findElement(By.cssSelector("[name=\"randomButton2\"]")).getAttribute("value"));

    }
}
