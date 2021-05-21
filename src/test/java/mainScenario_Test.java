import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class mainScenario_Test {


    private WebDriver driver;


    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.rei.com/used");

    }



    //+++++++++++++ This is the main scenario, where we are checking User Story of
    //+++++++++++++ Navigating to the specific show department
    //+++++++++++++ Applying filters
    //+++++++++++++ Getting results returned
    //+++++++++++++ Adding items to the cart
    //+++++++++++++ Deleting items from the cart
    //+++++++++++++ Proceeding to checkout
    //+++++++++++++ Filling out Checkout form


    @Test
    public void test4CartPageTest () throws InterruptedException {
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);

        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet4();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(2000);

        driver.navigate().back();
        driver.navigate().back();

        shoesAndFilters.filtersSet5();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();

        Thread.sleep(2000);
        cartPage.clickRemoveTheLastItem();

        cartPage.clickCheckout();

        Assert.assertTrue(checkoutPage.continueToBillingButtonDisplayed());

    }


    @After
    public void tearDown (){
        driver.quit();
    }



}
