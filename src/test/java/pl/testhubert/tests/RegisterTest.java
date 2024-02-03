package pl.testhubert.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testhubert.pages.HomePage;

import java.io.*;
import java.util.Random;

public class RegisterTest extends BaseTest{
    @Test
    public void registerUserTest() throws IOException {
        String randomNumber = getRandomNumber();
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("blabla"+randomNumber+"@gmail.com", "Admina"+randomNumber)
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(),"Dashboard");
    }
    @Test
    public void registerUserWithSameEmail(){
        WebElement errorRegister = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("blabla@gmail.com", "Admina123123@")
                .getError();
        Assert.assertEquals(errorRegister.getText(),"Error: An account is already registered with your email address. Please log in.");
    }
    public String getRandomNumber() throws IOException {
        Random random = new Random();
        String randomnum = Integer.toString(random.nextInt(1000,1000000));
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Daniel\\Desktop\\seleniumdemo\\src\\test\\java\\pl\\testhubert\\utils\\savedRandomNums.txt")));
        String linia = null;
        while((linia=reader.readLine())!=null){
            if(linia.equals(randomnum)){
                reader.close();
                return getRandomNumber();
            }
        }
        FileWriter writer = new FileWriter(new File("C:\\Users\\Daniel\\Desktop\\seleniumdemo\\src\\test\\java\\pl\\testhubert\\utils\\savedRandomNums.txt"),true);
        writer.append("\n"+randomnum);
        writer.close();
        return randomnum;
    }
}
