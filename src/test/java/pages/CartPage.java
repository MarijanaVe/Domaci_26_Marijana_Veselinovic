package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        WebElement checkoutBtn = getDriver().findElement(By.id("checkout"));
        checkoutBtn.click();
    }
}
