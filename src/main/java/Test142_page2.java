import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test142_page2 {
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
        tester.setWorkingForm("student");
        tester.setHiddenField("page2", "5 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();

        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
