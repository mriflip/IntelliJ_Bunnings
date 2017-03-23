package bunnings.pages;

import bunnings.configuration.Configuration;
import bunnings.core.PageObject;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by mrinalirao on 18/03/17.
 */
public class SignUp extends PageObject{

    public SignUp(){
        super(conf);
    }

    By firstName = By.id("body_1_UserDetailsCtrl_firstname");
    By lastName = By.id("body_1_UserDetailsCtrl_lastname");
    By postCode = By.id("body_1_UserDetailsCtrl_postcode");
    By email = By.id("body_1_UserDetailsCtrl_email");
    By password = By.id("body_1_PasswordCtrl_password");
    By confirmPassword = By.id("body_1_PasswordCtrl_confirmpassword");
    By agreeCheckBox = By.id("body_1_tnc");
    By signUpButton = By.id("body_1_RegisterButton");
    By profileText = By.xpath(".//*[@id='form1']/header/section[1]/div/div/div/div[1]/div/a[2]");
    String emailvalue = Configuration.firstName+ String.valueOf(System.currentTimeMillis())+"@gmail.com";


    public void register(){

        driver.findElement(firstName).sendKeys(Configuration.firstName);
        driver.findElement(lastName).sendKeys(Configuration.lastName);
        driver.findElement(postCode).sendKeys(Configuration.postCode);
        driver.findElement(email).sendKeys(emailvalue);
        driver.findElement(password).sendKeys(Configuration.password);
        driver.findElement(confirmPassword).sendKeys(Configuration.password);
        driver.findElement(agreeCheckBox).click();
        driver.findElement(signUpButton).click();

        Assert.assertEquals(driver.findElement(profileText).getText(), Configuration.firstName + "'s Profile");

    }


}
