import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test37 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths's Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");
        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");
        tester.clickLinkWithText("Assignments");
        tester.assertMatch("Manage Assignments");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("assignments");
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");
        tester.setWorkingForm("editassignment");
        tester.setHiddenField("page", "2 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editassignment']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("assignments");
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");
        tester.setWorkingForm("editassignment");
        tester.setHiddenField("page2", "5 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editassignment']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testDelete() {
        tester.setWorkingForm("assignments");
        tester.getElementByXPath("//input[@type='checkbox' and @value='9']")
                .setAttribute("value", "1 -- ' />" + getMylink());
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        tester.setWorkingForm("assignments");
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertMatch("Edit Assignment");
        tester.setWorkingForm("editassignment");
        tester.setHiddenField("selectclass", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='editassignment']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
