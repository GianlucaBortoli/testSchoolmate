import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.*;

public class Test11_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");

        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");

        tester.clickLinkWithText("Assignments");
        tester.assertMatch("Manage Assignments");
        tester.setWorkingForm("assignments");

        tester.setWorkingForm("assignments");
        tester.setHiddenField("page2", "4 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='assignments']", tester);
        tester.submit();

        tester.assertMatch("Add New Assignment");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
