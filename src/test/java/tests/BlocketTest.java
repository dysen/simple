package tests;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.blocket.AllAdsPage;
import pages.blocket.JobPage;
import pages.blocket.StartPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import static pages.blocket.snappet.DashboardPage.ActivityPeriod.YESTERDAY;

public class BlocketTest extends BaseTest {
    @Page
    private StartPage startPage;

    @Page
    private AllAdsPage allAdsPage;

    @Page
    private JobPage jobPage;

 @Test
    public void simpleSearchFlowTest() {
        goTo(allAdsPage);
        allAdsPage
                .withSearchRequest("Älgkött")
                .withCategory("Övrigt")
                .withArea("Hela Sverige")
                .withCounty("Botkyrka")
                .withSearchExtras("Köpes");
        assertThat(allAdsPage.getSearchResultCount().equals(2));

    }


    @Test
    public void verifyStaticContentOnJobPageTest() {
        goTo(jobPage);
        FluentWebElement carouselPanel = jobPage.getCarouselPanel();
        carouselPanel.scrollIntoView();
        assertThat(carouselPanel.displayed()).isTrue();
        assertThat(carouselPanel.clickable()).isTrue();
        assertThat(carouselPanel.present()).isTrue();
        assertThat(carouselPanel.find(By.tagName("a")).count()).isGreaterThanOrEqualTo(20);

        FluentWebElement emailNotification = jobPage.getEmailNotification();
        emailNotification.scrollIntoView();
        assertThat(emailNotification.displayed()).isTrue();
        assertThat(emailNotification.clickable()).isTrue();
        assertThat(emailNotification.present()).isTrue();

        FluentList<FluentWebElement> loginPanels = jobPage.getLoginPanels();
        loginPanels.scrollIntoView();
        FluentWebElement savedJobLogin = loginPanels.get(0);
        assertThat(savedJobLogin.displayed()).isTrue();
        assertThat(savedJobLogin.clickable()).isTrue();
        assertThat(savedJobLogin.present()).isTrue();

        FluentWebElement jobGuardianLogin = loginPanels.get(1);
        jobGuardianLogin.scrollIntoView();
        assertThat(jobGuardianLogin.displayed()).isTrue();
        assertThat(jobGuardianLogin.clickable()).isTrue();
        assertThat(jobGuardianLogin.present()).isTrue();

        FluentList<FluentWebElement> mediaBodies = jobPage.getMediaBodies();
        mediaBodies.scrollIntoView();
        assertThat(mediaBodies.count()).isGreaterThanOrEqualTo(9);

        FluentWebElement whatSearchInput = jobPage.getWhatSearchInput();
        whatSearchInput.scrollIntoView();
        assertThat(whatSearchInput.attribute("placeholder").equalsIgnoreCase("Vad? Titel, bransch, företag, nyckelord"));
        assertThat(whatSearchInput.displayed()).isTrue();
        assertThat(whatSearchInput.clickable()).isTrue();
        assertThat(whatSearchInput.present()).isTrue();

        FluentWebElement whereSearchInput = jobPage.getWhereSearchInput();
        whereSearchInput.scrollIntoView();
        assertThat(whereSearchInput.displayed()).isTrue();
        assertThat(whereSearchInput.clickable()).isTrue();
        assertThat(whereSearchInput.present()).isTrue();
        assertThat(whereSearchInput.find(By.cssSelector(" input#searchregion")).attribute("placeholder").equalsIgnoreCase("Var ? Kommun, län, område"));

        FluentWebElement socialMediaBox = jobPage.getSocialMediaBox();
        socialMediaBox.scrollIntoView();
        assertThat(socialMediaBox.displayed()).isTrue();
        assertThat(socialMediaBox.clickable()).isTrue();
        assertThat(socialMediaBox.present()).isTrue();
        assertThat(socialMediaBox.find(By.tagName("a")).count()).isGreaterThanOrEqualTo(9);
    }
}
