package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(@class,'s-item__title')]")
    private List<WebElement> searchResultsProductsTitle;

    @FindBy(xpath = "//h3[contains(@class,'s-item__title')]")
    private WebElement searchResultsFirstProductTitle;

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> searchResultsProductsPrice;

    @FindBy(xpath = "//div[(@class='srp-rail__left')]")
    private WebElement filterBlock;

    @FindBy(xpath = "//input[contains(@class,'x-textrange__input--from')]")
    private WebElement priceFilterMinValueInput;

    @FindBy(xpath = "//input[contains(@class,'x-textrange__input--to')]")
    private WebElement priceFilterMaxValueInput;

    @FindBy(xpath = "//div[contains(@data-marko-key,'@errorMsgAlert')]/div")
    private WebElement priceInvalidValueErrorMessageText;

    @FindBy(xpath = "//button[@title='Submit price range']")
    private WebElement submitPriceRangeButton;

    @FindBy(xpath = "//h3[@class='srp-save-null-search__heading']")
    private WebElement noResultMatchesFoundText;

    @FindBy(xpath = "//p[@class='page-notice__cell']")
    private WebElement invalidSearchKeywordErrorMessage;

    @FindBy(xpath = "//ul[contains(@class,'srp-results')]/*[contains(@data-view,'')]")
    private List<WebElement> searchResultsListElements;

    @FindBy(xpath = "//h1[@class='srp-controls__count-heading']/span")
    private WebElement numberOfResultsFoundInCounter;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void enterValueToMinPriceFilterInputField(String price) {
        priceFilterMinValueInput.clear();
        priceFilterMinValueInput.sendKeys(price);
    }

    public void enterValueToMaxPriceFilterInputField(String price) {
        priceFilterMaxValueInput.clear();
        priceFilterMaxValueInput.sendKeys(price);
    }

    public void clickOnSubmitPriceRangeButton() {
        submitPriceRangeButton.click();
    }

    public void clickOnSearchResultsFirstProductTitle() {
        searchResultsFirstProductTitle.click();
    }

    public boolean isNumberOfDirectResultsMatchNumberOfResultsFoundInCounter() {
        boolean result = false;
        int numberOfDirectResultsInList = getNumberOfDirectResultsElementsFromSearchResultsList();

        if (Integer.parseInt(numberOfResultsFoundInCounter.getText()) == numberOfDirectResultsInList)
            result = true;

        return result;
    }

    public boolean isProductsPriceInPriceRange (String  minPrice, String  maxPrice) {
        List<WebElement> elementList = getSearchResultsProductsPrice();
        float minPriceNumber = Float.parseFloat(minPrice);
        float maxPriceNumber = Float.parseFloat(maxPrice);
        boolean result = true;

        for (WebElement webElement : elementList) {
            if (webElement.getText().replaceAll("[^to]", "") == "") {
                float productPrice = Float.parseFloat(webElement.getText().replaceAll("[^0-9.]", ""));
                boolean isCurrentProductPriceInRange = productPrice <= maxPriceNumber && productPrice >= minPriceNumber;
                if (!isCurrentProductPriceInRange)
                    result = false;
            }
        }
        return result;
    }

    public int getNumberOfDirectResultsElementsFromSearchResultsList() {
        List<WebElement> elementList = getSearchResultsListElements();
        int index = 0;
        String expectedTagName = "div";

        for (WebElement webElement : elementList) {
            if (webElement.getTagName().equals(expectedTagName)) {
                System.out.println("ENTER");
                return index;
            }
            index++;
        }
        return index;
    }

    public List<WebElement> getSearchResultsListElements() {
        return searchResultsListElements;
    }

    public List<WebElement> getSearchResultsProductsPrice() {
        return searchResultsProductsPrice;
    }

    public String getPriceInvalidValueErrorMessageText() {
        return priceInvalidValueErrorMessageText.getText();
    }

    public String getNoResultMatchesFoundText() {
        return noResultMatchesFoundText.getText();
    }

    public String getInvalidSearchKeywordErrorMessageText() {
        return invalidSearchKeywordErrorMessage.getText();
    }

    public List<WebElement> getSearchResultsProductTitles() {
        return searchResultsProductsTitle;
    }

    public WebElement getInvalidSearchKeywordErrorMessage() {
        return invalidSearchKeywordErrorMessage;
    }

    public WebElement getFilterBlock() {
        return filterBlock;
    }

    public WebElement getSubmitPriceRangeButton() {
        return submitPriceRangeButton;
    }
}
