package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");


    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getPostalCode() {
        return getDriver().findElement(postalCode);
    }

    public WebElement getContinueBtn() {
        return getDriver().findElement(continueBtn);
    }

    public void popunjavanje () {
        getFirstName().sendKeys("gggg");
        getLastName().sendKeys("gggg");
        getPostalCode().sendKeys("gggg");
    }

    public void nextPage() {
        getContinueBtn().click();
    }
}