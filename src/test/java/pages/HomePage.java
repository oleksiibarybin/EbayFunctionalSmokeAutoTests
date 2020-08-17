package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']")
    private WebElement cartOpenButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword, Keys.ENTER);
    }
}
