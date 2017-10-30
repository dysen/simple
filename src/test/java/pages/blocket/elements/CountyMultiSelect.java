package pages.blocket.elements;

import lombok.Getter;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CountyMultiSelect extends FluentWebElement {

    public CountyMultiSelect(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    @FindBy(css = "button.multiselect.dropdown-toggle.btn.btn-default")
    private FluentWebElement allCountiesButton;

    @FindBy(tagName = "ul")
    private FluentWebElement mainList;

    @FindBy(tagName = "li")
    private FluentList<FluentWebElement> counties;

    public void getOptionByName(String name) {
        allCountiesButton.click();

        FluentWebElement fluentWebElement = counties.stream()
                .filter(element -> element.textContent().contains(name)).findFirst().get();
        fluentWebElement.click();
    }

    public void getOptionsByName(List<String> countiesList) {
        allCountiesButton.click();
        for (String county : countiesList) {
            FluentWebElement fluentWebElement = counties.stream()
                    .filter(element -> element.textContent().contains(county)).findFirst().get();
            fluentWebElement.click();
        }
    }
}
