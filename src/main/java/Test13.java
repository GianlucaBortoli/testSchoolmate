import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.*;

public class Test13 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Attendance");
        tester.assertMatch("Attendance");
        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Attendance Record");
        tester.setWorkingForm("addattendance");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addattendance']", tester);
        tester.submit();
        tester.assertMatch("Attendance");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "30 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addattendance']", tester);
        tester.submit();
        tester.assertMatch("Attendance");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testSemester() {
        tester.setHiddenField("semester", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addattendance']", tester);
        tester.submit();

        tester.assertMatch("Attendance");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testStudent() {
        tester.setHiddenField("student", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addattendance']", tester);
        tester.submit();
        tester.assertMatch("Attendance");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
