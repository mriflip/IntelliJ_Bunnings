package bunnings.pages;

import bunnings.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by mrinalirao on 18/03/17.
 */
public class SearchPage extends PageObject {


    public SearchPage(){
        super(conf);
    }


    By searchResText = By.xpath("//h1[contains(.,'Results for')]");
    By selectDD = By.id("search-sort-dropdown");

    public void checkIfSearchPage(){
        Assert.assertTrue(driver.findElement(searchResText).isDisplayed());
    }

    public void sortByPrice(){

        Select dropDown = new Select(driver.findElement(selectDD));
        dropDown.selectByVisibleText("Price (High to low)");

        By price1 = By.xpath("//*[@id='content-layout_inside-anchor']/div[3]/div/div/section/div[2]/div/div[1]/section[1]/article[1]/a/div[2]/div[2]/div[2]");
        By price2 = By.xpath(".//*[@id='content-layout_inside-anchor']/div[3]/div/div/section/div[2]/div/div[1]/section[1]/article[2]/a/div[2]/div[2]/div[2]");

        String p1 = driver.findElement(price1).getText();
        String p2= driver.findElement(price2).getText();
        p1=p1.substring(1);
        p2=p2.substring(1);

        Assert.assertTrue(Integer.parseInt(p1) > Integer.parseInt(p2));
    }

}
