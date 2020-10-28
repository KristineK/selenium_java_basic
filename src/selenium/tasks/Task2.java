package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }
//https://kristinek.github.io/site/tasks/provide_feedback
    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked

        assertEquals("", driver.findElement(By.id("fb_name")).getText());
        assertEquals("", driver.findElement(By.id("fb_age")).getText());

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("#lang_check[type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
        assertFalse(driver.findElement(By.cssSelector(".w3-radio[value='male'][type='radio']")).isSelected());
        assertFalse(driver.findElement(By.cssSelector(".w3-radio[value='female'][type='radio']")).isSelected());
        //assertTrue(driver.findElement(By.cssSelector(".w3-radio[value='gender'][type='radio']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector(".w3-radio[value='gender'][type='radio']")).getCssValue("value"));
        Thread.sleep(3000);
//         "Don't know" is selected in "Genre"

//         "Choose your option" in "How do you like us?"
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Ok, i guess");
        Thread.sleep(2000);

//         check that the button send is blue with white letters
        WebElement btnColor = driver.findElement(By.xpath("//h2[@id='message']"));
        assertEquals("rgba(255, 255, 255, 1)", btnColor.getCssValue("color"));
        System.out.println(btnColor.getCssValue("background-color"));
        assertEquals("rgba(0, 0, 0, 0)", btnColor.getCssValue("background-color"));
        Thread.sleep(2000);
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(2000);
//         check fields are empty or null
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("age")).getText() );
        assertEquals("",driver.findElement(By.id("language")).getText() );
        assertEquals("",driver.findElement(By.id("gender")).getText() );
        assertEquals("",driver.findElement(By.id("option")).getText() );

//         check button colors
        WebElement btnGreen = driver.findElement(By.xpath("//button[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(76,175,88,1)", btnGreen.getCssValue("background-color"));
        WebElement btn2Green = driver.findElement(By.xpath("//button[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(244, 67, 54, 1)", btnGreen.getCssValue("background-color"));

//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
        WebElement name = driver.findElement(By.id("fb_name"));
        name.sendKeys("Jevgenijs");
        driver.findElement(By.id("fb_age")).sendKeys("35");
        driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'")).click();
        driver.findElement(By.className("w3-radio")).click();
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Ok, i guess");
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(2000);
//         check fields are filled correctly
        assertEquals("Jevgenijs", driver.findElement(By.id("name")).getText());
        assertEquals("35",driver.findElement(By.id("age")).getText() );
        assertEquals("English",driver.findElement(By.id("language")).getText() );
        assertEquals("male",driver.findElement(By.id("gender")).getText() );
        assertEquals("Good",driver.findElement(By.id("option")).getText() );
//        assertTrue(driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'")).isSelected());
////        assertTrue(driver.findElement(By.className("w3-radio")).isSelected());
        Thread.sleep(2000);

//         check button colors
        WebElement btnGreen = driver.findElement(By.xpath("//button[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(76,175,88,1)", btnGreen.getCssValue("background-color"));
        WebElement btn2Green = driver.findElement(By.xpath("//button[@class = 'w3-btn w3-green w3-xlarge']"));
        assertEquals("rgba(244, 67, 54, 1)", btnGreen.getCssValue("background-color"));

//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        WebElement name =  driver.findElement(By.id("fb_name"));
        name.sendKeys("Jevgenijs");
        Thread.sleep(2000);
//         click "Send"
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(2000);
//         click "Yes"
        driver.findElement(By.xpath("//div[@class = 'w3-btn-group']/button[1]")).click();
        Thread.sleep(2000);
//         check message text: "Thank you, NAME, for your feedback!"
        assertEquals("Thank you, Jevgenijs, for your feedback!", driver.findElement(By.xpath("//h2[@id='message']")).getText());
        Thread.sleep(2000);
//         color of text is white with green on the background
        WebElement textColor = driver.findElement(By.xpath("//h2[@id='message']"));
        assertEquals("rgba(255, 255, 255, 1)", textColor.getCssValue("color"));
        assertEquals("rgba(0, 0, 0, 0)", textColor.getCssValue("background-color"));
//        System.out.println(textColor.getCssValue("color"));
//        System.out.println(textColor.getCssValue("background-color"));
        Thread.sleep(2000);
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(2000);

//         click "Yes"
        driver.findElement(By.xpath("//div[@class = 'w3-btn-group']/button[1]")).click();
        Thread.sleep(2000);

//         check message text: "Thank you for your feedback!"
        assertEquals("Thank you for your feedback!", driver.findElement(By.xpath("//h2[@id='message']")).getText());
        Thread.sleep(2000);

//         color of text is white with green on the background
        WebElement textColor = driver.findElement(By.xpath("//h2[@id='message']"));
        assertEquals("rgba(255, 255, 255, 1)", textColor.getCssValue("color"));
        assertEquals("rgba(0, 0, 0, 0)", textColor.getCssValue("background-color"));
        Thread.sleep(2000);
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        WebElement name = driver.findElement(By.id("fb_name"));
        name.sendKeys("Jevgenijs");
        driver.findElement(By.id("fb_age")).sendKeys("35");
        driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'")).click();
        driver.findElement(By.className("w3-radio")).click();
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Ok, i guess");
        Thread.sleep(2000);

//         click "Send"
        driver.findElement(By.className("w3-btn-block")).click();
        Thread.sleep(2000);

//         click "No"
        driver.findElement(By.xpath("//div[@class = 'w3-btn-group']/button[2]")).click();
        Thread.sleep(2000);

//         check fields are filled correctly
        //System.out.println(driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals("Jevgenijs", driver.findElement(By.id("fb_name")).getAttribute("value"));
        //System.out.println(driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertEquals("35",driver.findElement(By.id("fb_age")).getAttribute("value") );
        //System.out.println(driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'")).getAttribute("value"));
        assertEquals("English",driver.findElement(By.cssSelector(".w3-check[value='English'][type='checkbox'")).getAttribute("value") );
        //System.out.println(driver.findElement(By.className("w3-radio")).getAttribute("value"));
        assertEquals("male", driver.findElement(By.className("w3-radio")).getAttribute("value"));
        //System.out.println(driver.findElement(By.xpath("//select[@class = 'w3-select']/option[3]")).getAttribute("value"));
        assertEquals("Ok, i guess", driver.findElement(By.xpath("//select[@class = 'w3-select']/option[3]")).getAttribute("value") );
        Thread.sleep(2000);
    }
}
