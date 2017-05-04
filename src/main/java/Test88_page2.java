import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test88_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsStudent(tester);
        tester.assertMatch("student1 dastud1's Classes");

        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");

        tester.setWorkingForm("classes");
        tester.setHiddenField("page2", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='classes']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
