package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends BasePage {

    private By total = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By finish = By.id("finish");


    public Checkout(WebDriver driver) {
        super(driver);
    }

    public void finish() {
        getDriver().findElement(finish).click();
    }

    public String getTotal() {
        return getDriver().findElement(total).getText();
    }
}
