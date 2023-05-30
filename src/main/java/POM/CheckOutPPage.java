package POM;

import Actions.BrowserActions;
import Actions.WebUiActions;
import org.openqa.selenium.By;

public class CheckOutPPage {
    WebUiActions webUiActions = new WebUiActions(BrowserActions.driver);
    private By fullname = By.id("address-ui-widgets-enterAddressFullName");
    private By phone = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By street = By.id("address-ui-widgets-enterAddressLine1");
    private By buildingNo = By.id("address-ui-widgets-enter-building-name-or-number");
    private By city = By.id("address-ui-widgets-enterAddressCity");
    private By district = By.id("address-ui-widgets-enterAddressDistrictOrCounty");

    private By addAddressBTN = By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input");

    public  By cash = By.id("pp-BZtMo9-72");

    public void addAddress(String yourfullname,String yourphone,String yourstreet,String yourbuildNo,String yourcity,String yourdis){
        webUiActions.setText(fullname,yourfullname,true);
        webUiActions.setText(phone,yourphone,true);
        webUiActions.setText(street,yourstreet,true);
        webUiActions.setText(buildingNo,yourbuildNo,true);
        webUiActions.setText(city,yourcity,true);
        webUiActions.setText(district,yourdis,true);
        webUiActions.clickOn(addAddressBTN,true);
    }



}
