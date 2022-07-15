package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.testng.Assert;
import test.v6.B;

public class HomePage extends BasePage {
    String translateTxt="hello";
    String getTxt="Merhaba";
    By weathericon = new By.ById("favorites-sc-id-weather");
    By YaaniImage=new By.ByXPath("(//div[@class='col'])[1]");
    By Dovizİcon = new By.ById("favorites-sc-id-currency");
    By pharmacyİcon = new By.ById("favorites-sc-id-pharmacy");
    By translateicon=new By.ById("favorites-sc-id-translate");
    By translatetxt=new By.ByXPath("//div[@class='translate-field']//textarea[@placeholder='Metin Girin']");
    By sporicon=new By.ById("favorites-sc-id-sport");
    By favoriteadd=new By.ById("no-id");
    By favoriteName=new By.ByXPath("//input[@name='favLabel']");
    By favoriteURL =new By.ByXPath("//div[@class='home-favourite-modal-input-container form-floating']//input[@name='favUrl']");
    By favoriteAddButton=new By.ByXPath("//div[@class='col']//button[@class='home-favourite-modal-save-button float-start w-50 btn btn-none btn-lg']");
    By scrll=new By.ByXPath("//div[@class='home-sponsor-box']");
    By favorite3dot=new By.ByXPath("//div[@class='home-favourite-area d-flex justify-content-start h-auto']//div[@class='home-favourite-container']//div[@class='home-favourite']//div[@class='home-favourite-box']//div[@class='home-favourite-edit-container dropdown']//span[@id='home-favourite-edit-Youtube']");
    By favoriteDelete=new By.ByXPath("//div[@class='home-favourite-area d-flex justify-content-start h-auto']//div[@class='home-favourite-container']//div[@class='home-favourite']//div[@class='home-favourite-box']//div[@class='home-favourite-edit-container dropdown']//ul[@class='home-favourite-edit-menu dropdown-menu dropdown-menu-end show']//li//span[@data-label='Youtube'][contains(text(),'Kaldır')]");
    By newFavControl = new By.ByXPath("(//span[normalize-space()='Youtube'])[1]");


    public HomePage(WebDriver driver) {
        super(driver);
    }


 public void favorite() {
     waitForSecond(5);
     scrollPageElement(drivers().findElement(Dovizİcon));
     click(Dovizİcon);

     waitForSecond(5);
     scrollPageElement(drivers().findElement(pharmacyİcon));
     click(pharmacyİcon);

     waitForSecond(5);
     scrollPageElement(drivers().findElement(sporicon));
     click(sporicon);

     waitForSecond(5);
     scrollPageElement(drivers().findElement(weathericon));
     click(weathericon);

     waitForSecond(5);
     scrollPageElement(drivers().findElement(translateicon));
     click(translateicon);

     String orginalWindow = drivers().getWindowHandle();
     drivers().switchTo().window(orginalWindow);

     for (String windowHandleTranslate : drivers().getWindowHandles()) {
         if (!orginalWindow.contentEquals(windowHandleTranslate)) {
             drivers().switchTo().window(windowHandleTranslate);

             waitForSecond(3);
             scrollPageElement(drivers().findElement(translatetxt));
             send(translatetxt, translateTxt);
             Boolean translateControl = isDisplay(translatetxt);
             Assert.assertTrue(translateControl);
             waitForSecond(5);
             String TranslateTxtControl = find(By.xpath("//textarea[@class='textarea-translated']"))
                     .getText();
             Assert.assertEquals(TranslateTxtControl,getTxt);
             waitForSecond(5);

             break;
         }
     }
     drivers().switchTo().window(orginalWindow);
     waitForSecond(5);



    }
    public void setCreateNewFavoriteControl(){
        waitForSecond(5);
        String listName = "Youtube";
        String listUrl = "https://www.youtube.com/";
        scrollPageElement(drivers().findElement(scrll));
        waitForSecond(2);
        click(favoriteadd);
        waitForSecond(2);
        send(favoriteName,listName);
        waitForSecond(2);
        send(favoriteURL,listUrl );
        waitForSecond(3);
        click(favoriteAddButton);
        waitForSecond(5);
        drivers().navigate().refresh();
        waitForSecond(5);
        Boolean listControl = isDisplay(newFavControl);
        Assert.assertTrue(listControl);
        // ExtentTestManager.getTest().log(Status.PASS,"List Created");

    }
}
