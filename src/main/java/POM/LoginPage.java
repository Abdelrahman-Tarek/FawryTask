package POM;

import Actions.BrowserActions;
import org.openqa.selenium.By;

public class LoginPage {

//"https://www.amazon.eg/-/en/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.eg%2Fs%3Fk%3D%25D8%25A7%25D9%2585%25D8%25A7%25D8%25B2%25D9%2588%25D9%2586%2B%25D9%2585%25D8%25B5%25D8%25B1%26language%3Den_AE%26adgrpid%3D129661811918%26hvadid%3D555019635342%26hvdev%3Dc%26hvlocphy%3D9112371%26hvnetw%3Dg%26hvqmt%3Db%26hvrand%3D13032375463668646623%26hvtargid%3Dkwd-301265861497%26hydadcr%3D29073_2316715%26tag%3Degtxtgostdde-21%26ref%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=egflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&"

    // selecting my locator first
    private By email_TextFeild = By.xpath("//*[@id=\"ap_email\"]");

    private By continueBTN=By.className("a-button-input");
    private By password_TextFeild = By.id("ap_password");
    private By signInBTN = By.id("signInSubmit");

    public void navigatetoLogin(){
//        BrowserActions.driver.navigate().to("https://www.amazon.eg/-/en/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.eg%2Fs%3Fk%3D%25D8%25A7%25D9%2585%25D8%25A7%25D8%25B2%25D9%2588%25D9%2586%2B%25D9%2585%25D8%25B5%25D8%25B1%26language%3Den_AE%26adgrpid%3D129661811918%26hvadid%3D555019635342%26hvdev%3Dc%26hvlocphy%3D9112371%26hvnetw%3Dg%26hvqmt%3Db%26hvrand%3D13032375463668646623%26hvtargid%3Dkwd-301265861497%26hydadcr%3D29073_2316715%26tag%3Degtxtgostdde-21%26ref%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=egflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
    BrowserActions.driver.get("");

    //*[@id="nav-signin-tooltip"]/a/span
    }
    public void setEmail (String email) {
//        "testa2979@gmail.com"
        BrowserActions.driver.findElement(email_TextFeild).sendKeys(email);
    }

    public void clickOn_continueBTN(){
        BrowserActions.driver.findElement(continueBTN).click();
    }
    public void setPassword (String password) {
//        0123456789
        BrowserActions.driver.findElement(password_TextFeild).sendKeys(password);
    }
    public void clickOn_signInBTN(){
        BrowserActions.driver.findElement(signInBTN).click();
    }

}
