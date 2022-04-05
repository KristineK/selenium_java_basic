package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

       // System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        System.setProperty("webdriver.chrome.driver","/Users/mymac/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("q");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        assertEquals("Please enter a number",driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("34");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        assertEquals("Number is too small",driver.findElement(By.id("ch1_error")).getText());


    }

    @Test
    public void errorOnNumberTooBig() {
      //  enter number which is too big (above 100), check that correct error is seen
        driver.findElement(By.id("numb")).sendKeys("101");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        assertEquals("Number is too big",driver.findElement(By.id("ch1_error")).getText());

//        BUG: if I enter number 666 no errors where seen
        driver.findElement(By.id("numb")).sendKeys("666");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        assertEquals("Number is too big",driver.findElement(By.id("ch1_error")).getText());

//        TODO
//        enter number which is too big (above 100), check that correct error is seen

    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("64");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        Alert newAlert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", newAlert.getText());
//        click ok on second alert
        newAlert.accept();

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        driver.findElement(By.id("numb")).sendKeys("51");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
        Alert newAlert = driver.switchTo().alert();
        assertEquals("Square root of 51 is 7.14", newAlert.getText());
//        click ok on second alert
        newAlert.accept();
    }
}
