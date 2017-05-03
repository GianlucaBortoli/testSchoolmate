import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test37_selectclass {
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
        tester.checkCheckbox("delete[]", "8");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");

        tester.setWorkingForm("editassignment");
        tester.setHiddenField("selectclass", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editassignment']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
