package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }
//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());

//        tick  "Option 3"
        option3.click();

//        click result
        driver.findElement(By.id("result_button_checkbox")).click();

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed result_checkbox
        WebElement text = driver.findElement(By.id("result_checkbox"));
        assertEquals("You selected value(s): Option 2, Option 3", text.getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));


//         TODO:
//        check that none of the radio are selected
        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
        }
//        select  "Option 3"
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
        option3.click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

//        select  "Option 1"
        option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option1.isSelected());

//        click result
        driver.findElement(By.id("result_button_ratio")).click();

//        check that 'You selected option: Option 1' text is being displayed
        WebElement text = driver.findElement(By.id("result_radio"));
        assertEquals("You selected option: Option 3", text.getText());
    }

    @Test
    public void selectOption() throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
//        select "Option 3" in Select
        dropdown.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());
        Thread.sleep(3000);

//        select "Option 2" in Select
        dropdown.selectByVisibleText("Option 2");

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
        driver.findElement(By.id("result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
        WebElement text = driver.findElement(By.id("result_select"));
        assertEquals("You selected option: Option 2", text.getText());
        Thread.sleep(5000);
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
        String dateToEnter = "07/04/2007";
//         TODO:
//        enter date '4 of July 2007' using calendar widget
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        cal.add(Calendar.YEAR, -13);
        String result = new SimpleDateFormat("MM/04/yyyy").format(cal.getTime());
        System.out.println(result);
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        Thread.sleep(5000);
        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));

        for (int i = 0; i < 159; i++) {
            dateWidget.findElement(By.className("ui-datepicker-prev")).click();
        }

        Thread.sleep(8000);
        dateWidget.findElement(By.xpath("//a[text()='4']")).click();

        //assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();
        Thread.sleep(5000);

    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
        String dateToEnter2 = "05/02/1959";
//         TODO:
//        enter date '2 of May 1959' using text
        WebElement dateBox2 = driver.findElement(By.id("vfb-8"));
        dateBox2.sendKeys(dateToEnter2);
        Thread.sleep(2000);

//        check that correct date is added
        dateBox2.clear();
        dateBox2.sendKeys(dateToEnter2);
        Thread.sleep(2000);
        assertEquals(dateToEnter2, dateBox2.getAttribute("value"));

        Thread.sleep(3000);

    }
}
