package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class PageSample extends GenericPageSample {

    @FindBy(how = How.CSS, using = ".w3-row")
    private WebElement text;
    @FindBy(how = How.CSS, using = ".w3-btn")
    private WebElement backButton;
    @FindBy(how = How.CSS, using = ".w3-row img")
    private WebElement image;

    public String getText() {
        return text.getText();
    }

    public void checkButton() {
        assertEquals(backButton.getText(), "<< Back");
        assertEquals("https://kristinek.github.io/test-sample/examples/po", backButton.getAttribute("href"));
    }

    public String getImageAlt() {
        return image.getAttribute("alt");
    }
}