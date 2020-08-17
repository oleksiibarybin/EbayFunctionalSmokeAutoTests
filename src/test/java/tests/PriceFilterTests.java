package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PriceFilterTests extends BaseTest {

    private String SEARCH_KEYWORD = "samsung";
    private int TIME_TO_WAIT = 20;
    private String PRICE_ZERO_VALUE = "0";
    private String MIN_PRICE_VALID_VALUE = "1000";
    private String MAX_PRICE_VALID_VALUE = "2000";
    private String PRICE_INVALID_NEGATIVE_VALUE = "-1";
    private String PRICE_INVALID_CHARACTER_VALUE = "a";
    private String EXPECTED_PRICE_INVALID_VALUE_ERROR_MESSAGE = "Please provide a valid price range";
    private String EXPECTED_PRICE_ZERO_VALUE_NO_MATCHES_FOUND_MESSAGE = "No exact matches found";

    @Test
    public void checkPriceFilterFirstPageResultsMatchingValidPriceRange() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMinPriceFilterInputField(PRICE_ZERO_VALUE);
        getSearchResultsPage().enterValueToMaxPriceFilterInputField(PRICE_ZERO_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertEquals(getSearchResultsPage().getNoResultMatchesFoundText(), EXPECTED_PRICE_ZERO_VALUE_NO_MATCHES_FOUND_MESSAGE);
    }

    @Test(groups = "Negative")
    public void checkPriceFilterNoResultsFoundForZeroMinAndMaxPriceRange() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMinPriceFilterInputField(MIN_PRICE_VALID_VALUE);
        getSearchResultsPage().enterValueToMaxPriceFilterInputField(MAX_PRICE_VALID_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertTrue(getSearchResultsPage().isProductsPriceInPriceRange(MIN_PRICE_VALID_VALUE, MAX_PRICE_VALID_VALUE));
    }

    @Test(groups = "Negative")
    public void checkPriceFilterResponseForNegativeValueAsInvalidMinPrice() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMinPriceFilterInputField(PRICE_INVALID_NEGATIVE_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertEquals(getSearchResultsPage().getPriceInvalidValueErrorMessageText(), EXPECTED_PRICE_INVALID_VALUE_ERROR_MESSAGE);
    }

    @Test(groups = "Negative")
    public void checkPriceFilterResponseForNegativeValueAsInvalidMaxPrice() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMaxPriceFilterInputField(PRICE_INVALID_NEGATIVE_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertEquals(getSearchResultsPage().getPriceInvalidValueErrorMessageText(), EXPECTED_PRICE_INVALID_VALUE_ERROR_MESSAGE);
    }

    @Test(groups = "Negative")
    public void checkPriceFilterResponseForCharacterValueAsInvalidMinPrice() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMinPriceFilterInputField(PRICE_INVALID_CHARACTER_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertEquals(getSearchResultsPage().getPriceInvalidValueErrorMessageText(), EXPECTED_PRICE_INVALID_VALUE_ERROR_MESSAGE);
    }

    @Test(groups = "Negative")
    public void checkPriceFilterResponseForCharacterValueAsInvalidMaxPrice() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getFilterBlock());
        getSearchResultsPage().enterValueToMaxPriceFilterInputField(PRICE_INVALID_CHARACTER_VALUE);

        getSearchResultsPage().clickOnSubmitPriceRangeButton();

        assertEquals(getSearchResultsPage().getPriceInvalidValueErrorMessageText(), EXPECTED_PRICE_INVALID_VALUE_ERROR_MESSAGE);
    }
}
