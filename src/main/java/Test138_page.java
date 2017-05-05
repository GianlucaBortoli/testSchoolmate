import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test138_page {
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

        tester.setWorkingForm("classes");
        tester.setHiddenField("page", "4 '>" + getMylink() + "<br '");

        tester.clickLinkWithText("Classes");
        tester.assertMatch("student1 dastud1's Classes");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
