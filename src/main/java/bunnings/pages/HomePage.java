package bunnings.pages;

import bunnings.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mrinalirao on 18/03/17.
 */
public class HomePage extends PageObject {

    public HomePage(){
        super(conf);
    }

    By search = By.xpath("//input[@id='SearchText']");
    By searchLocation = By.xpath("//span[contains(.,'Entire site')]");
    By dropDownItem = By.xpath("//a[text()='Kitchen']");
    By searchButton = By.id("SearchButton");
    public String searchText = "cabinets";
    By signUp = By.xpath("//a[text()='Sign Up']");
    By tools = By.xpath("//div[@id='content-anchor']//a[contains(.,'Tools') and @href='/our-range/tools'][@data-tracking-identifier='Top Links']");


    public void loadHomePage(){
        driver.get(conf.getConfig("bunningsUrl"));
        waitForLoad(driver);
    }

    public SearchPage searchItem(){

        driver.findElement(search).sendKeys(searchText);
        driver.findElement(searchLocation).click();
        driver.findElement(dropDownItem).click();
        driver.findElement(searchButton).click();

        return new SearchPage();
    }

    public SignUp signUp(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUp));
        driver.findElement(signUp).click();

        return new SignUp();

    }

    public void getListLeadingBrandsInTools(){

    }

}
