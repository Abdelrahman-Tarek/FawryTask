package POM;

import Actions.BrowserActions;
import Actions.WebUiActions;
import org.openqa.selenium.By;

public class ProductPage {
    WebUiActions webUiActions=new WebUiActions(BrowserActions.driver);
    public String pageTitle = BrowserActions.driver.getTitle();
    // selecting locators for page elements
    public By addToCartBTN = By.id("add-to-cart-button");
    public By cartCount = By.xpath("//span[@id=\"nav-cart-count\"]");

    public void addItemtoCart(){
        webUiActions.clickOn(addToCartBTN,true);
    }

    public int getCartCount(){
        return Integer.parseInt(webUiActions.getText(cartCount));
    }

    public String getPageTitle(){
        return pageTitle;
    }

}
