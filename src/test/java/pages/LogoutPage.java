package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends BasePage {
    private By confirmMsg = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private By menu = By.id("react-burger-menu-btn");


    public LogoutPage(WebDriver driver) {
        super(driver);

    }

    public By getConfirmMessage() {
        return confirmMsg;
    }

    public By getMenuButton() {
        return menu;
    }

    public void logout() {
        WebElement menu = getDriver().findElement(By.id("react-burger-menu-btn"));
        menu.click();
        WebElement logoutButton = getDriver().findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }
}