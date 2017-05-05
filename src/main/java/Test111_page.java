import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test111_page {
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

        tester.setWorkingForm("teachers");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        tester.clickButtonWithText("Edit");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
