package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class Sample2Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        // System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
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
//         TODO:
//         get text "Heading 2 text" using id
        System.out.println(driver.findElement(By.id("heading_2")).getText());
    }

    @Test
    public void findElementByName() throws Exception {
//         TODO:
//         get attribute "id" and "value" of button "This is also a button" using name
        WebElement randomButton = driver.findElement(By.name("randomButton2"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("id"));
    }

    @Test
    public void findElementByClassFirst() throws Exception {
//         TODO:
//         get first text of class "test" (should be "Test Text 1")
        System.out.println("Test Text: "+ driver.findElements(By.className("test")).get(0).getText());
        System.out.println("Test Text: "+ driver.findElement(By.className("test")).getText());
    }

    @Test
    public void findElementByClassAll() throws Exception {
//         TODO:
//         get size text of class "test" (should be 5)
//         get text of class "test"
//         get third text of class "test" (should be "Test Text 4")
        List<WebElement> allElements = driver.findElements(By.className("test"));
        System.out.println("Size: " + allElements.size());
        System.out.println("All Text");
        for (WebElement element: allElements){
            System.out.println(element.getText());
        }
        System.out.println("Third: " +allElements.get(2).getText());

    }

}
