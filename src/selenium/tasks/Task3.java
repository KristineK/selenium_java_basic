package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Task3 {
    static WebDriver driver;

    @Before
    public void openPage() throws Exception{
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() throws Exception{
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that then
//        check that the button yes is green and no is red but both have white letters
        String myName = "Eduards";
        String myAge = "30";
        String myComment = "It was amazing!";

        driver.findElement(By.id("fb_name")).sendKeys(myName);
        driver.findElement(By.id("fb_age")).sendKeys(myAge);
        driver.findElement(By.cssSelector(".w3-check[value='lang_eng'][type='checkbox']")).click();
        driver.findElement(By.cssSelector(".w3-check[value='lang_fr'][type='checkbox']")).click();
        driver.findElement(By.cssSelector(".w3-check[value='lang_man'][type='checkbox']")).click();

        driver.findElement(By.cssSelector(".w3-radio[value='gen_male'][type='radio']")).click();

        Select myOpinion = new Select(driver.findElement(By.id("like_us")));
        myOpinion.selectByVisibleText("Good");

        driver.findElement(By.cssSelector("textarea")).sendKeys(myComment);
        System.out.println(driver.findElement(By.cssSelector("[type='button'][onclick='show_fd_review()']")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("[type='button'][onclick='show_fd_review()']")).getCssValue("text-decoration-color"));
        assertEquals("rgba(33, 150, 243, 1)",driver.findElement(By.cssSelector("[type='button'][onclick='show_fd_review()']")).getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255)",driver.findElement(By.cssSelector("[type='button'][onclick='show_fd_review()']")).getCssValue("text-decoration-color"));

        driver.findElement(By.cssSelector("[type='button'][onclick='show_fd_review()']")).click();

        assertEquals("Your name: "+ myName, driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[1]")).getText());
        assertEquals("Your age: "+ myAge, driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[2]")).getText());
        assertEquals("Your language: English, French, Chinese", driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[3]")).getText());
        assertEquals("Your genre: Male", driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[4]")).getText());
        assertEquals("Your option of us: Good", driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[5]")).getText());
        assertEquals("Your comment: " + myComment , driver.findElement(By.xpath("//*[@id=\"fb_thx\"]/div/div[1]/p[6]")).getText());

        System.out.println(driver.findElement(By.cssSelector("button[onclick='show_thanks()']")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("button[onclick='show_thanks()']")).getCssValue("text-decoration-color"));
        System.out.println(driver.findElement(By.cssSelector("button[onclick='show_fb_edit()']")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("button[onclick='show_fb_edit()']")).getCssValue("text-decoration-color"));
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("button[onclick='show_thanks()']")).getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255)", driver.findElement(By.cssSelector("button[onclick='show_thanks()']")).getCssValue("text-decoration-color"));
        assertEquals("rgba(244, 67, 54, 1)", driver.findElement(By.cssSelector("button[onclick='show_fb_edit()']")).getCssValue("background-color"));
        assertEquals("rgb(255, 255, 255))", driver.findElement(By.cssSelector("button[onclick='show_fb_edit()']")).getCssValue("text-decoration-color"));






    }
}
