import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class checkout_Test {

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
    public void test1CheckoutPage () throws InterruptedException {               // entering correct emails
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);

        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet5();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.navigate().back();;

        cartPage.clickCheckout();

        checkoutPage.fillInEmailFields("eugene.salnikov@test.com","eugene.salnikovs@test.com");

        Assert.assertFalse(checkoutPage.upperAlertShowedUp());


    }

    @Test
    public void test2CheckoutPage () throws InterruptedException{                                              // entering incorrect first email
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);

        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet2();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.navigate().back();;

        cartPage.clickCheckout();

        checkoutPage.fillInEmailFields("eugene.salnikovtest.com","eugene.salnikovs@test.com");

        Assert.assertTrue(checkoutPage.upperAlertShowedUp());







    }

    @Test
    public void test3CheckoutPage () throws InterruptedException {                                             // using incorrect second emails
        landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
        shoesAndFilters shoesAndFilters = PageFactory.initElements(driver, shoesAndFilters.class);
        productDescriptionPage productDescriptionPage = PageFactory.initElements(driver, productDescriptionPage.class);
        cartPage cartPage = PageFactory.initElements(driver, cartPage.class);
        checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);

        landingPage.proceedToSandalsAndWaterShoes();
        shoesAndFilters.filtersSet3();
        shoesAndFilters.selectShoeItemInTheGrid2();
        productDescriptionPage.clickSize();
        productDescriptionPage.clickCondition();
        productDescriptionPage.clickAddToCart();
        productDescriptionPage.clickViewYourCart();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.navigate().back();;

        cartPage.clickCheckout();

        checkoutPage.fillInEmailFields("eugene.salnikov@test.com","eugene.salnikovstest.com");

        Assert.assertTrue(checkoutPage.lowerAlertShowedUp());

    }

    @After
    public void tearDown (){
        driver.quit();
    }


}
