package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#menu-item-4436")
    private WebElement insightsDropdown;

    @FindBy(css = ".page-item")
    private List<WebElement> insightElements;

    public void stepOverInsightDropdown() {
        this.actions.moveToElement(insightsDropdown).build().perform();
    }

    public void clickBlog() {
        insightElements.get(0).click();
    }
}
