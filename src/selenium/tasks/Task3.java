package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    static WebDriver driver;

    @Before
    public static void openPage() {
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task4");
    }

    @After
    public static void closeBrowser(){
        driver.quit();
    }

    @Test
    public void feedback() {
//        fill in "name", "age", select 1 or more language, select genre, select option, add a comment
//        check that the button send is blue with white letters
//        click "send"
//        check that the feedback was filled correctly
//        check that then
//        check that the button yes is green and no is red but both have white letters
    }
}
