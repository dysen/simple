package pages.blocket.elements;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtraSearchPanel extends FluentWebElement {

    public ExtraSearchPanel(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    @FindBy(id = "type_s")
    private FluentWebElement saleCheckBox;

    @FindBy(id = "type_u")
    private FluentWebElement rentCheckBox;

    @FindBy(id = "type_b")
    private FluentWebElement bytesCheckBox;

    @FindBy(id = "type_k")
    private FluentWebElement purchaseCheckBox;

    @FindBy(id = "type_h")
    private FluentWebElement wishToRentCheckBox;

    public void withSaleType() {
        saleCheckBox.click();
    }

    public void withRentType() {
        rentCheckBox.click();
    }

    public void withBytesType() {
        bytesCheckBox.click();
    }

    public void withPurchaseType() {
        purchaseCheckBox.click();
    }

    public void withWishToRentType() {
        wishToRentCheckBox.click();
    }
}
