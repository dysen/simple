package tests;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.blocket.snappet.DashboardPage;
import pages.blocket.snappet.LoginPage;

import static utils.Utils.setChromeDriverLocation;

@FluentConfiguration(driverLifecycle = ConfigurationProperties.DriverLifecycle.METHOD)

public class BaseTest extends FluentTest {

    private static final String USER_NAME = "challengeTeacher2";
    private static final String PASSWORD = "6w0vXrue!";

    public BaseTest() {
        setChromeDriverLocation();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", options);
        setCapabilities(capabilities);
        setBaseUrl("https://teacher.snappet.org");
        setWebDriver("chrome");
    }

    @Page
    private LoginPage loginPage;
    @Page
    private DashboardPage dashboard;

    @Before
    public void setUp() {


    }

    public void loginAsValidUser() {

        goTo(loginPage);
        loginPage.login(USER_NAME, PASSWORD);
        loginPage.<DashboardPage>go();

       // return dashboard;

    }
}
