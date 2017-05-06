import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.*;

public class Test11 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
        tester.clickLinkWithText("Assignments");
        tester.assertMatch("Manage Assignments");
    }

    @Test
    public void testPage() {
        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Assignment");
        tester.setWorkingForm("addassignment");
        tester.setHiddenField("page", "2 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addassignment']", tester);
        tester.submit();
        tester.assertMatch("Add New Assignment");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("assignments");
        tester.setHiddenField("page2", "4 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='assignments']", tester);
        tester.submit();
        tester.assertMatch("Add New Assignment");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        tester.setWorkingForm("assignments");
        tester.setHiddenField("selectclass", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='assignments']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
