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

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.rei.com/used");

    }

    @Test
    public void test1shoesSelectionAndFilters ()  {           // Check if Excellent condition filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet1();
        Assert.assertTrue(shoesAndFilters.conditionExcellentIsDisplayed());

    }

    @Test
    public void test2shoesSelectionAndFilters () {            // Check if Lightly Worn condition filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();
        Assert.assertTrue(shoesAndFilters.conditionLightlyWornIsDisplayed());
    }

    @Test
    public void test3shoesSelectionAndFilters () {           // Check if Moderate Worn condition filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.conditionModerateWornIsDisplayed());
    }

    @Test
    public void test4shoesSelectionAndFilters () {           // Check if Black color filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.colorFilterBlackIsDisplayed());
    }
    @Test
    public void test5shoesSelectionAndFilters () {          // Check if Blue Color filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();
        Assert.assertTrue(shoesAndFilters.colorFilterBlueIsDisplayed());
    }

    @Test
    public void test6shoesSelectionAndFilters () {          // Check if size filter works
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        Assert.assertTrue(shoesAndFilters.sizeFilter7IsDisplayed());
    }
    @Test
    public void test7shoesSelectionAndFilters () {          // Check if all above filters are working all together
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
