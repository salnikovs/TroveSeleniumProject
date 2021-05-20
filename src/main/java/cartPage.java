import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class cartPage {

    private WebDriver driver;

    public cartPage(WebDriver driver){
        this.driver = driver;
    }



    // buttons and links and warnings
    @FindBy(xpath = "//button[@class='checkout-button']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//span[@class='count']")
    private WebElement itemsCounter;

    @FindBy(xpath = "//p[@class='cart-no-items-message']")
    private WebElement noItemsMessage;




    @FindBy(xpath = "//button[text()='Remove']")
    private List<WebElement> removeButtons;




    // action methods

    public cartPage clickRemoveTheLastItem () {
        removeButtons.get(removeButtons.size()-1);
        return this;
    }


    public cartPage clickCheckout () {
        checkoutButton.click();
        return this;
    }



   public String numberOfItemsText () { return itemsCounter.getText();}
   public String noItemsMessageText () { return noItemsMessage.getText();}





}
