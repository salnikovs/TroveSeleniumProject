import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class landingPage {

    private WebDriver driver;

    public landingPage(WebDriver driver){
        this.driver = driver;
      }

    @FindBy(xpath = "//a[@href='/used/shop/womens']")
    private WebElement womenTab;
    @FindBy(xpath = "//div[@class='Submenu wrap']//a[text()='Sandals & Water Shoes']")
    private WebElement sandalsAndShoes;
    @FindBy(xpath = "//span[@aria-label='Sandals & Water Shoes filter']")
    private WebElement sandalsWaterShoesChecker;

    public landingPage clickWomenstab(){
        womenTab.click();
        return this;
    }

    public landingPage clickSandalsAndWaterShoes(){
        sandalsAndShoes.click();
        return this;
    }

    public boolean womensTabIsDisplayed (){ return womenTab.isDisplayed();}
    public boolean sandalsTabIsDisplayed (){ return sandalsAndShoes.isDisplayed();}
    public boolean sandalsShoesFilterIsDisplayed (){ return sandalsWaterShoesChecker.isDisplayed();}

    public landingPage proceedToSandalsAndWaterShoes () {
        this.clickWomenstab();
        this.clickSandalsAndWaterShoes();
        return new landingPage(driver);

    }





}
