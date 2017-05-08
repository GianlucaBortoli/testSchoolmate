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
        tester.setTextField("title", "<a href>t</a>");
        tester.setTextField("startdate", "1");
        tester.setTextField("enddate", "2");
        tester.clickButtonWithText("Add Term");
        tester.clickLinkWithText("Semesters");
        tester.clickButtonWithText("Add");
        tester.setWorkingForm("addsemester");
        tester.setTextField("title", "a");
        tester.setTextField("startdate", "1");
        tester.setTextField("middate", "2");
        tester.setTextField("enddate", "3");
        tester.selectOption("term", "t");
        tester.clickButtonWithText("Add Semester");
        tester.assertMatch("Manage Semesters");
        tester.assertLinkNotPresentWithExactText("t");
    }

    @After
    public void cleanup() {
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.setWorkingForm("info");
        restore.schoolInfo(tester);
    }
}
