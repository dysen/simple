package pages.blocket.snappet;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static pages.blocket.snappet.DashboardPage.ActivityPeriod.YESTERDAY;

@Wait
@PageUrl("/V3/85402/Teach#period=Today")
public class DashboardPage extends FluentPage {

    private static final String MADE_EXSERCISES_SEELECTOR = "div.stat-block";
//    @FindBy(css = "div.stat-block")
//    private FluentWebElement madeExercises;

    public String getMadeExercises() {
        await().atMost(5, TimeUnit.SECONDS).until(el(MADE_EXSERCISES_SEELECTOR)).displayed();

        return el(MADE_EXSERCISES_SEELECTOR).text();
    }


    public DashboardPage selectPeriod(ActivityPeriod period) {

        $("a.btn.btn-txt.more-txt-l.btn-more").click();
//        $("a.btn-more").click();
//        await().atMost(5, TimeUnit.SECONDS).until($("ul.popover-list  li a")).size(4);
        FluentList<FluentWebElement> periods = $("ul.popover-list  li a");
        FluentWebElement fluentWebElement = periods
                .stream()
                .filter(item -> item.text().equalsIgnoreCase(period.toString()))
                .findFirst()
                .get();
        fluentWebElement.click();
        //.click();
int o = 0;

//        el("ul.popover-list").fillSelect().withText(period.toString());


        return this;
    }

    public enum ActivityPeriod {
        TODAY("Today"),
        YESTERDAY("Yesterday"),
        THIS_WEEK("This week"),
        PREVIOUS_WEEK("Previous Week");


        private String periodValue;

        ActivityPeriod(final String period) {
            this.periodValue = period;
        }

        public String toString() {
            return this.periodValue;
        }
    }

}
