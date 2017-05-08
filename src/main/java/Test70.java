import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test70 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Students");
        tester.assertMatch("Manage Students");
        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Student");
        tester.setWorkingForm("addstudent");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addstudent']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "20 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addstudent']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
