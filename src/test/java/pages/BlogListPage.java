package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogListPage extends BasePage {

    @FindBy(xpath = "//a[text()='Why Fintech in Latin America Is Having a Boom']")
    private WebElement trendingBlog;

    @FindBy(css = "input[name = 'Email']")
    private WebElement newsLetterEmail;

    @FindBy(css = "#form-newsletter-blog-submit-btn")
    private WebElement suscribeBtn;

    @FindBy(xpath = "//div[text()='Thank you for subscribing! Stay tuned.']")
    private WebElement subscribedMessage;

    @FindBy(css = ".blog-layout__list .post-title a")
    private List<WebElement> blogTitles;

    @FindBy(css = ".results div")
    private WebElement resultsDiv;

    @FindBy(css = ".bf-loader")
    private WebElement spinner;

    public BlogListPage(WebDriver driver) {
        super(driver);
    }

    // public List<WebElement> getBlogTitles() {
    // return this.blogTitles;
    // }

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

    public void printEntireBlogList() {
        boolean isDisplayed = true;
        do {
            this.scrollTo(this.blogTitles.get(this.blogTitles.size() - 1));
            if (spinner.isDisplayed()) {
                this.scrollTo(this.blogTitles.get(this.blogTitles.size() - 2));
            } else {
                isDisplayed = false;
                break;
            }
        } while (isDisplayed);
        this.blogTitles.stream()
                .forEach(e -> System.out.println(e.getText() + " | Related link:" + e.getAttribute("href")));
    }
}
