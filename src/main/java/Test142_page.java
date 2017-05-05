import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test142_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsParent(tester);
        tester.assertMatch("Students of parent1 daparent1");

        tester.clickLinkWithText("student1 dastud1");
        tester.assertMatch("student1 dastud1's Classes");

        tester.selectOption("semester", "SecondSemester");
        tester.setWorkingForm("classes");
        tester.setHiddenField("page", "5 '>" + getMylink() + "<br '");

        tester.clickLinkWithText("Classes");
        tester.assertMatch("student1 dastud1's Classes");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
