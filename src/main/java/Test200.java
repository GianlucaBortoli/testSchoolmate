import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test200 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsParent(tester);
        tester.assertMatch("Students of parent1 daparent1");
        tester.clickLinkWithText("student1 dastud1");
        tester.assertMatch("student1 dastud1's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.setWorkingForm("student");
        tester.assertMatch("Class Settings");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "4 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "2 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        tester.setHiddenField("selectclass", "1 '>" + utils.getMylink()
                + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
