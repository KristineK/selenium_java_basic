package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        //System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
        assertTrue(driver.findElement(By.id("fb_name")).getAttribute("value").isEmpty());
        assertTrue(driver.findElement(By.id("fb_age")).getAttribute("value").isEmpty());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[2]")).isSelected());

        String selectedOption = new Select(driver.findElement(By.id("like_us"))).getFirstSelectedOption().getText();
        assertEquals("Choose your option", selectedOption);
        assertTrue(driver.findElement(By.name("comment")).getAttribute("value").isEmpty());
//         "Don't know" is selected in "Genre"
        assertTrue(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[3]")).isSelected());

//         "Choose your option" in "How do you like us?"

//         check that the button send is blue with white letters
        assertEquals("rgba(33, 150, 243, 1)",driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).click();
//         check fields are empty or null
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("age")).getText());
        assertEquals("",driver.findElement(By.id("language")).getText());
        assertEquals("null",driver.findElement(By.id("gender")).getText());
        assertEquals("null",driver.findElement(By.id("option")).getText());
        assertEquals("",driver.findElement(By.id("comment")).getText());

//         check button colors
//         (green with white letter and red with white letters)
       assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).getCssValue("background-color"));
       assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).getCssValue("color"));
       assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).getCssValue("background-color"));

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
        driver.findElement(By.id("fb_name")).sendKeys("yash");
        driver.findElement(By.id("fb_age")).sendKeys("23");
        WebElement englishOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        englishOption.click();
        WebElement frenchOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        frenchOption.click();
        WebElement spanishOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        spanishOption.click();
        WebElement chineseOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        chineseOption.click();
        WebElement maleRadio1 = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]"));
        maleRadio1.click();

        Select likeOption = new Select(driver.findElement(By.id("like_us")));
        likeOption.selectByVisibleText("Good");

        driver.findElement(By.name("comment")).sendKeys("Say Something..");
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).click();
//         check fields are filled correctly
        assertEquals("yash",driver.findElement(By.id("name")).getText());
        assertEquals("23",driver.findElement(By.id("age")).getText());
        assertEquals("English,French,Spanish,Chinese",driver.findElement(By.id("language")).getText());
        assertEquals("male",driver.findElement(By.id("gender")).getText());
        assertEquals("Good",driver.findElement(By.id("option")).getText());
        assertEquals("Say Something..",driver.findElement(By.id("comment")).getText());
//         check button colors
        assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).getCssValue("background-color"));

//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        driver.findElement(By.id("fb_name")).sendKeys("yash");
//         click "Send"
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).click();
//         click "Yes"
        driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).click();
//         check message text: "Thank you, NAME, for your feedback!"
        assertEquals("Thank you, yash, for your feedback!",driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.id("message")).findElement(By.xpath("./..")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.id("message")).findElement(By.xpath("./..")).getCssValue("background-color"));

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).click();
//         click "Yes"
        driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[1]")).click();
//         check message text: "Thank you for your feedback!"
        assertEquals("Thank you for your feedback!",driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.id("message")).findElement(By.xpath("./..")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.id("message")).findElement(By.xpath("./..")).getCssValue("background-color"));


    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        driver.findElement(By.id("fb_name")).sendKeys("yash");
        driver.findElement(By.id("fb_age")).sendKeys("23");
        WebElement englishOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]"));
        englishOption.click();
        WebElement frenchOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]"));
        frenchOption.click();
        WebElement spanishOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]"));
        spanishOption.click();
        WebElement chineseOption = driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]"));
        chineseOption.click();
        WebElement maleRadio1 = driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]"));
        maleRadio1.click();

        Select likeOption = new Select(driver.findElement(By.id("like_us")));
        likeOption.selectByVisibleText("Good");

        driver.findElement(By.name("comment")).sendKeys("Say Something..");
//         click "Send"
        driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/button")).click();
//         click "No"
        driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[2]/button[2]")).click();
//         check fields are filled correctly

        assertEquals("yash",driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals("23",driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[1]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[2]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[3]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"lang_check\"]/input[4]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id=\"fb_form\"]/form/div[4]/input[1]")).isSelected());

        String selectedOption = new Select(driver.findElement(By.id("like_us"))).getFirstSelectedOption().getText();
        assertEquals("Good", selectedOption);
        assertEquals("Say Something..",driver.findElement(By.name("comment")).getAttribute("value"));


    }
}
