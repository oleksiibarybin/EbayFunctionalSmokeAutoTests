package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTests extends BaseTest{

    private static final String[] SEARCH_KEYWORDS = new String[] {"guitar", "viola"};
    private static final String[] EXPECTED_AMOUNT_OF_PRODUCT_IN_CART = new String[] {"1", "2"};
    private static final String EXPECTED_NONE_PRODUCTS_IN_CART_MESSAGE = "You don't have any items in your cart.";
    private static final String EXPECTED_FOLLOWING_REMOVED_PRODUCT_LINK_INFORMATIONAL_MESSAGE = "was removed from your cart.";
    private static final int TIME_TO_WAIT = 20;

    @Test
    public void checkRemoveOneOfOneProductFromCart() {
        getHomePage().searchByKeyword(SEARCH_KEYWORDS[0]);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getSearchResultsPage().clickOnSearchResultsFirstProductTitle();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getProductPage().getAddToCartButton());
        getProductPage().clickOnAddToCartButton();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertEquals(getCartPage().getAmountOfItemsInCartOnCartPage(), EXPECTED_AMOUNT_OF_PRODUCT_IN_CART[0]);
        String firstProductInCartTitle = getCartPage().getFirstProductTitleText();
        getCartPage().clickOnFirstProductInCartRemoveButton();

        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getCartPage().getNoneProductsInCartInformationalMessage());
        assertEquals(getCartPage().getNoneProductsInCartInformationalMessageText(), EXPECTED_NONE_PRODUCTS_IN_CART_MESSAGE);
        assertEquals(getCartPage().getRemovedProductConfirmationLinkText(), firstProductInCartTitle);
        assertEquals(getCartPage().getFollowingRemovedProductConfirmationLinkInformationalMessageText(), EXPECTED_FOLLOWING_REMOVED_PRODUCT_LINK_INFORMATIONAL_MESSAGE);
    }

    @Test
    public void checkRemoveAllOfTwoProductsFromCart() {
        int numberOfItems = 2;
        String[] firstProductInCartTitles = new String[numberOfItems];

        for(int i=0; i < numberOfItems; i++) {
            getHomePage().searchByKeyword(SEARCH_KEYWORDS[i]);

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            getSearchResultsPage().clickOnSearchResultsFirstProductTitle();

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getProductPage().getAddToCartButton());
            getProductPage().clickOnAddToCartButton();

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            assertEquals(getCartPage().getAmountOfItemsInCartOnCartPage(), EXPECTED_AMOUNT_OF_PRODUCT_IN_CART[i]);

            firstProductInCartTitles[i] = getCartPage().getFirstProductTitleText();
        }

        for(int i = numberOfItems - 1; i >= 0; i--) {
            getBasePage().refreshPage();
            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            getCartPage().clickOnFirstProductInCartRemoveButton();
            getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getCartPage().getRemovedProductConfirmationLink());
            assertEquals(getCartPage().getRemovedProductConfirmationLinkText(), firstProductInCartTitles[i]);
            assertEquals(getCartPage().getFollowingRemovedProductConfirmationLinkInformationalMessageText(), EXPECTED_FOLLOWING_REMOVED_PRODUCT_LINK_INFORMATIONAL_MESSAGE);
        }
    }

    @Test
    public void checkTotalPriceForTwoProductsInCart() {
        int numberOfItems = 2;

        for(int i=0; i < numberOfItems; i++) {
            getHomePage().searchByKeyword(SEARCH_KEYWORDS[i]);

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            getSearchResultsPage().clickOnSearchResultsFirstProductTitle();

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getProductPage().getAddToCartButton());
            getProductPage().clickOnAddToCartButton();

            getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
            assertEquals(getCartPage().getAmountOfItemsInCartOnCartPage(), EXPECTED_AMOUNT_OF_PRODUCT_IN_CART[i]);
        }
        assertTrue(getCartPage().isSumOfProductsEqualToTotalPrice());
    }
}
