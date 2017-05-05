import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test126_page2 {
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

        tester.setWorkingForm("teacher");
        tester.setHiddenField("page2", "0 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();

        tester.assertMatch("maths damaths\'s Classes");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
