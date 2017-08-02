package selenium.sample1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {
    WebDriver driver;

    @Before
    public void startingTests() throws Exception {
        // from Sample 1
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
// definition above
//  WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        //open google homepage
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    @After
    public void endingTests() throws Exception {
        driver.close();
    }

        @Test
        public void findElementByID() throws Exception {
    // works:
            System.out.println(driver.findElement(By.id("heading")).getText());
//            System.out.println(driver.findElement(By.id("headingasdga")).getText());
            // org.openqa.selenium.NoSuchElementException:
            // no such element:
            // Unable to locate element: {"method":"id","selector":"headingasdga"}
        }

//        findElementByName (where you find element by name
// “randomButton” and then printout “value” attribute of this element)
        @Test
        public void findElementByName() throws Exception {
            // FRom page:
            // <input type="button" value="This is a button" name="randomButton" />
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("value")); // "This is a button"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("type")); // "button"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("name")); // "randomButton"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("id")); // empty
//            Unable to locate element: {"method":"name","selector":"randomButton123"}:
            System.out.println(driver.findElement(By.name("randomButton123")).getAttribute("value"));
        }

//        findElementByTagName (where you find element by tagName “h1” and then printout “id” attribute of this element)
        @Test
        public void findElementByTagName() throws Exception {
            // From page:
            // <h1 id="heading">Base page</h1>
            System.out.println(driver.findElement(By.tagName("h1")).getAttribute("id")); // "heading"
            System.out.println(driver.findElement(By.tagName("h1")).getText()); // "Base page"
        }

    //        findElementByClassFirst (where you find element by className “text” and then printout the text of this element)
    @Test
    public void findElementByClassFirst() throws Exception {

        // From page:
        // <h1 id="heading">Base page</h1>
        System.out.println(driver.findElement(By.className("text")).getText()); // "sample text 1"
    }

}
