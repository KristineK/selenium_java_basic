package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6 {
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
    public void findElementById() throws Exception {
//        find element by id using xPath
        System.out.println("Find element by id using xPath:");
        System.out.println("\t text of element with id 'heading_1' is '" +
                driver.findElement(By.xpath("//*[@id='heading_1']")).getText() + "'");
        System.out.println("\t text of element with id 'standartText' is '" +
                driver.findElement(By.xpath("//*[@id='standartText']")).getText() + "'");
        System.out.println("\t text of element with id 'nonStandartText' is '" +
                driver.findElement(By.xpath("//*[@id='nonStandartText']")).getText() + "'");

//        find element by id using CSS
        System.out.println("Find element by id using CSS:");
        System.out.println("\t text of element with id 'heading_1' is '" +
                driver.findElement(By.cssSelector("#heading_1")).getText() + "'");
        System.out.println("\t text of element with id 'standartText' is '" +
                driver.findElement(By.cssSelector("#standartText")).getText() + "'");
        System.out.println("\t text of element with id 'nonStandartText' is '" +
                driver.findElement(By.cssSelector("#nonStandartText")).getText() + "'");
    }

    @Test
    public void findElementByAllClasses() throws Exception {
//        find element by all classes using xPath
        System.out.println("Find element by all classes using xPath:");
        System.out.println("\t text of element with class 'text' is '" +
                driver.findElement(By.xpath("//*[@class='text']")).getText() + "'");
        System.out.println("\t text of element with class 'text' and 'unbelievable' is '" +
                driver.findElement(By.xpath("//*[@class=\"text unbelievable\"]")).getText() + "'");

//        find element by all classes using CSS
        System.out.println("Find element by all classes using CSS:");
        System.out.println("\t text of element with class 'text' is '" +
                driver.findElement(By.cssSelector(".text")).getText() + "'");
        System.out.println("\t text of element with classes 'text' and 'unbelievable' is '" +
                driver.findElement(By.cssSelector(".text.unbelievable")).getText() + "'");
        System.out.println("\t text of element with classes 'text' and 'unbelievable' is '" +
                driver.findElement(By.cssSelector(".unbelievable.text")).getText() + "'");
    }

    @Test
    public void findElementBy1stClass() throws Exception {
//        find element by 1 of nth class using CSS
        System.out.println("Find element by 1 of nth class using xPath:");
        System.out.println("\t text of element with class 'unbelievable' is '" +
                driver.findElement(By.xpath("//*[contains(@class, 'unbelievable')]")).getText() + "'");

//        find element by 1 of nth class using CSS
        System.out.println("Find element by 1 of nth class using CSS:");
        System.out.println("\t text of element with class 'unbelievable' is '" +
                driver.findElement(By.cssSelector(".unbelievable")).getText() + "'");
    }

    @Test
    public void findElementByIdAndClass() throws Exception {
//        find element by id and class using xPath
        System.out.println("Find element by id and classes using xPath:");
        System.out.println("\t text of element with class 'text' and id 'dummy' is '" +
                driver.findElement(By.xpath("//*[contains(@class, 'text') and @id='dummy']")).getText() + "'");
        System.out.println("\t text of element with class 'text' and id 'dummy' v2 is '" +
                driver.findElement(By.xpath("//*[@class='text' and @id='dummy']")).getText() + "'");

//        find element by id and class using CSS
        System.out.println("Find element by id and classes using CSS:");
        System.out.println("\t text of element with class 'text' and id 'dummy' is '" +
                driver.findElement(By.cssSelector(".text#dummy")).getText() + "'");
        System.out.println("\t text of element with class 'text' and id 'dummy' v2 is '" +
                driver.findElement(By.cssSelector("#dummy.text")).getText() + "'");
    }

    @Test
    public void findElementByText() throws Exception {
//        find element by Text using xPath
        System.out.println("Find element by Text using xPath:");
        System.out.println("\t class of element with text 'sample text 1' is '" +
                driver.findElement(By.xpath("//*[text()='sample text 1']")).getAttribute("class") + "'");
        System.out.println("\t text of element which contains text 'dummy' is '" +
                driver.findElement(By.xpath("//*[contains(text(), 'dummy')]")).getText() + "'");
    }

    @Test
    public void findElementByTagName() throws Exception {
//        find element by tag name using xPath
        System.out.println("Find element by tag name using xPath:");
        System.out.println("\t text of element with tag name 'h2' is '" +
                driver.findElement(By.xpath("//h2")).getText() + "'");
        System.out.println("\t value of element with tag name 'input' is '" +
                driver.findElement(By.xpath("//input")).getAttribute("value") + "'");

//        find element by tag name using CSS
        System.out.println("Find element by tag name using CSS:");
        System.out.println("\t text of element with tag name 'h2' is '" +
                driver.findElement(By.cssSelector("h2")).getText() + "'");
        System.out.println("\t value of element with tag name 'input' is '" +
                driver.findElement(By.cssSelector("input")).getAttribute("value") + "'");
    }

    @Test
    public void findNthElement() throws Exception {
//        find nth element using xPath
        System.out.println("Find element nth using xPath:");
        System.out.println("\t text of 1-st element with tag name 'p' is '" +
                driver.findElement(By.xpath("//p[1]")).getText() + "'");
        System.out.println("\t text of 3-rd element with tag name 'p' is '" +
                driver.findElement(By.xpath("//p[3]")).getText() + "'");

//        find nth element using CSS
        System.out.println("Find element nth using CSS:");
        System.out.println("\t text of 1-st element with tag name 'p' is '" +
                driver.findElement(By.cssSelector("p:nth-of-type(1)")).getText() + "'");
        System.out.println("\t text of 3-rd element with tag name 'p' is '" +
                driver.findElement(By.cssSelector("p:nth-of-type(3)")).getText() + "'");
    }

    @Test
    public void findElementByOtherAttributes() throws Exception {
//        find element by other attributes using xPath (e.g. name)
        System.out.println("Find element by other attributes using xPath:");
        System.out.println("\t value of element with name 'randomButton1' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton1']")).getAttribute("value") + "'");
        System.out.println("\t name of element with value 'This is a button' is '" +
                driver.findElement(By.xpath("//*[@value='This is a button']")).getAttribute("name") + "'");
        System.out.println("\t value of element with type 'button' is '" +
                driver.findElement(By.xpath("//*[@type='button']")).getAttribute("value") + "'");

