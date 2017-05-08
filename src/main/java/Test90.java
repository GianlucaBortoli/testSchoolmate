import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test90 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsTeacher(tester);
        tester.assertMatch("maths damaths's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
        tester.setWorkingForm("teacher");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "2 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();
        tester.assertMatch("Students");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "8 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();
        tester.assertMatch("Students");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
