package pages.blocket.snappet;

import lombok.Setter;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
@Setter
@PageUrl("/")
public class LoginPage extends FluentPage {

    @FindBy(id = "UserName")
    private FluentWebElement userNameField;

    @FindBy(id = "Password")
    private FluentWebElement passwordField;

    @FindBy(css = "button.btn-login")
    private FluentWebElement loginButton;

    @FindBy(css = "a.btn-forget")
    private FluentWebElement forgetPasswordLink;

    public void login(String userName,String password){
        userNameField.fill().withText(userName);
        passwordField.fill().withText(password);
        loginButton.click();
    }



}