//        find child element using CSS
        System.out.println("Find element by other attributes using CSS:");
        System.out.println("\t value of element with name 'randomButton1' is '" +
                driver.findElement(By.cssSelector("[name='randomButton1']")).getAttribute("value") + "'");
        System.out.println("\t name of element with value 'This is a button' is '" +
                driver.findElement(By.cssSelector("[value='This is also a button']")).getAttribute("name") + "'");
        System.out.println("\t value of element with type 'button' is '" +
                driver.findElement(By.cssSelector("[type='button']")).getAttribute("value") + "'");
    }

    @Test
    public void findChildOrDescendantElement() throws Exception {
//        find child element using xPath
        System.out.println("Find child element using xPath:");
        System.out.println("\t text of element with tag name 'p' which is a direct child of element with tag name 'div' is '" +
                driver.findElement(By.xpath("//div/p")).getText() + "'");
        System.out.println("\t text of element with tag name 'p' which 3-rd a direct child of element with tag name 'div' is '" +
                driver.findElement(By.xpath("//div/p[3]")).getText() + "'");
        System.out.println("\t text of element with tag name 'p' which is a descendant child of element with tag name 'body' is '" +
                driver.findElement(By.xpath("//body//p")).getText() + "'");
        System.out.println("\t text of element with class 'amazing' which is a direct child of element with id 'nonStandartText' is '" +
                driver.findElement(By.xpath("//*[@id='nonStandartText']/p[contains(@class, 'amazing')]")).getText() + "'");

//        find element by other attributes using CSS (e.g. name)
        System.out.println("Find child element using CSS:");
        System.out.println("\t text of element with tag name 'p' which is a direct child of element with tag name 'div' is '" +
                driver.findElement(By.cssSelector("div > p")).getText() + "'");
        System.out.println("\t text of element with tag name 'p' which 3-rd a direct child of element with tag name 'div' is '" +
                driver.findElement(By.cssSelector("div > p:nth-child(3)")).getText() + "'");
        System.out.println("\t text of element with tag name 'p' which is a descendant child of element with tag name 'body' is '" +
                driver.findElement(By.cssSelector("body p")).getText() + "'");
        System.out.println("\t text of element with class 'amazing' which is a direct child of element with id 'nonStandartText' is '" +
                driver.findElement(By.cssSelector("#nonStandartText .amazing")).getText() + "'");
    }
}
