import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test138 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsStudent(tester);
        tester.assertMatch("student1 dastud1's Classes");
        tester.selectOption("semester", "SecondSemester");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("classes");
        tester.setHiddenField("page", "4 '>" + getMylink() + "<br '");
        tester.clickLinkWithText("Classes");
        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("student");
        tester.setHiddenField("page2", "0 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
