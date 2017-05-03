import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test37_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");

        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");

        tester.clickLinkWithText("Assignments");
        tester.assertMatch("Manage Assignments");

        tester.setWorkingForm("assignments");
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");

        tester.setWorkingForm("editassignment");
        tester.setHiddenField("page2", "5 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editassignment']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
