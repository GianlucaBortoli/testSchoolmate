import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test76_delete {
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

        tester.clickLinkWithText("Grades");
        tester.assertMatch("Grades");

        tester.setWorkingForm("grades");
        tester.checkCheckbox("delete[]");
        tester.getElementByXPath("//input[@type='checkbox' and @value='1']")
                .setAttribute("value", "1 -- ' />" + getMylink());
        tester.checkCheckbox("delete[]");

        tester.clickButtonWithText("Edit");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
