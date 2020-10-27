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
    public void findElementByXPath() throws Exception {
//         TODO:
        //2 ways to find text: "Heading 2 text":
        System.out.println("Find element by id using xPath:");
        System.out.println("\tFirst way to find text by id : \"Heading 2 text\" is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\tSecond way to find text by text: \"Heading 2 text\" is '" +
                driver.findElement(By.xpath("//h2[contains(text(), 'Heading 2 text')]")).getText() + "'");
        Thread.sleep(4000);

//        1-2 ways to find text: "Test Text 1" //div[@class='example']//p  //p[contains(text(),'Test Text 1')]
        System.out.println("\tFirst way to find text by Element By ID: \"Test Text 1\" is '" +
                driver.findElement(By.xpath("//div[@id='test1']//p")).getText() + "'");
        System.out.println("\tSecond way to find text by contains text : \"Test Text 1\" is '" +
                driver.findElement(By.xpath("//p[contains(text(),'Test Text 1')]")).getText() + "'");
        Thread.sleep(4000);
//
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\tFirst way to find text by contains text : \"Test Text 2\" is '" +
                driver.findElement(By.xpath("//p[contains(text(),'Test Text 2')]")).getText() + "'");
        System.out.println("\tSecond way to find text by Element By class: \"Test Text 2\" is '" +
                driver.findElement(By.xpath("//p[@class='twoTest']")).getText() + "'");
        Thread.sleep(4000);
//
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\tFirst way to find text by Element By ID: \"Test Text 3\" is '" +
                driver.findElement(By.xpath("//div[@id='test3']//p")).getText() + "'");
        System.out.println("\tSecond way to find text by contains text : \"Test Text 3\" is '" +
                driver.findElement(By.xpath("//p[contains(text(),'Test Text 3')]")).getText() + "'");
        Thread.sleep(4000);

//        1-2 ways to find text: "Test Text 4"
        System.out.println("\tFirst way to find text by contains text : \"Test Text 4\" is '" +
                driver.findElement(By.xpath("//p[contains(text(),'Test Text 4')]")).getText() + "'");
        System.out.println("\tFirst way to find text by Element By ID and child: \"Test Text 4\" is '" +
                driver.findElement(By.xpath("//div[@id='test3']/p[2]")).getText() + "'");
        Thread.sleep(4000);

//        1-2 ways to find text: "Test Text 5"
        System.out.println("\tFirst way to find text by Element By ID: \"Test Text 5\" is '" +
                driver.findElement(By.xpath("//div[@id='test2']//p")).getText() + "'");
        System.out.println("\tSecond way to find text by Element By class: \"Test Text 5\" is '" +
                driver.findElement(By.xpath("//p[@class='Test']")).getText() + "'");
        Thread.sleep(4000);
//
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t value of element with name 'randomButton2' is '" +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");
        System.out.println("\t value of element with name 'randomButton2' is '" +
                driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value") + "'");

        Thread.sleep(4000);

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t text of element with id 'Heading 2 text' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with tag name 'p' which is a direct child of element with tag name 'div' is '" +
                driver.findElement(By.cssSelector("div#test1 p")).getText() + "'");

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with tag name 'p' which is a direct child of element with tag name 'div' is '" +
                driver.findElement(By.cssSelector("div#test3 p")).getText() + "'");

//        1-2 ways to find text: "This is also a button"
        System.out.println("\t value of element with tag name 'randomButton2' is '" +
                driver.findElement(By.cssSelector("[name='randomButton2']")).getAttribute("value") + "'");
    }
}
