import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test138_page2 {
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

        tester.setWorkingForm("student");
        tester.setHiddenField("page2", "0 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();

        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
