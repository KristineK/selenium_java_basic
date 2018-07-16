package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;


public class GenericSamplePage {
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement header;

    public String getPageHeader() {
        return header.getText();
    }

    public void checkPageHeaderText(String aHeaderText) {
        assertEquals(getPageHeader(), aHeaderText);
    }
}
