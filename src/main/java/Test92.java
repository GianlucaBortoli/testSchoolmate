import common.restore;
import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test92 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.assertMatch("Manage School Information");
        tester.setWorkingForm("info");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='info']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='info']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testAddress() {
        tester.setTextField("schooladdress","''><a href=#>mal</a>");
        tester.clickButtonWithText(" Update ");
        tester.assertMatch("Manage School Information");
        tester.assertLinkNotPresentWithText("mal");
    }

    @Test
    public void testPhone() {
        tester.setTextField("schoolphone", "''><a href=#>a</a>");
        tester.clickButtonWithText(" Update ");
        tester.assertMatch("Manage School Information");
        tester.assertLinkNotPresentWithText("a");
    }

    @Test
    public void testNumPeriods() {
        tester.setTextField("numperiods", "''><a href=#>a</a>");
        tester.clickButtonWithText(" Update ");
        tester.assertMatch("Manage School Information");
        tester.assertLinkNotPresentWithText("a");
    }

    @Test
    public void testNumSemesters() {
        tester.setTextField("numsemesters", "''><a href=#>a</a>");
        tester.clickButtonWithText(" Update ");
        tester.assertMatch("Manage School Information");
        tester.assertLinkNotPresentWithText("a");
    }

    @After
    public void cleanup() {
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.assertMatch("Manage School Information");
        tester.setWorkingForm("info");
        restore.schoolInfo(tester);
    }
}
