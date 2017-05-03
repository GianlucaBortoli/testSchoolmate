import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test41_delete {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Announcements");
        tester.assertMatch("Manage Announcements");

        tester.setWorkingForm("announcements");
        tester.checkCheckbox("delete[]");
        tester.getElementByXPath("//input[@type='checkbox' and @value='1']")
                .setAttribute("value", "1 -- ' />" + getMylink());
        tester.checkCheckbox("delete[]");

        tester.clickButtonWithText("Edit");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
