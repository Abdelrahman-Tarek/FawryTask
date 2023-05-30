package POM;

import Actions.BrowserActions;
import Actions.WebUiActions;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

//    WebUiActions webUiActions = new WebUiActions(BrowserActions.driver);
    private String amazonURL= "https://www.amazon.eg/";
    public By signinBTN =By.xpath("//*[@id='nav-signin-tooltip']/a/span");
    public By all_Locator= By.id("nav-hamburger-menu");
//    public By seeall_locator =By.xpath("//*[@id='hmenu-content']//li[11]//a[@class='hmenu-compressed-btn']");
    public By seeall_locator =By.partialLinkText("See All");
    public By videogames = By.linkText("Video Games");
    public By allvideogames = By.linkText("All Video Games");

//    public By selectNew = By.xpath("//span[contains(text(),'New')]//ancestor::li[@class='a-spacing-micro']//input[@type='checkbox']");
    public By freeShipping = By.partialLinkText("Free Shipping");
//    public By selectNew =

    public By sortingDropDown = By.xpath("//span[@id='a-autoid-0-announce']");
    public By filterDDlist = By.id("a-autoid-0-announce");

    public By pricesLocator= By.className("a-price-whole");

    public By cartIcon=By.id("nav-cart");


    public void clickOnAll(){
        BrowserActions.driver.findElement(all_Locator).click();
    }

    public void clickOnSeeAll(){
        BrowserActions.driver.findElement(seeall_locator).click();
    }
    public void clicOnVideoGames(){
        BrowserActions.driver.findElement(videogames).click();
        BrowserActions.driver.findElement(allvideogames).click();
    }
    public void filterWithNew(){
        BrowserActions.driver.findElement(freeShipping).click();
    }

    public void selectFromDropDown(String option){
        BrowserActions.driver.findElement(filterDDlist).click();
//        webUiActions.clickOn(filterDDlist,true);
        BrowserActions.driver.findElement( By.partialLinkText(option)).click();
//        Select dropdownElem= new Select(BrowserActions.driver.findElement(sortingDropDown));
////        "Price: High to Low"
//        dropdownElem.selectByVisibleText(option);
    }
    public List<WebElement> selectedItems;
    public void showListofItemsPrice(){
        List<WebElement> allitems;
        selectedItems=new ArrayList<WebElement>();
        allitems = BrowserActions.driver.findElements(pricesLocator);
        ArrayList<Integer> myItems = new ArrayList<Integer>();
        for (int i=0;i<allitems.size();i++){
        String productPrice = allitems.get(i).getText().toString();
        productPrice = productPrice.replaceAll("[^\\d.]","");
            if (Integer.parseInt(productPrice) < 15000 && productPrice!=""){
                selectedItems.add(allitems.get(i));
                myItems.add(Integer.parseInt(productPrice));
        }}
        for(int i=0 ; i < myItems.size();i++){
            System.out.println("only items price < 15000 = "+myItems.get(i));
        }
        for(int i=0 ; i < myItems.size();i++){
            System.out.println("selected item = "+selectedItems.get(i).getText());
        }
    }

}
