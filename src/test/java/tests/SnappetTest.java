package tests;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.omg.CORBA.BAD_CONTEXT;
import pages.blocket.snappet.DashboardPage;
import pages.blocket.snappet.LoginPage;

import static pages.blocket.snappet.DashboardPage.ActivityPeriod.PREVIOUS_WEEK;
import static pages.blocket.snappet.DashboardPage.ActivityPeriod.YESTERDAY;

public class SnappetTest extends BaseTest {
    @Page
    private LoginPage loginPage;

    @Page
    private DashboardPage dashboard;

    @Test
    public void firstTest(){
       loginAsValidUser();
       // String madeExercises = dashboard.getMadeExercises();
        dashboard.selectPeriod(PREVIOUS_WEEK);
        int y =0;
//        https://teacher.snappet.org/V3/85402/#period=Today
//   /V3/85402/


    }

}
