package pl.testhubert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testhubert.models.Customer;

public class AddressDetailsPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement houseNumAndStreetNameInput;
    @FindBy(xpath = "//input[@id='billing_address_2']")
    private WebElement apartamentSuiteUnitEtcInput;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement postcodeZipInput;
    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement cityInput;
    @FindBy(xpath = "//input[@id='billing_phone']")
    private WebElement phoneInput;
    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement emailInput;
    @FindBy(css = "textarea")
    private WebElement textAreaInput;
    @FindBy(css = "button[id='place_order']")
    private WebElement submitButton;
    private WebElement countrySelect;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAFormAddress(Customer customer, String note) {
        SelectACountry(customer.getCountry());
        this.firstNameInput.sendKeys(customer.getFirstname());
        this.lastNameInput.sendKeys(customer.getLastname());
        this.houseNumAndStreetNameInput.sendKeys(customer.getStreet() + customer.getCity());
        this.apartamentSuiteUnitEtcInput.sendKeys(customer.getStreet());
        this.postcodeZipInput.sendKeys(customer.getPostcode());
        this.cityInput.sendKeys(customer.getCity());
        this.phoneInput.sendKeys(customer.getPhone());
        this.emailInput.sendKeys(customer.getEmail());
        this.textAreaInput.sendKeys(note);
        submitButton.click();
        return new OrderDetailsPage(driver);
    }

    private void SelectACountry(String country) {
        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
        countrySelect = driver.findElement(By.xpath("//li[text()='" + country + "']"));
        countrySelect.click();
    }
}
