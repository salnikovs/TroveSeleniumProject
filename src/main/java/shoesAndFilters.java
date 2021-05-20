import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class shoesAndFilters {

    private WebDriver driver;

    public shoesAndFilters(WebDriver driver){
        this.driver = driver;
    }


    // Sizes filter

    @FindBy(xpath = "//section[@class='Filter filter-size entered']//label[@for='filter-size-7']")
    private WebElement size7Checkbox;
    @FindBy(xpath = "//section[@class='Filter filter-size entered']//label[@for='filter-size-6']")
    private WebElement size6Checkbox;

    @FindBy(xpath = "//section[@class='Filter filter-color entered']//label")
    private List<WebElement> allCheckBoxesForColor;

    @FindBy(xpath = "//section[@class='Filter filter-condition entered']//label[@for='filter-condition-Excellent-condition']")
    private WebElement conditionExcellent;
    @FindBy(xpath = "//section[@class='Filter filter-condition entered']//label[@for='filter-condition-Lightly-worn']")
    private WebElement conditionLightlyWorn;
    @FindBy(xpath = "//section[@class='Filter filter-condition entered']//label[@for='filter-condition-Moderately-worn']")
    private WebElement conditionModeratelyWorn;


    // shoes grid
    @FindBy(xpath = "//div[@class='List']//div[@class='img-wrap']")
    private List <WebElement> resultsGrid;

   // applied filters
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='7 filter']")
    private WebElement appliedFilterSize7;
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='Black filter']")
    private WebElement appliedFilterColorBlack;
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='Blue filter']")
    private WebElement appliedFilterColorBlue;
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='Excellent condition filter']")
    private WebElement appliedFilterExcellent;
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='Lightly worn filter']")
    private WebElement appliedFilterLightlyWornFilter;
    @FindBy(xpath = "//div[@class='applied-filters']//span[@aria-label='Moderately worn filter']")
    private WebElement appliedFilterModeratelyWorn;

    @FindBy(xpath = "//div[@class='applied-filters']//span")
    private List<WebElement> listOfAppliedFilters;
    @FindBy(xpath = "//div[@class='List']//span[@class='title']")
    private List<WebElement> listOfItemTitles;



    // action methods




    public shoesAndFilters selectShoeItemInTheGrid1 (){
        resultsGrid.get(0).click();
        return this;
    }
    public shoesAndFilters selectShoeItemInTheGrid2 (){
        resultsGrid.get(1).click();
        return this;
    }

    public shoesAndFilters selectSize7 (){
        size7Checkbox.click();
        return this;
    }
    public shoesAndFilters selectSize6 (){
        size6Checkbox.click();
        return this;
    }
    public shoesAndFilters selectColorBlack (){
        allCheckBoxesForColor.get(0).click();
        return this;
    }
    public shoesAndFilters selectColorBrown (){
        allCheckBoxesForColor.get(2).click();
        return this;
    }
    public shoesAndFilters selectColorBlue () {
        allCheckBoxesForColor.get(1).click();
        return this;
    }
      public shoesAndFilters selectConditionExcellent (){
        conditionExcellent.click();
        return this;
    }
    public shoesAndFilters selectConditionLightlyWorn (){
        conditionLightlyWorn.click();
        return this;
    }
    public shoesAndFilters selectConditionModeratelyWorn (){
        conditionModeratelyWorn.click();
        return this;
    }

    public shoesAndFilters filtersSet1 ()   {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionExcellent();
        this.selectSize7();
        this.selectColorBlack();
        return new shoesAndFilters(driver);

    }
    public shoesAndFilters filtersSet2 ()  {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionLightlyWorn();
        this.selectSize7();
        this.selectColorBlue();
        return new shoesAndFilters(driver);

    }

    public shoesAndFilters filtersSet3 () {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionModeratelyWorn();
        this.selectSize7();
        this.selectColorBlack();
        return new shoesAndFilters(driver);

    }


    public shoesAndFilters filtersSet4 ()   {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionExcellent();
        this.selectSize7();
        this.selectColorBrown();
        return new shoesAndFilters(driver);

    }
    public shoesAndFilters filtersSet5 ()   {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionExcellent();
        this.selectSize6();
        this.selectColorBlack();
        return new shoesAndFilters(driver);

    }
    public shoesAndFilters filtersSet6 ()  {                // this result set select black shoes of size 7 in excellent condition
        this.selectConditionExcellent();
        this.selectSize6();
        this.selectColorBlack();
        return new shoesAndFilters(driver);

    }

    public boolean sizeFilter7IsDisplayed (){ return appliedFilterSize7.isDisplayed();}
    public boolean colorFilterBlackIsDisplayed (){ return appliedFilterColorBlack.isDisplayed();}
    public boolean colorFilterBlueIsDisplayed (){ return appliedFilterColorBlue.isDisplayed();}
    public boolean conditionExcellentIsDisplayed (){ return appliedFilterExcellent.isDisplayed();}
    public boolean conditionLightlyWornIsDisplayed (){ return appliedFilterLightlyWornFilter.isDisplayed();}
    public boolean conditionModerateWornIsDisplayed (){ return appliedFilterModeratelyWorn.isDisplayed();}

    public int appliedFiltersNum () { return listOfAppliedFilters.size(); }
    public String shoeName1stPos () { return listOfItemTitles.get(0).getText();}
    public String shoeName2stPos () { return listOfItemTitles.get(1).getText();}





}
