package selenium.sample1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

        System.out.println(driver.findElement(By.className("text")).getText()); // "sample text 1"
    }

//    findElementByClassAll (where you find elements by className “text” and
// then printout number of elements // 5�
// the text of this elements // “sample text 1”; “sample text 2”; “unbelievable sample text”; “amazing sample text”; “dummy text”�
// (3rd element) // "unbelievable sample text"
    @Test
    public void findElementByClassAll() throws Exception {
        System.out.println(driver.findElements(By.id("headingasdga")).size()); // 0
        System.out.println(driver.findElements(By.className("text")).size()); // 5
        List <WebElement> allElementsWithClass = driver.findElements(By.className("text"));

        for (WebElement elementWithClass : allElementsWithClass) {
            System.out.println(elementWithClass.getText());
//            sample text 1
//            sample text 2
//            unbelievable sample text
//            amazing sample text
//            dummy text
        }
        System.out.println(driver.findElements(By.className("text")).get(2).getText()); // "unbelievable sample text"
    }

//            findElementByXPath (where you find element by xpath
// “//div[@id='nonStandartText']/*[contains(@class, 'amazing')]” and then printout the text of this element
// amazing sample text�
// where you find element by xpath “//p[@class='text' and @id='dummy']” and then printout the text of this element) �
// dummy text

    @Test
    public void findElementByXPath() throws Exception {
        System.out.println(
                driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class, 'amazing')]")).getText());
        // amazing sample text

        System.out.println(
                driver.findElement(By.xpath("//p[@class='text' and @id='dummy']")).getText());
        // dummy text
    }
//            findElementByCssName (where you find element by css “div#nonStandartText > .amazing” and then printout the text of this element // amazing sample text�
// where you find element by css “.text#dummy” and then printout the text of this element) // dummy text/

    @Test
    public void findElementByCssName() throws Exception {
        System.out.println(
                driver.findElement(By.cssSelector("div#nonStandartText > .amazing")).getText());
        System.out.println(
                driver.findElement(By.cssSelector(".text#dummy")).getText());

    }

}
