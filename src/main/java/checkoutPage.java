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

    public checkoutPage fillInEmailFieldFirst (String email1) {
        emailfields.get(0).sendKeys(email1);
        return this;
    }
    public checkoutPage fillInEmailFieldSecond (String email2) {
        emailfields.get(1).sendKeys(email2);
        return this;
    }


    public boolean checkoutHeaderTextExists (){ return checkoutHeader.isDisplayed();}
    public String checkoutHeaderText () { return checkoutHeader.getText();}



    public checkoutPage fillInEmailFieldsCorrectly () {
        this.fillInEmailFieldFirst("eugene.test@gmail.com");
        this.fillInEmailFieldFirst("eugene.test@gmail.com");
        return new checkoutPage(driver);

    }

    public checkoutPage fillInEmailFieldsIncorrectly () {
        this.fillInEmailFieldFirst("eugene.test@gmail.com");
        this.fillInEmailFieldFirst("eugene.test@gmail.com");
        return new checkoutPage(driver);

    }




}
