import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test76 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
        tester.clickLinkWithText("Grades");
        tester.assertMatch("Grades");
        tester.setWorkingForm("grades");
        tester.checkCheckbox("delete[]");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "2 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='grades']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "3 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='grades']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testDelete() {
        tester.getElementByXPath("//input[@type='checkbox' and @value='1']")
                .setAttribute("value", "1 -- ' />" + getMylink());
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testAssignment() {
        tester.clickButtonWithText("Edit");
        tester.setWorkingForm("editgrade");
        tester.setHiddenField("assignment", "9 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editgrade']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        tester.setHiddenField("selectclass", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='grades']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
