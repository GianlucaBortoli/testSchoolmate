import common.restore;
import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test234 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Terms");
        tester.assertMatch("Manage Terms");
    }

    @Test
    public void testTerm() {
        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Term");
        tester.setWorkingForm("addterm");
        tester.setTextField("title", "t<a href=>a</a>");
        tester.setTextField("startdate", "2017-06-01");
        tester.setTextField("enddate", "2017-06-03");
        tester.clickButtonWithText("Add Term");
        tester.assertMatch("Manage Terms");
        tester.assertLinkNotPresentWithExactText("a");
    }

    @After
    public void cleanup() {
        utils.loginAsAdmin(tester);
        restore.terms(tester);
    }
}
