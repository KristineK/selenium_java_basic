package selenium.sample1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {

        @Test
        public void  findElementByID() {
            // from Sample 1
            String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //open google homepage
            driver.get("https://kristinek.github.io/test-sample/examples/loc");

            System.out.println(driver.findElement(By.id("heading")).getText());

            driver.quit();
        }
}
