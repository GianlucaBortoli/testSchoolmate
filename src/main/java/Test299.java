import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.createWebTester;
import static common.utils.addSubmitButton;

public class Test299 {
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
        tester.clickLinkWithText("Registration");
        tester.assertMatch("Registration");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("admin");
        tester.setHiddenField("page2", "26 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertMatch("Registration");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
