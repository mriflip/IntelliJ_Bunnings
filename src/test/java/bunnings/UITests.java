package bunnings;

import bunnings.core.BaseSetup;
import bunnings.pages.HomePage;
import bunnings.pages.SearchPage;
import bunnings.pages.SignUp;
import org.testng.annotations.Test;

/**
 * Created by mrinalirao on 18/03/17.
 */

@Test
public class UITests extends BaseSetup{

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    SignUp signUp = new SignUp();

    public void bunningsTest(){

        homePage.loadHomePage();
       // searchPage = homePage.searchItem();
       // searchPage.checkIfSearchPage();
       // searchPage.sortByPrice();
        signUp=homePage.signUp();
        signUp.register();

    }


}
