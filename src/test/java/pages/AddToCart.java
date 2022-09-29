package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart extends BasePage{
    private By addProduct = By.id("add-to-cart-sauce-labs-backpack");
    private By cartLink=By.xpath("//*[@id=\"shopping_cart_container\"]/a");


    public AddToCart(WebDriver driver) {
        super(driver);
    }

    public void add () {
        WebElement button=getDriver().findElement(addProduct);
        button.click();
    }

    public void clickCart() {
        WebElement cartIcon=getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        cartIcon.click();
    }
}
