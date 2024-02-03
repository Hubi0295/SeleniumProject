package pl.testhubert.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[@class='button wc-forward']")
    private WebElement viewCart;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCard() {
        addToCardButton.click();
        return this;
    }

    public CartPage viewCart() {
        viewCart.click();
        return new CartPage(driver);
    }
}
