import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class productDescriptionPage {


    private WebDriver driver;

    public productDescriptionPage(WebDriver driver){
        this.driver = driver;
    }


    // buttons and links and warnings

    @FindBy(xpath = "//strong[text()='Please select a '][text()='size'][text()=' and a '][text()='condition']")
    private WebElement selectSizeAndConditionAlert;
    @FindBy(xpath = "//strong[text()='Please select a '][text()='size']")
    private WebElement selectSizeAlert;
    @FindBy(xpath = "//strong[text()='Please select a '][text()='condition']")
    private WebElement selectConditionAlert;
    @FindBy(xpath = "//div[text()='This item is already in your cart.']")
    private WebElement alreadyInYourCartAlert;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    private WebElement addToCardButton;
    @FindBy(xpath = "//input[@type='radio'][@name='size']")
    private List<WebElement> sizeButtons;
    @FindBy(xpath = "//input[@type='radio'][@name='condition']")
    private List<WebElement> conditionButtons;
    @FindBy(xpath = "//a[@class='view-cart'][text()='View your cart']")
    private WebElement viewYourCart;

    @FindBy(xpath = "//h2[@itemprop='name']")
    private WebElement shoeNameLabel;

    @FindBy(xpath = "//span[text()='Lightly worn']")
    private WebElement lightlyWornLabel;

    @FindBy(xpath = "//input[@aria-label='GRADE_A']")
    private WebElement excellentConditionLabel;






    // action methods

    public productDescriptionPage clickSize () {
        sizeButtons.get(1).click();
        return this;
    }
    public productDescriptionPage clickCondition () {
        conditionButtons.get(0).click();
        return this;
    }
    public productDescriptionPage clickConditionExcellent () {
        excellentConditionLabel.click();
        return this;
    }
    public productDescriptionPage clickAddToCart () {
        addToCardButton.click();
        return this;
    }
    public productDescriptionPage clickViewYourCart () {
        viewYourCart.click();
        return this;
    }





    public boolean SizeAndConditionAlertIsDisplayed (){ return selectSizeAndConditionAlert.isDisplayed();}
    public boolean SizeAlertIsDisplayed (){ return selectSizeAlert.isDisplayed();}
    public boolean ConditionAlertIsDisplayed (){ return selectConditionAlert.isDisplayed();}

    public boolean lightlyWornLabelIsDisplayed (){ return lightlyWornLabel.isDisplayed();}
    public boolean excellentLabelIsDisplayed (){ return excellentConditionLabel.isDisplayed();}
    public boolean viewCartPopUpIsDisplayed (){ return viewYourCart.isDisplayed();}

    public String alertConditionAndSizeText () {return selectSizeAndConditionAlert.getText();}
    public String alertConditionText () {return selectConditionAlert.getText();}
    public String alertSizeText () {return selectSizeAlert.getText();}

    public String shoeNamePDP () { return shoeNameLabel.getText();}






}
