package app.e_commerce.kib.testcases;

import app.e_commerce.kib.base.BaseTest;
import app.e_commerce.kib.pages.P01_HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_SearchForSpecificProduct extends BaseTest {

    @Test
    public void Search_product() throws InterruptedException {

        String productName = "Apple iphone 15--- edited";

        P01_HomePage HomePage = new P01_HomePage(driver);
        boolean isSearchResultValid =HomePage.enterSearchQuery(productName)
                                             .verifySingleSearchResult(productName);

        Assert.assertTrue(isSearchResultValid, "Test Failed: Search results do not contain the exact product.");
        System.out.println("Test Passed: Search results contain only the exact product.");
    }

}
