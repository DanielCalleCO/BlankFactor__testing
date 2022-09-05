package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage {

    @FindBy(css = ".post-title")
    private WebElement blogTitle;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBlogTitle() {
        return this.blogTitle;
    }

}
