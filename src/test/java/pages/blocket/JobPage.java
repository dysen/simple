package pages.blocket;

import lombok.Getter;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@PageUrl("https://jobb.blocket.se/?ca=11&w=")
public class JobPage extends FluentPage {

    @FindBy(css = "div#search-vad input.tt-input")
    private FluentWebElement whatSearchInput;

    @FindBy(css = "div#search-var")
    private FluentWebElement whereSearchInput;

    @FindBy(id = "adwatch-puff")
    private FluentWebElement emailNotification;

    @FindBy(id = "index-carousel")
    private FluentWebElement carouselPanel;

    @FindBy(css = "div.teaser-box")
    private FluentList<FluentWebElement> loginPanels;

    @FindBy(id = "socialmediasearch")
    private FluentWebElement socialMediaBox;

    @FindBy(css = "div.media-body")
    private FluentList<FluentWebElement> mediaBodies;

}
