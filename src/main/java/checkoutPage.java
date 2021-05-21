import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class checkoutPage {


    private WebDriver driver;

    public checkoutPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[text()='Used Gear Checkout']")
    private WebElement checkoutHeader;
    @FindBy(xpath = "//input[@name='email']")
    private List<WebElement> emailfields;


    @FindBy(xpath = "//label[@for='email']//li[text()='This field is invalid']")
    private WebElement upperAlert;
    @FindBy(xpath = "//label[@for='emailConfirm']//li[text()='This field is invalid']")
    private WebElement lowerAlert;




    public checkoutPage fillInEmailFieldFirst (String email1) {
        emailfields.get(0).sendKeys(email1);
        return this;
    }
    public checkoutPage fillInEmailFieldSecond (String email2) {
        emailfields.get(1).sendKeys(email2);
        return this;
    }


    public boolean checkoutHeaderTextExists (){ return checkoutHeader.isDisplayed();}

    public boolean upperAlertShowedUp (){ return upperAlert.isDisplayed();}
    public boolean lowerAlertShowedUp (){ return lowerAlert.isDisplayed();}



    public String checkoutHeaderText () { return checkoutHeader.getText();}



    public checkoutPage fillInEmailFields (String upperEmail, String lowerEmail) {
        this.fillInEmailFieldFirst(upperEmail);
        this.fillInEmailFieldFirst(lowerEmail);
        return new checkoutPage(driver);

    }






}
