package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Task {
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
     public void findElementByID() throws Exception {
        System.out.println(driver.findElement(By.id("heading_2")).getText());
//         TODO:
//         get text "Heading 2 text" using id
//        <h2 id="heading_2">Heading 2 text</h2>
    }

    @Test
    public void findElementByName() throws Exception {
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("id"));
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value"));
//         TODO:
//         get attribute "id" and "value" of button "This is also a button" using name
//        <input type="button" id="buttonId" value="This is also a button" name="randomButton2">
    }

    @Test
    public void findElementByClassFirst() throws Exception {
        System.out.println(driver.findElement(By.className("test")).getText());
//         TODO:
//         get first text of class "test" (should be "Test Text 1")
    }

    @Test
    public void findElementByClassAll() throws Exception {
        System.out.println(driver.findElements(By.className("test")).size());
        System.out.println("----------------------");
        List<WebElement> allElements = driver.findElements(By.className("TEST"));
        for (WebElement myElement : allElements) {
            System.out.println(myElement.getText());
        }
        System.out.println("----------------------");
        System.out.println(driver.findElements(By.className("test")).get(2).getText());
//         TODO:
//         get size text of class "test" (should be 5)
//         get text of class "test"
//         get third text of class "test" (should be "Test Text 4")
    }
}
