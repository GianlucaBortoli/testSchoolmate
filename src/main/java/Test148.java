import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test148 {
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
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("teacher");
        tester.setHiddenField("page", "2 '>" + utils.getMylink() + "<br '");
        tester.clickLinkWithText("Announcements");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("teacher");
        tester.setHiddenField("page2", "1 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='teacher']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testOnPage() {
        tester.clickLinkWithText("Announcements");
        tester.assertMatch("View Announcements");
        tester.setWorkingForm("announcements");
        tester.setHiddenField("onpage", "3 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='announcements']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
