import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class cartPage_Test {

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
    public void test1PDP ()  {             // adding a new item
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();   // Moderately Worn size 7 Black
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();

        Assert.assertEquals("1 item", cartPage.numberOfItemsText());


    }


    @Test
    public void test2PDP () throws InterruptedException {                    // removing that item
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet1();   // Moderately Worn size 7 Black
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(5000);
        cartPage.clickRemoveTheLastItem();
        Assert.assertEquals("You have no items in your shopping cart.",cartPage.noItemsMessageText());

    }


    @Test
    public void test3PDP () throws InterruptedException {                    // removing the second added item
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();   // Moderately Worn size 7 Black
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.navigate().back();

        shoesAndFilters.filtersSet4();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();

        cartPage.clickRemoveTheLastItem();

        Assert.assertEquals("1 item", cartPage.numberOfItemsText());

    }

    @Test
    public void test4PDP () throws InterruptedException {                    // removing the second added item and proceeding to checkout
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet5();   // Moderately Worn size 7 Black
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.navigate().back();

        shoesAndFilters.filtersSet6();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();

        cartPage.clickRemoveTheLastItem();

        cartPage.clickCheckout();

        Assert.assertTrue(checkoutPage.checkoutHeaderTextExists());

    }


    @After
    public void tearDown (){
        driver.quit();
    }




}
