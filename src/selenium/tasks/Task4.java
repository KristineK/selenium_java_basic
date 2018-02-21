package selenium.tasks;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

//import pages.FormPage;
//import pages.ListPage;

public class Task4 {
    static WebDriver driver;
//	FormPage formPage = PageFactory.initElements(driver, FormPage.class);
//	ListPage listPage = PageFactory.initElements(driver, ListPage.class);

    @BeforeClass
    public static void openPage(){
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/test-sample/tasks/task3");
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }

    @Test
    public void addPerson(){
		/* TODO:
		 * implement adding new person using page object
		 */
    }

    @Test
    public void editPerson(){
		/* TODO:
		 * implement editing a person using page object
		 */
    }

    @Test
    public void deletePerson(){
		/* TODO:
		 * implement deleting a person using page object
		 */
    }
}
