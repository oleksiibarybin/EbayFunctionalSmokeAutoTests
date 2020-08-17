package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "samsung";
    private String SEARCH_PHRASE = "acer aspire 7 a715-75g";
    private String SEARCH_NO_RESULTS_PHRASE = "dlkfjdslfkjsdldskj";
    private String EXPECTED_SEARCH_NO_RESULTS_FOUND_MESSAGE = "No exact matches found";
    private String SEARCH_KEYWORD_INVALID = "-1";
    private String EXPECTED_SEARCH_INVALID_KEYWORD_ERROR_MESSAGE = "Let's try that again. This time add more details so we can search for better matches.";
    private int TIME_TO_WAIT = 30;

    @Test
    public void checkAmountOfDirectResultsInSearchList() {
        getHomePage().searchByKeyword(SEARCH_PHRASE);
        assertTrue(getSearchResultsPage().isNumberOfDirectResultsMatchNumberOfResultsFoundInCounter());
    }

    @Test
    public void checkProductsTitleContainsSearchKeyword() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        for (WebElement webElement : getSearchResultsPage().getSearchResultsProductTitles()) {
            String elementTitleTextLowerCase = (webElement.getText()).toLowerCase();
            assertTrue(elementTitleTextLowerCase.contains(SEARCH_KEYWORD));
        }
    }

    @Test(groups = "Negative")
    public void checkMessageTextIfNoneResultsFound() {
        getHomePage().searchByKeyword(SEARCH_NO_RESULTS_PHRASE);
        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertEquals(getSearchResultsPage().getNoResultMatchesFoundText(), EXPECTED_SEARCH_NO_RESULTS_FOUND_MESSAGE);
    }

    @Test(groups = "Negative")
    public void checkErrorMessageTextForInvalidSearchKeyword() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD_INVALID);
        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getSearchResultsPage().getInvalidSearchKeywordErrorMessage());
        assertEquals(getSearchResultsPage().getInvalidSearchKeywordErrorMessageText(), EXPECTED_SEARCH_INVALID_KEYWORD_ERROR_MESSAGE);
    }
}
