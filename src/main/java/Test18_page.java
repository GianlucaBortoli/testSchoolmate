import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test18_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Users");
        tester.assertMatch("Manage Users");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New User");

        tester.setWorkingForm("adduser");
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='adduser']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
