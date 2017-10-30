package pages.blocket.elements;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CountItem extends FluentWebElement {

    public CountItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    @FindBy(css = "span.col-xs-9.npl")
    private FluentWebElement itemName;

    @FindBy(css = "span.col-xs-3")
    private FluentWebElement itemCount;

    public String getItemName() {
        return itemName.text();
    }

    public String getItemCountValue() {
        return itemCount.text();
    }
}