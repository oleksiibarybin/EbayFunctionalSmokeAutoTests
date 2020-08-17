package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@id='CenterPanel']")
    private WebElement productCenterBlock;

    @FindBy(xpath = "//h1[@id='itemTitle']")
    private WebElement productTitle;

    @FindBy(xpath = "//select[@name='Color']")
    private WebElement productSelectColor;

    @FindBy(xpath = "//div[contains(text(),'Please select a Color')]")
    private WebElement selectColorErrorMessageText;

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getProductCenterBlock() {
        return productCenterBlock;
    }

    public WebElement getProductTitle() {
        return productTitle;
    }
}
