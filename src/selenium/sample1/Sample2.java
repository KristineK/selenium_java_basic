package selenium.sample1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {

        @Test
        public void findElementByID() {
            // from Sample 1
            String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //open google homepage
            driver.get("https://kristinek.github.io/test-sample/examples/loc");
    // works:
            System.out.println(driver.findElement(By.id("heading")).getText());
//            System.out.println(driver.findElement(By.id("headingasdga")).getText());
            // org.openqa.selenium.NoSuchElementException:
            // no such element:
            // Unable to locate element: {"method":"id","selector":"headingasdga"}
            driver.quit();
        }

//        findElementByName (where you find element by name
// “randomButton” and then printout “value” attribute of this element)
        @Test
        public void findElementByName() {
            // from Sample 1
            String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //open google homepage
            driver.get("https://kristinek.github.io/test-sample/examples/loc");
            // FRom page:
            // <input type="button" value="This is a button" name="randomButton" />
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("value")); // "This is a button"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("type")); // "button"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("name")); // "randomButton"
            System.out.println(driver.findElement(By.name("randomButton")).getAttribute("id")); // empty
//            Unable to locate element: {"method":"name","selector":"randomButton123"}:
            System.out.println(driver.findElement(By.name("randomButton123")).getAttribute("value"));
            driver.quit();
        }
}
