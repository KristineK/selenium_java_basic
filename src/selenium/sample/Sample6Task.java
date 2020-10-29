package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
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
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find element using xPath:");
        System.out.println("\t text of element with xPath 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element with xPath 'heading_2' is '" +
                driver.findElement(By.xpath("/html[1]/body[1]/h2[2]")).getText() + "'");
        System.out.println("\t text of element with xPath 'test1' is '" +
                driver.findElement(By.xpath("//*[@id=\"test1\"]/p[1]")).getText() + "'");
        System.out.println("\t text of element with xPath 'test1/p2' is '" +
                driver.findElement(By.xpath("//*[@id=\"test1\"]/p[2]")).getText() + "'");
        System.out.println("\t text of element with xPath 'test3' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[1]")).getText() + "'");
        System.out.println("\t text of element with xPath 'test3/p2' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[2]")).getText() + "'");
        System.out.println("\t text of element with xPath 'test2/p1' is '" +
                driver.findElement(By.xpath("//*[@id=\"test2\"]/p[1]")).getText() + "'");
        System.out.println("\t text of element with xPath 'ButtonId' is '" +
                driver.findElement(By.xpath("//*[@id=\"buttonId\"]")).getAttribute("value") + "'");

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
        System.out.println("Find element using CSS:");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
        System.out.println("\t text of element with id 'test1/p1' is '" +
                driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(6) > p.test")).getText() + "'");
        System.out.println("\t text of element with id 'test1/p2' is '" +
                driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(6) > p.twoTest")).getText() + "'");
        System.out.println("\t text of element with id 'test3' is '" +
                driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(7) > p.test:nth-child(1)")).getText() + "'");
        System.out.println("\t text of element with id 'buttonId' is '" +
                driver.findElement(By.cssSelector("#buttonId")).getAttribute("value") + "'");
    }
}
