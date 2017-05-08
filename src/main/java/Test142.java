import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test142 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsParent(tester);
        tester.assertMatch("Students of parent1 daparent1");
        tester.clickLinkWithText("student1 dastud1");
        tester.assertMatch("student1 dastud1's Classes");
        tester.selectOption("semester", "SecondSemester");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("classes");
        tester.setHiddenField("page", "5 '>" + utils.getMylink() + "<br '");
        tester.clickLinkWithText("Classes");
        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("student");
        tester.setHiddenField("page2", "5 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testStudent() {
        tester.setWorkingForm("student");
        tester.setTextField("student", "1 -- ' />" + utils.getMylink());
        tester.clickLinkWithExactText("Classes");
        tester.assertMatch("student1 dastud1's Classes");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
