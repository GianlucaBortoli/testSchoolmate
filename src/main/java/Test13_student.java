import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test13_student {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Attendance");
        tester.assertMatch("Attendance");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Attendance Record");

        tester.setWorkingForm("addattendance");
        tester.setHiddenField("student", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addattendance']", tester);
        tester.submit();

        tester.assertMatch("Attendance");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
