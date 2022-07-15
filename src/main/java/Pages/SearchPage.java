package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends BasePage {
    String searchYaaniTxt="Erzincan";
    String FacebookYaaniTxt="Facebook";
    String singerName="Demet Akalın";

    By YaaniImage=new By.ByXPath("//div[@class='ys-doodle-section cursor-pointer ']");
    By searchYaani=new By.ByXPath("//div[@class='input-group border-0 bg-transparent p-0']//input[@class='form-control s-input px-5 border-0 ys-input-header-section']");
    By searchicon=new By.ByCssSelector(".s-search-icon");
    By newsTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[1]");
    By imagesTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[2]");
    By shoppingTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[3]");
    By videosTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[4]");
    By mapTab=new By.ByXPath("(//div[@class='y-palette-icon tab-item-passive tab-item-label-passive'])[5]");
    By facebookSearchPage=new By.ByXPath("//span[normalize-space()='https://www.facebook.com']");
    By facebookEmail=new By.ByXPath("//input[@id='email']");
    By facebookPass=new By.ByXPath("//input[@id='pass']");
    By facebookLoginBtn=new By.ByXPath("//div[@class='_6ltg']//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']");
    By facebookIcon=new By.ByXPath("//a[@aria-label='Facebook']//*[name()='svg']");
    By fizyLoginIcon=new By.ByXPath("//section[@class='header']//img[@alt='fizy']");
    By fizySearchPage=new By.ByXPath("//span[@class='fizy-desc-query']");
    By singPlay=new By.ByXPath("(//div[@class='cover'])[3]");


    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public boolean iconIsDisplay(){
        boolean lgnValidation = isDisplay(fizyLoginIcon);
        return lgnValidation;
    }
    public void setLoginValidation(){

        Assert.assertTrue(iconIsDisplay());
        System.out.println("Giriş Başarılı");

    }
    public void searchPagee() {

        waitForSecond(5);
        send(searchYaani,searchYaaniTxt);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(3);
        click(newsTab);

        waitForSecond(3);
        click(imagesTab);

        waitForSecond(3);
        click(shoppingTab);

        waitForSecond(3);
        click(videosTab);

        waitForSecond(3);
        click(mapTab);

        waitForSecond(3);
        click(YaaniImage);
    }


    public void fizySearchPage() {
        waitForSecond(5);
        send(searchYaani, singerName);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(5);
        scrollPageElement(drivers().findElement(fizySearchPage));
        click(fizySearchPage);

        String orginalWindow = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindow);

        for (String windowHandleTranslate : drivers().getWindowHandles()) {
            if (!orginalWindow.contentEquals(windowHandleTranslate)) {
                drivers().switchTo().window(windowHandleTranslate);
                waitForSecond(5);
                String singerNameControl = find(By.xpath("//div[@class='song']"))
                        .getText();
                Assert.assertEquals(singerNameControl,singerName);

                waitForSecond(5);
                click(singPlay);  //şarkı oynatılır
                System.out.println("Sarki caldi");
                waitForSecond(6);
                click(singPlay);  //şarkı durdurulur
                System.out.println("Sarki durdu");
                break;
            }
        }
        drivers().switchTo().window(orginalWindow);
        waitForSecond(3);
        scrollPageElement(drivers().findElement(YaaniImage));
        click(YaaniImage);
    }

    public void facebookSearchPage(String username,String password){
        waitForSecond(5);
        send(searchYaani,FacebookYaaniTxt);

        waitForSecond(3);
        click(searchicon);

        waitForSecond(3);
        click(facebookSearchPage);
        String orginalWindow = drivers().getWindowHandle();
        drivers().switchTo().window(orginalWindow);

        for (String windowHandleTranslate : drivers().getWindowHandles()) {
            if (!orginalWindow.contentEquals(windowHandleTranslate)) {
                drivers().switchTo().window(windowHandleTranslate);
                waitForSecond(3);
                send(facebookEmail, username);
                waitForSecond(3);
                send(facebookPass,password);
                waitForSecond(3);
                click(facebookLoginBtn);
                waitForSecond(5);
                Boolean FacebookLoginControl = isDisplay(facebookIcon);
                Assert.assertTrue(FacebookLoginControl);
                break;
            }
        }
        waitForSecond(3);
        drivers().switchTo().window(orginalWindow);

    }
    }
