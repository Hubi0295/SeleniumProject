package pl.testhubert.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testhubert.pages.HomePage;

public class LoginTest extends BaseTest {
    @Test
    public void LoginUserCorrectTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .loginUserValidData("abc1234@gmail.com", "admin123123@")
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void LoginUserWrongTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginUserInValidData("abc1234@gmail.com", "admin123123aa@")
                .getError();
        Assert.assertTrue(error.getText().contains("Incorrect username or password"));
    }
}
