package pages.blocket;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;

@PageUrl("https://www.blocket.se/")
public class StartPage extends FluentPage {

    @Page
    private JobPage jobPage;

    @Page
    private ApartmentPage apartmentPage;

    @Page
    private VehiclePage vehiclePage;

    @Page
    private MessagingPage messagingPage;

    @Page
    private LoginPage loginPage;

    @Page
    private CustomerService customerService;

    public StartPage toJobPage() {
        jobPage.go();
        return this;
    }

    public StartPage toApartmentPage(){
        apartmentPage.go();
        return this;
    }

    public StartPage toVehiclePage(){
        vehiclePage.go();
        return this;
    }

    public StartPage toMessagesPage(){
        messagingPage.go();
        return this;
    }

    public StartPage toLoginPage(){
        loginPage.go();
        return this;
    }
}