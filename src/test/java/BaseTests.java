import Actions.BrowserActions;
import Actions.WebUiActions;
import POM.CheckOutPPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTests {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ProductPage productPage ;
    CheckOutPPage checkOutPPage;

    BrowserActions browserActions ;
    WebUiActions webUiActions;
    public BaseTests(){
        homePage =new HomePage();
//        productPage = new ProductPage();
        browserActions = new BrowserActions();
        driver = browserActions.initializeTheWebDriver();
        browserActions.maximizeScreen();
        webUiActions =new WebUiActions(browserActions.driver);
    }

    @BeforeTest
    void validateHomepage(){
        BrowserActions.driver.get("https://www.amazon.eg/");
        browserActions.maximizeScreen();
//        BrowserActions.driver.get("https://www.amazon.eg/s?k=%D8%A7%D9%85%D8%A7%D8%B2%D9%88%D9%86+%D9%85%D8%B5%D8%B1&language=en_AE&adgrpid=129661811918&hvadid=555019635342&hvdev=c&hvlocphy=9112371&hvnetw=g&hvqmt=b&hvrand=13032375463668646623&hvtargid=kwd-301265861497&hydadcr=29073_2316715&tag=egtxtgostdde-21&ref=nav_custrec_signin");
//        Assert.assertEquals(BrowserActions.driver.getTitle(),"امازون مصر : Amazon.eg");
    }
    @Test
    void sucesslogin(){
        webUiActions.clickOn(homePage.signinBTN,true);
        loginPage.setEmail("testa2979@gmail.com");
        loginPage.clickOn_continueBTN();
        loginPage.setPassword("0123456789");
        loginPage.clickOn_signInBTN();
        Assert.assertTrue(driver.findElement(By.id("nav-hamburger-menu")).isDisplayed());
        System.out.println(driver.getCurrentUrl().toString());

//        webUiActions.clickOn(home.all_Locator,true);
//        webUiActions.clickOn(home.seeall_locator,true);
//        webUiActions.clickOn(home.videogames,true);
//        webUiActions.clickOn(home.allvideogames,true);
//        webUiActions.clickOn(home.all_Locator,true);

//        home.clickOnAll();
//        home.clickOnSeeAll();
//        home.clicOnVideoGames();
//        home.filterWithNew();
//        home.selectFromDropDown("Price: High to Low");
    }

    @Test(dependsOnMethods = "sucesslogin")
    public void filterResults(){
        webUiActions.clickOn(homePage.all_Locator,true);
        webUiActions.clickOn(homePage.seeall_locator,true);
        webUiActions.clickOn(homePage.videogames,true);
        webUiActions.clickOn(homePage.allvideogames,true);
        homePage.filterWithNew();
        homePage.selectFromDropDown("High to Low");
    }

    int totalprice = 0;
    @Test(priority = 1, dependsOnMethods = "sucesslogin")
    public void addItemsToCart(){
        homePage.showListofItemsPrice();
        productPage = new ProductPage();
        int count=0;

        for(int i=0 ; i<homePage.selectedItems.size();i++){
            homePage.selectedItems.get(i).click();
            Assert.assertEquals(productPage.getCartCount(),count);
            webUiActions.clickOn(productPage.addToCartBTN,true);
            Assert.assertEquals(productPage.getCartCount(),count++);
            System.out.println("Counter = "+productPage.getCartCount());
            count++;
            totalprice+=Integer.parseInt(homePage.selectedItems.get(i).getText().toString());
            browserActions.driver.navigate().back();
            browserActions.driver.navigate().back();
        }
    }
    @Test(priority = 2)
    public void submitOrder{
        webUiActions.clickOn(homePage.cartIcon,true);
        checkOutPPage = new CheckOutPPage();
        checkOutPPage.addAddress("test","1111111111","test","1","Cairo","Zamalek");
        webUiActions.clickOn(checkOutPPage.cash,true);
        String s = browserActions.driver.findElement(By.xpath("//*[@id=\'subtotals-marketplace-table\']/table/tbody/tr[1]/td[2]")).getText();
        s.replaceAll("[^\\d.]","");
        Assert.assertEquals(s , totalprice);

    }
    @AfterTest
    void teardown(){
        driver.quit();
    }

}
