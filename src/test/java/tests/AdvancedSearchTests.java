package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginAndRegistrationPage;
import pages.SearchResultsPage;

public class AdvancedSearchTests {
    final static String email = "mc_valkir@mail.ru";
    final static String password = "tiramisu";
    final static String searchTerm = "HR";

    @Test
    public void advancedSearchPositiveTest () {
        LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage();
        Assert.assertNotNull(loginAndRegistrationPage, "Login page is not loaded.");
        HomePage homePage = loginAndRegistrationPage.login(email, password);
        Assert.assertNotNull(homePage, "Home page is not loaded.");
        SearchResultsPage searchResultsPage = homePage.clickAdvancedSearchLink();
        searchResultsPage.performSearch(searchTerm);
        //Assert that 10 items returned in results list
        //Assert that each item from results list contains searchTerm


        searchResultsPage.printEachTitleText();


    }

}
