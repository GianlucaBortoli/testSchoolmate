import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test126 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.setWorkingForm("teacher");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "2 '>" + getMylink() + "<br '");
        tester.clickLinkWithText("Classes");
        tester.assertMatch("maths damaths\'s Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "0 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();
        tester.assertMatch("maths damaths\'s Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
