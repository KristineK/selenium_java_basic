import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Student on 8/2/2017.
 */
public class Smaple2 {
    public void findElementById(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
        System.out.println(driver.findElement(By.id("heading")).getText());
        driver.quit();

    }
    public void findElementByName(){

    }
    public void findElementByTagName(){

    }
    public void findElementByClassFirst(){

    }
}
