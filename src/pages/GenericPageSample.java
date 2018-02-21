package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class GenericPageSample {
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement header;
    @FindBy(how = How.CLASS_NAME, using = "copyrights")
    private WebElement copyrights;

    public String getPageHeader() {
        return header.getText();
    }

    public String getPageCopyrights() {
        return copyrights.getText();
    }
}
