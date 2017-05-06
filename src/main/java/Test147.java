import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test147 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsStudent(tester);
        tester.assertMatch("student1 dastud1's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("student");
        tester.setHiddenField("page", "4 '>" + getMylink() + "<br '");
        tester.clickLinkWithText("Announcements");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("student");
        tester.setHiddenField("page2", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testOnPage() {
        tester.clickLinkWithText("Announcements");
        tester.assertMatch("View Announcements");
        tester.setWorkingForm("announcements");
        tester.setHiddenField("onpage", "2 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='announcements']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
