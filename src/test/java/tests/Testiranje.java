package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class Testiranje {

    private LoginPage loginPage;
    private AddToCart addToCart;
    private Checkout checkout;
    private ConfirmPage confirmPage;
    private LogoutPage logoutPage;
    private CartPage cartPage;
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tilma\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        addToCart = new AddToCart(driver);
        cartPage = new CartPage(driver);
        checkout = new Checkout(driver);
        confirmPage = new ConfirmPage(driver);
        logoutPage= new LogoutPage(driver);
    }

    @Test
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "Swag Labs";
        String actualResult = loginPage.getDriver().getTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test(dependsOnMethods = "login")
    public void dodavanjeProizvoda ()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        addToCart.add();
        addToCart.clickCart();
    }

    @Test(dependsOnMethods = "dodavanjeProizvoda")
    public void checkOut()  {
        cartPage.checkout();
        Assert.assertTrue(driver.getPageSource().contains("Checkout: Your Information"));
    }

    @Test(dependsOnMethods = "checkOut")
    public void konfirmacija() {
        confirmPage.popunjavanje();
        confirmPage.nextPage();
        Assert.assertTrue(driver.getPageSource().contains("Checkout: Overview"));
        Assert.assertTrue(driver.getPageSource().contains("QTY"));
        Assert.assertTrue(driver.getPageSource().contains("DESCRIPTION"));
    }

    @Test(dependsOnMethods = "konfirmacija")
    public void checkout() {
        Assert.assertEquals(checkout.getTotal(), "Total: $32.39");
        checkout.finish();
        Assert.assertTrue(driver.getPageSource().contains("THANK YOU FOR YOUR ORDER"));
    }

    @Test(dependsOnMethods = "checkout")
    public void logout()  {
        logoutPage.logout();
        Assert.assertTrue(driver.getPageSource().contains("Swag Labs"));
        Assert.assertTrue(driver.getPageSource().contains("Login"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}