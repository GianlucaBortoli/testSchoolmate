import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.createWebTester;
import static common.utils.addSubmitButton;

public class Test293 {
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
        tester.clickLinkWithText("Students");
        tester.assertMatch("Manage Students");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("admin");
        tester.setHiddenField("page2", "2 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertMatch("Manage Students");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testOnPage() {
        tester.clickLinkWithText("Students");
        tester.setWorkingForm("students");
        tester.setTextField("onpage", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='students']", tester);
        tester.submit();
        tester.assertMatch("Manage Students");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
