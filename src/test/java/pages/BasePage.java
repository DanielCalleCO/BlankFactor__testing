package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected Actions actions;
    public WebDriverWait await;
    protected JavascriptExecutor jsActions;

    @FindBy(css = "#hs-eu-confirmation-button")
    protected WebElement cookies;

    public WebElement getCookies() {
        return this.cookies;
    }

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
        this.await = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.jsActions = (JavascriptExecutor) driver;
    }

    public void acceptCokies() {
        cookies.click();
    }

    public void scrollTo(WebElement element) {
        this.jsActions.executeScript("arguments[0].scrollIntoView()", element);
    }
}
