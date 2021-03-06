package pageobject_model.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pageobject_model.driver.DriverSingleton;
import pageobject_model.page.*;
import pageobject_model.utils.TestListener;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public abstract class BaseTest extends DriverContainer {

    @BeforeTest(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException, AWTException {
        DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new CloudGoogleHomePage(driver).openPage();
        new CloudGoogleProductsPage(driver).openPage();
        new CloudGooglePricingPage(driver).openPage();
        new CloudGoogleCalculatorPage(driver).openPage().fillForm();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}