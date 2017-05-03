import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test63_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Teachers");
        tester.assertMatch("Manage Teachers");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Teacher");

        tester.setWorkingForm("addteacher");
        tester.setHiddenField("page2", "16 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addteacher']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
