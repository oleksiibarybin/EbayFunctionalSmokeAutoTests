package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTest {

    private static final String SEARCH_KEYWORD = "guitar";
    private static final String EXPECTED_AMOUNT_ONE_PRODUCT_IN_CART = "1";
    private static final int TIME_TO_WAIT = 20;

    @Test
    public void checkAddingOneProductFromSearchResultsListToCart() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getSearchResultsPage().clickOnSearchResultsFirstProductTitle();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        String productPageProductTitle = getProductPage().getProductTitleText();
        getProductPage().clickOnAddToCartButton();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertEquals(getCartPage().getFirstProductTitleText(), productPageProductTitle);
        assertEquals(getCartPage().getAmountOfItemsInCartOnCartPage(), EXPECTED_AMOUNT_ONE_PRODUCT_IN_CART);
    }
}
