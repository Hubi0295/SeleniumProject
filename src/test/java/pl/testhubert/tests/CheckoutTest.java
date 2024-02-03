package pl.testhubert.tests;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testhubert.models.Customer;
import pl.testhubert.pages.HomePage;

import java.io.*;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutTest() throws IOException {
        Customer customer = new Customer("hubert", "szelepusta", "hubert.szelepusta@gmail.com", "123321222", "Bakery street", "221B", "E1 8RU", "London", "United Kingdom (UK)");
        new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCard()
                .viewCart()
                .proceedCheckout()
                .fillAFormAddress(customer, "random com");
        Assert.assertEquals(driver.findElement(By.cssSelector("p[class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")).getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='woocommerce-table__product-name product-name'] a")).getText(), "Java Selenium WebDriver");

    }
}
