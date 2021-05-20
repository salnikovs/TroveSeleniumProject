import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class shoesAndFilters_Test {

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
    public void test1PDP ()  {            // Excellent size 7 Black
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet1();
        Assert.assertTrue(shoesAndFilters.conditionExcellentIsDisplayed());

    }

    @Test
    public void test2PDP () {            // lightly Worn size 7 Black
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();
        Assert.assertTrue(shoesAndFilters.conditionLightlyWornIsDisplayed());
    }

    @Test
    public void test3PDP () {           // Moderately Worn size 7 Black
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.conditionModerateWornIsDisplayed());
    }

    @Test
    public void test4PDP () {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.colorFilterBlackIsDisplayed());
    }
    @Test
    public void test5PDP () {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();
        Assert.assertTrue(shoesAndFilters.colorFilterBlueIsDisplayed());
    }

    @Test
    public void test6PDP () {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.sizeFilter7IsDisplayed());
    }
    @Test
    public void test7PDP () {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertEquals(5,shoesAndFilters.appliedFiltersNum());

    }

    @After
    public void tearDown (){
    driver.quit();
    }

}
