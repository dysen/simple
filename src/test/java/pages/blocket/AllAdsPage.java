package pages.blocket;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocket.elements.CountyMultiSelect;
import pages.blocket.elements.ExtraSearchPanel;

@PageUrl("https://www.blocket.se/stockholm?ca=11")
public class AllAdsPage extends FluentPage {

    @FindBy(id = "searcharea_simple")
    private FluentWebElement areaSelector;


    @FindBy(css = "div.btn-group.pull-left.mrs")
    private CountyMultiSelect countyMultiSelect;

    @FindBy(id = "catgroup")
    private FluentWebElement categorySelect;

    @FindBy(id = "types")
    private ExtraSearchPanel searchExtraPanel;

    @FindBy(id = "searchtext")
    private FluentWebElement searchInput;

    @FindBy(css = "span.num_hits")
    private FluentWebElement numberOfHitsSpan;


    public AllAdsPage withCategory(String category) {
        categorySelect.fillSelect().withText(category);
        return this;
    }

    public AllAdsPage withArea(String area) {
        areaSelector.fillSelect().withText(area);
        return this;
    }

    public AllAdsPage withCounty(String county) {

        return this;
    }

    public AllAdsPage withSearchExtras(String extraParam) {
        switch (extraParam) {
            case "Säljes":
                searchExtraPanel.withSaleType();
                break;
            case "Uthyres":
                searchExtraPanel.withRentType();
                break;
            case "Bytes":
                searchExtraPanel.withBytesType();
                break;
            case "Köpes":
                searchExtraPanel.withPurchaseType();
                break;
            case "Önskar hyra":
                searchExtraPanel.withWishToRentType();
                break;
            default:
                throw new IllegalArgumentException("Invalid extra params: " + extraParam);
        }
        return this;
    }

    public AllAdsPage withSearchRequest(String searchRequest) {
        searchInput.fill().withText(searchRequest);
        return this;
    }

    public Integer getSearchResultCount() {
        String searchResultString = numberOfHitsSpan.text();
        return Integer.parseInt(searchResultString);
    }
}