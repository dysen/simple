package steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.adapter.junit.After;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.blocket.AllAdsPage;
import pages.blocket.EmployersPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.Utils.setChromeDriverLocation;

public class StepDefinition extends FluentCucumberTest {
    @Page
    private AllAdsPage allAdsPage;
    @Page
    private EmployersPage employersPage;

    @Step("Go to all ads page")
    @Given("^Customer goes to a search page$")
    public void customerGoesToASearchPage() {
        goTo(allAdsPage);
    }

    @Step("Customer tries to search with given parameters")
    @When("^Customer tries to search with given parameters:$")
    public void customerTriesToSearchWithGivenParameters(Map<String, String> parameters) {
        allAdsPage
                .withSearchRequest(parameters.get("searchRequest"))
                .withCategory(parameters.get("category"))
                .withArea(parameters.get("area"))
                .withCounty(parameters.get("county"))
                .withSearchExtras(parameters.get("searchExtraOption"));
    }

    @Step("Getting search result")
    @Then("^System can provide (\\d+) of hits$")
    public void systemCanProvideOfHits(int numberOfHits) {
        assertThat(allAdsPage.getSearchResultCount().equals(numberOfHits));
    }

    @Given("^Customer goes to a employee page$")
    public void customerGoesToAEmployeePage()  {
        goTo(employersPage);
    }

    @When("^Customer goes to a section: (\\w+)$")
    public void customerGoesToSection(String section) {
        System.out.println("Section: " + section);
    }

    @Then("^Customer can see expected title$")
    public void customerCanSeeExpectedTitleText(String title){
        System.out.println("Title: " + title);
    }

    @Before
    public void before(Scenario scenario) {
        setChromeDriverLocation();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("chromeOptions", options);
        setCapabilities(capabilities);
        setBaseUrl("https://www.blocket.se");
        setWebDriver("chrome");
        super.before(scenario);
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);
    }
}