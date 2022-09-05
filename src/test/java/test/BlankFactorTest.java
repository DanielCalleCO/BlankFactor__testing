package test;

import org.junit.Assert;
import org.junit.Test;

public class BlankFactorTest extends BaseTest {

    @Test
    public void verifyBlog() {
        this.homePage.stepOverInsightDropdown();
        this.homePage.clickBlog();
        this.blogListPage.clickTrendingBlog();
        Assert.assertEquals("https://blankfactor.com/insights/blog/fintech-in-latin-america/", driver.getCurrentUrl());
        Assert.assertEquals("Why Fintech in Latin America Is Having a Boom", blogPage.getBlogTitle().getText());
    }

    @Test
    public void suscribeNewsletter() throws InterruptedException {
        this.homePage.stepOverInsightDropdown();
        this.homePage.clickBlog();
        this.blogListPage.fillNewsLetterEmail("danielcalleco@gmail.com");
        this.blogListPage.subscribeNewsLetter();
        Assert.assertTrue(blogListPage.subscribeConfirm().isDisplayed());
    }

}
