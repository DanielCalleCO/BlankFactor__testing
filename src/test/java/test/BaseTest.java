package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.BlogListPage;
import pages.BlogPage;
import pages.HomePage;

public class BaseTest {
    protected static WebDriver driver;
    protected static ChromeOptions chromeOptions;
    protected HomePage homePage;
    protected BlogListPage blogListPage;
    protected BlogPage blogPage;

    public void initializePage() {
        this.homePage = new HomePage(driver);
        this.blogListPage = new BlogListPage(driver);
        this.blogPage = new BlogPage(driver);
    }

    @Before
    public void initialSetup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Daniel/Dropbox/Repositorio/08_Personal/BlankFactor__testing/src/test/resources/chromedriver.exe");
        chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        initializePage();
        driver.get("http://blankfactor.com");
        driver.manage().window().maximize();
        verifyCookies();
    }

    @After
    public void closeWindow() {
        driver.quit();
    }

    public void verifyCookies() {
        if (this.homePage.getCookies().isDisplayed()) {
            this.homePage.acceptCokies();
        }
    }

}
