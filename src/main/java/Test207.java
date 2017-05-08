import common.restore;
import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test207 {
    private WebTester tester;
    private String injection = "' union select concat(coursename,'" +
            utils.getMylink() +
            "') from courses where courseid = '1";

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void testCourseName() {
        utils.loginAsTeacher(tester);
        tester.assertMatch("maths damaths's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
        tester.clickLinkWithText("Assignments");
        tester.setWorkingForm("teacher");
        tester.setHiddenField("selectclass", injection);
        tester.clickLinkWithText("Assignments");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @After
    public void cleanup() {
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.setWorkingForm("info");
        restore.schoolInfo(tester);
    }
}
