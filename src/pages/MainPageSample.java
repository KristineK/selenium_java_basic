package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPageSample extends GenericPageSample {
    @FindBy(how = How.CSS, using = ".w3-container a.header_link")
    private List<WebElement> headerLinks;
    @FindBy(how = How.CSS, using = ".w3-container > h2")
    private List<WebElement> headers;
    @FindBy(how = How.CSS, using = ".w3-container > .description")
    private List<WebElement> descriptions;

    public String getHeader(int index) {
        return headers.get(index).getText();
    }

    public void clickOnHeaderLink(int index) {
        headerLinks.get(index).click();
    }

    public String getDescriptionText(int index) {
        return descriptions.get(index).getText();
    }

    public String getImageAlt(int index) {
        return descriptions.get(index).findElement(By.tagName("img")).getAttribute("alt");
    }
}
