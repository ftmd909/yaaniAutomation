package TestCases;

import Drivers.BaseTest;
import Pages.*;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001 extends BaseTest {
    String userName = "piaerzincan@gmail.com";
    String pass = "24Erzincanpia24";


    @Test
    public void YaaniTest() {
    HomePage homePage = new HomePage(driver);
    SearchPage searchpagee= new SearchPage(driver);

   // homePage.favorite();
   // homePage.setCreateNewFavoriteControl();
   // searchpagee.searchPagee();
    searchpagee.fizySearchPage();
    searchpagee.facebookSearchPage(userName,pass);


    }


}
