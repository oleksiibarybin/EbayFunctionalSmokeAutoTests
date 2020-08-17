package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = "//li[@class='hl-cat-nav__js-tab']/a[contains(text(),'Electronics')]")
    private WebElement topHorizontalMenuElectronicsLink;

    @FindBy(xpath = "//a[contains(text(),'Cell Phones')]/parent::li")
    private WebElement categoriesListCellPhonesPageLink;

    @FindBy(xpath = "//p[contains(text(),'Cell Phones & Smartphones')]//ancestor::a")
    private WebElement cellPhonesPageCategoriesListCellPhonesSmartphonesLink;

    @FindBy(xpath = "//p[contains(text(),'Samsung')]//ancestor::a")
    private WebElement cellPhonesSmartphonesPageCategoriesListSamsungLink;

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> vendorPageListOfProductsTitles;


    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTopHorizontalMenuElectronicsLink() {
        topHorizontalMenuElectronicsLink.click();
    }

    public void clickOnCategoriesListCellPhonesPageLink() {
        categoriesListCellPhonesPageLink.click();
    }

    public void clickOnCellPhonesPageCategoriesListCellPhonesSmartphonesLink() {
        cellPhonesPageCategoriesListCellPhonesSmartphonesLink.click();
    }

    public void clickOnCellPhonesSmartphonesPageCategoriesListSamsungLink() {
        cellPhonesSmartphonesPageCategoriesListSamsungLink.click();
    }

    public List<WebElement> getVendorPageListOfProductsTitles() {
        return vendorPageListOfProductsTitles;
    }

    public WebElement getCategoriesListCellPhonesPageLink() {
        return categoriesListCellPhonesPageLink;
    }

    public WebElement getCellPhonesPageCategoriesListCellPhonesSmartphonesLink() {
        return cellPhonesPageCategoriesListCellPhonesSmartphonesLink;
    }

    public WebElement getCellPhonesSmartphonesPageCategoriesListSamsungLink() {
        return cellPhonesSmartphonesPageCategoriesListSamsungLink;
    }

    public WebElement getTopHorizontalMenuElectronicsLink() {
        return topHorizontalMenuElectronicsLink;
    }
}
