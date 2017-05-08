import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test141 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.setWorkingForm("classes");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + utils.getMylink() + "<br '");
        tester.clickButtonWithText("Add");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "0 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='classes']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
