package POM;

import Actions.BrowserActions;
import Actions.WebUiActions;
import org.openqa.selenium.By;

public class CartPage {
    WebUiActions webUiActions = new WebUiActions(BrowserActions.driver);
    public By cartNumber= By.xpath("//span[@id='nav-cart-count']");
    public By proceedToBuy = By.name("proceedToRetailCheckout");

    public int getcartNumber(){
        int num = Integer.parseInt(BrowserActions.driver.findElement(cartNumber).getText());
        return num;
    }
    public void clickOnBuyBTN(){
        webUiActions.clickOn(proceedToBuy,true);
    }
}
