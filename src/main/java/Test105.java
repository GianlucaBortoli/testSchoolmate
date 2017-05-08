import common.restore;
import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test105 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("admin");
        tester.setHiddenField("page", "1 '>" + utils.getMylink() + "<br '");
        tester.setHiddenField("logout", "0");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testMessage() {
        tester.clickLinkWithText("School");
        tester.assertMatch("Manage School Information");
        tester.setWorkingForm("info");
        tester.setTextField("sitemessage", utils.getMylink());
        tester.assertMatch("Manage School Information");
        tester.clickButtonWithText(" Update ");
        tester.clickLinkWithText("Log Out");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
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
