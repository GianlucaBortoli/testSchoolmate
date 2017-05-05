import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test115_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Students");
        tester.assertMatch("Manage Students");

        tester.setWorkingForm("students");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        tester.clickButtonWithText("Edit");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
