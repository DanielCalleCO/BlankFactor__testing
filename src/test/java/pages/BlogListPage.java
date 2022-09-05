package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogListPage extends BasePage {

    @FindBy(xpath = "//a[text()='Why Fintech in Latin America Is Having a Boom']")
    protected WebElement trendingBlog;

    @FindBy(css = "input[name = 'Email']")
    protected WebElement newsLetterEmail;

    @FindBy(css = "#form-newsletter-blog-submit-btn")
    protected WebElement suscribeBtn;

    @FindBy(xpath = "//div[text()='Thank you for subscribing! Stay tuned.']")
    protected WebElement subscribedMessage;

    public BlogListPage(WebDriver driver) {
        super(driver);
    }

    public void clickTrendingBlog() {
        trendingBlog.click();
    }

    public void fillNewsLetterEmail(String email) {
        newsLetterEmail.sendKeys(email);
    }

    public void subscribeNewsLetter() {
        suscribeBtn.click();
    }

    public WebElement subscribeConfirm() {
        this.await.until(ExpectedConditions.visibilityOf(subscribedMessage));
        return subscribedMessage;
    }
}
