import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test257 {
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
        tester.clickLinkWithText("Announcements");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("admin");
        tester.setHiddenField("page2", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testOnPage() {
        tester.setWorkingForm("classes");
        tester.setTextField("onpage", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='classes']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
