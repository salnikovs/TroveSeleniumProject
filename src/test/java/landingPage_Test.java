import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class landingPage_Test {

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
       public void test1LandingPage () {                 // Check the tab is actually available
           landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
           Assert.assertTrue(landingPage.womensTabIsDisplayed());
       }

       @Test
       public void test2LandingPage () {                  // Check Sandals department is in there
           landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
           landingPage.clickWomenstab();
           Assert.assertTrue(landingPage.sandalsTabIsDisplayed());
       }

       @Test
       public void test3LandingPage () {                 // proceed to Sandals department and check if you are on the right page
           landingPage landingPage = PageFactory.initElements(driver, landingPage.class);
           landingPage.proceedToSandalsAndWaterShoes();
           Assert.assertTrue(landingPage.sandalsShoesFilterIsDisplayed());
       }

       @After
       public void tearDown (){
           driver.quit();
       }



}
