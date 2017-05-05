import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test147_page {
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

        tester.setWorkingForm("student");
        tester.setHiddenField("page", "4 '>" + getMylink() + "<br '");
        tester.clickLinkWithText("Announcements");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
