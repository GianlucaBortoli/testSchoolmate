import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test283 {
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
        tester.setHiddenField("page", "1 '>" + utils.getMylink()
                + "<br '");
        tester.clickLinkWithText("Users");
        tester.assertMatch("Manage Users");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("admin");
        tester.setHiddenField("page2", "10 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertMatch("Manage Users");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testOnPage() {
        tester.clickLinkWithText("Users");
        tester.setWorkingForm("users");
        tester.setTextField("onpage", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='users']", tester);
        tester.submit();
        tester.assertMatch("Manage Users");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
