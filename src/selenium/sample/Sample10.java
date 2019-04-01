package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.AgeSamplePage;
import selenium.pages.AgeSubmittedSamplePage;

import java.util.concurrent.TimeUnit;

public class Sample10 {
    static WebDriver driver;
    static AgeSamplePage agePage;
    static AgeSubmittedSamplePage ageSubmittedPage;

    @Before
    public void openPage() throws InterruptedException {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://kristinek.github.io/site/examples/age");
        agePage = PageFactory.initElements(driver, AgeSamplePage.class);
        ageSubmittedPage = PageFactory.initElements(driver, AgeSubmittedSamplePage.class);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void checkCleanPage() throws Exception {
        agePage.checkThatFormIsClean();
    }

    @Test
    public void checkErrorMessageOnEmptyAge() throws Exception {
        agePage.clickSubmit();
        agePage.checkErrorMessage("You haven't entered anything in age field");
    }

    @Test
    public void checkErrorMessageOnEmptyName() throws Exception {
        agePage.enterAge(3);
        agePage.clickSubmit();
        agePage.checkErrorMessage("You haven't entered anything in name field");
    }

    @Test
    public void checkSuccessfulMessageForKid() throws Exception {
        agePage.enterNameAgeAndClickSubmit("Ann", 5);
        ageSubmittedPage.checkMessageText("Hello, Ann, you are a kid");
    }

    @Test
    public void checkSuccessfulMessageForAdult() throws Exception {
        agePage.enterNameAgeAndClickSubmit("Tom", 55);
        ageSubmittedPage.checkMessageText("Hello, Tom, you are an adult");
    }

    @Test
    public void checkBackButton() throws Exception {
        agePage.enterNameAgeAndClickSubmit("Tom", 55);
        ageSubmittedPage.clickBackButton();
        agePage.checkThatFormIsClean();
    }
}
