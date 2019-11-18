package Flow;

import Pages.GoogleHomePage;
import Pages.SeleniumPage;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleFlow {


    public GoogleHomePage googleHomePage = new GoogleHomePage();

    public SeleniumPage seleniumPage = new SeleniumPage();

    public void navigateToGoogleHomePage() {
        googleHomePage.navigate();
    }

    public void inputSearchContent(String text) {
        this.googleHomePage.inputSearchContent(text);
    }

    public void pressEnterToSearch() {
        this.googleHomePage.pressEnterToSearch();
    }

    public void validateSearchResult(String text)
    {
        Assert.assertTrue(this.googleHomePage.getFirstResultText().contains(text));
    }

    public void clickFirstSearchResult()
    {
        googleHomePage.clickFirstResult();
    }

    public void validateNavigatedLink(String page_title) {
        Assert.assertEquals(page_title,seleniumPage.getPageLink());
    }
}
