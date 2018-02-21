package selenium.sample;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.MainPageSample;
import pages.PageSample;

public class Sample10 {
    static WebDriver driver = new FirefoxDriver();
    static long startTime;
    static PageSample subPage = PageFactory.initElements(driver, PageSample.class);
    static MainPageSample mainPage = PageFactory.initElements(driver, MainPageSample.class);

    @Before
    public void openPage() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://kristinek.github.io/test-sample/examples/po");
        assertEquals("Some copyrights text", mainPage.getPageCopyrights());
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testMainPage() throws Exception {
        assertEquals("Lorem ipsum", mainPage.getPageHeader());
        assertEquals("Lorem ipsum!", mainPage.getHeader(0));
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. More >>",
                mainPage.getDescriptionText(0));
        assertEquals("Lorem ipsum!", mainPage.getHeader(1));
        assertEquals("Jura", mainPage.getImageAlt(1));
        assertEquals("More >>",
                mainPage.getDescriptionText(1));
        assertEquals("Lorem ipsum!", mainPage.getHeader(2));
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. More >>",
                mainPage.getDescriptionText(2));
        assertEquals("Lorem ipsum!", mainPage.getHeader(3));
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. More >>",
                mainPage.getDescriptionText(3));
        assertEquals("Lorem ipsum!", mainPage.getHeader(4));
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. More >>",
                mainPage.getDescriptionText(4));
    }

    @Test
    public void testSubPage1() throws Exception {
        mainPage.clickOnHeaderLink(0);
        subPage.checkButton();
        assertEquals("Lorem ipsum 1!", subPage.getPageHeader());
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                subPage.getText());
    }

    @Test
    public void testSubPage2() throws Exception {
        mainPage.clickOnHeaderLink(1);
        subPage.checkButton();
        assertEquals("Lorem ipsum 2!", subPage.getPageHeader());
        assertEquals("Jura", subPage.getImageAlt());
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                subPage.getText());
    }
}
