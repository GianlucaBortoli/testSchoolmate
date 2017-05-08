import common.utils;
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
        utils.loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.setWorkingForm("teacher");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "2 '>" + utils.getMylink() + "<br '");
        tester.clickLinkWithText("Classes");
        tester.assertMatch("maths damaths\'s Classes");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "0 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();
        tester.assertMatch("maths damaths\'s Classes");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
