package app.e_commerce.kib.testcases;

import app.e_commerce.kib.base.BaseTest;
import app.e_commerce.kib.pages.P01_HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TC05_SearchForMultipleProducts extends BaseTest {

    @Test
    public void Search_with_keyword() throws InterruptedException {

        String keyword = "iphone";

        P01_HomePage HomePage = new P01_HomePage(driver);
        List<WebElement> searchResults =HomePage.enterSearchQuery(keyword)
                                                .getSearchResults();

        Assert.assertTrue(searchResults.size() > 1, "Test Failed: Expected multiple results but found " + searchResults.size());

        boolean allResultsValid = HomePage.verifyResultsContainKeyword(keyword);
        Assert.assertTrue(allResultsValid, "Test Failed: Some search results do not match the keyword.");

        System.out.println("Test Passed: All search results contain the keyword.");
    }


    }
