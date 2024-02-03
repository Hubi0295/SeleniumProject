package pl.testhubert.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(id = "reg_email")
    private WebElement regEmailInput;
    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;
    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement loginButton;
    private WebDriver driver;
    @FindBy(xpath = "//div/ul[@class='woocommerce-error']")
    private WebElement error;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage loginUserValidData(String email, String password) {
        login(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInValidData(String email, String password) {
        login(email, password);
        return this;
    }

    private void login(String email, String password) {
        usernameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        register(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        register(email, password);
        return this;
    }

    private void register(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }
}
