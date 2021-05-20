import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class productDescription_Test {

    private WebDriver driver;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\eugen\\Documents\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.rei.com/used");


    }

    @Test
    public void test1PDP ()  {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet1();   // Excellent size 7 Black
        shoesAndFilters.selectShoeItemInTheGrid2();
        Assert.assertTrue(productDescriptionPage.excellentLabelIsDisplayed());

    }

    @Test
    public void test2PDP () {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();   // lightly Worn size 7 Blue
        shoesAndFilters.selectShoeItemInTheGrid1();
        Assert.assertTrue(productDescriptionPage.lightlyWornLabelIsDisplayed());

    }

    @Test
    public void test3PDP () {                   // check condition and size not selected alert
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();   // lightly Worn size 7 Blue
        shoesAndFilters.selectShoeItemInTheGrid1();
        productDescriptionPage.clickAddToCart();
        Assert.assertEquals("Please select a size and a condition",productDescriptionPage.alertConditionAndSizeText());

    }

    @Test
    public void test4PDP () {                    // check size not selected alert
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet1();   // lightly Worn size 7 Blue
        shoesAndFilters.selectShoeItemInTheGrid1();
        productDescriptionPage.clickConditionExcellent();
        productDescriptionPage.clickAddToCart();
        Assert.assertEquals("Please select a size",productDescriptionPage.alertSizeText());
    }

    @After
    public void tearDown (){
        driver.quit();
    }

}
