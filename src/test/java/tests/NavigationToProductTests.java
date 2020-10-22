package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationToProductTests extends BaseTest{

    private static final String VENDOR_NAME_SAMSUNG = "samsung";
    private static final int TIME_TO_WAIT = 10;


    @Test
    public void checkNavigationToSamsungCellPhonesProductsListShowsProductsWithTitlesContainSamsung() {
        getElectronicsPage().clickOnTopHorizontalMenuElectronicsLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getElectronicsPage().getCategoriesListCellPhonesPageLink());
        getElectronicsPage().clickOnCategoriesListCellPhonesPageLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getElectronicsPage().getCellPhonesPageCategoriesListCellPhonesSmartphonesLink());
        getElectronicsPage().clickOnCellPhonesPageCategoriesListCellPhonesSmartphonesLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT,getElectronicsPage().getCellPhonesSmartphonesPageCategoriesListSamsungLink());
        getElectronicsPage().clickOnCellPhonesSmartphonesPageCategoriesListSamsungLink();

        for (WebElement webElement : getElectronicsPage().getVendorPageListOfProductsTitles()) {
            assertTrue(webElement.getText().contains(VENDOR_NAME_SAMSUNG));
        }
    }

    @Test
    public void checkNavigationToSamsungCellPhonesProductsListGoesToPageLinkContainsSamsung() {
        getElectronicsPage().clickOnTopHorizontalMenuElectronicsLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getElectronicsPage().getCategoriesListCellPhonesPageLink());
        getElectronicsPage().clickOnCategoriesListCellPhonesPageLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT, getElectronicsPage().getCellPhonesPageCategoriesListCellPhonesSmartphonesLink());
        getElectronicsPage().clickOnCellPhonesPageCategoriesListCellPhonesSmartphonesLink();

        getBasePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getBasePage().waitVisibilityOfElement(TIME_TO_WAIT,getElectronicsPage().getCellPhonesSmartphonesPageCategoriesListSamsungLink());
        getElectronicsPage().clickOnCellPhonesSmartphonesPageCategoriesListSamsungLink();

        String currentUrlLowerCase = (getBasePage().getUrl()).toLowerCase();
        assertTrue(currentUrlLowerCase.contains(VENDOR_NAME_SAMSUNG));
    }
}
