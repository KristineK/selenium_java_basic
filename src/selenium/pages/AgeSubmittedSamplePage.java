package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class AgeSubmittedSamplePage extends GenericSamplePage {
    @FindBy(how = How.CSS, using = "#message")
    private WebElement message;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement backButton;

    public void clickBackButton() {
        backButton.click();
    }

    public void checkMessageText(String messageText) {
        checkPageHeaderText("Age page");
        assertEquals(message.getText(), messageText);
    }
}