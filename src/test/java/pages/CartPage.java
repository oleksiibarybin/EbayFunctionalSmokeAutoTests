package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement cartMainTitle;

    @FindBy(xpath = "//a[@data-test-id='cart-item-link']")
    private WebElement productsTitleLink;

    @FindBy(xpath = "//a[@data-test-id='cart-item-link']/span")
    private WebElement firstProductTitleText;

    @FindBy(xpath = "//div[@class='item-price']//span[contains(text(),'US')]")
    private List<WebElement> productsPricesInUsDollars;

    @FindBy(xpath = "//div[@class='val-col total-row']//span[contains(text(),'US')]")
    private WebElement totalPricesInUsDollars;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement topProductInCartRemoveButton;

    @FindBy(xpath = "//div[contains(@class,'page-alert--confirmation')]//a")
    private WebElement removedProductConfirmationLink;

    @FindBy(xpath = "//span[contains(text(),'removed')]")
    private WebElement followingRemovedProductConfirmationLinkInformationalMessage;

    @FindBy(xpath = "//span[contains(text(),'any items')]")
    private WebElement noneProductsInCartInformationalMessage;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProductInCartRemoveButton() {
        topProductInCartRemoveButton.click();
    }

    public boolean isSumOfProductsEqualToTotalPrice() {
        List<WebElement> elementList = getProductsPricesInUsDollars();
        float totalPrice = Float.parseFloat(totalPricesInUsDollars.getText().replaceAll("[^0-9.]", ""));
        float sum = 0;
        boolean result = false;

        for (WebElement webElement : elementList) {
            sum += Float.parseFloat(webElement.getText().replaceAll("[^0-9.]", ""));
        }
        if (sum == totalPrice)
            result = true;

        return result;
    }

    public List<WebElement> getProductsPricesInUsDollars() {
        return productsPricesInUsDollars;
    }

    public WebElement getNoneProductsInCartInformationalMessage() {
        return noneProductsInCartInformationalMessage;
    }

    public WebElement getRemovedProductConfirmationLink() {
        return removedProductConfirmationLink;
    }

    public String getFirstProductTitleText() {
        return firstProductTitleText.getText();
    }

    public String getNoneProductsInCartInformationalMessageText() {
        return noneProductsInCartInformationalMessage.getText();
    }

    public String getRemovedProductConfirmationLinkText() {
        return removedProductConfirmationLink.getText();
    }

    public String getFollowingRemovedProductConfirmationLinkInformationalMessageText() {
        return followingRemovedProductConfirmationLinkInformationalMessage.getText();
    }

    public String getAmountOfItemsInCartOnCartPage() {
        return cartMainTitle.getText().replaceAll("[^0-9]", "");
    }

    public WebElement getFirstProductTitleLink() {
        return productsTitleLink;
    }

    public WebElement getCartMainTitle() {
        return cartMainTitle;
    }
}
