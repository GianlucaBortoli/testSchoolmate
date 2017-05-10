import common.utils;
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
        utils.loginAsTeacher(tester);
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
        try {
            tester.setWorkingForm("assignments");
            tester.checkCheckbox("delete[]");
            tester.clickButtonWithText("Edit");
            tester.assertMatch("Edit Assignment");
            tester.setWorkingForm("editassignment");
            tester.setHiddenField("page", "2 '>" + utils.getMylink()
                    + "<br '");
            addSubmitButton("//form[@name='editassignment']", tester);
            tester.submit();
        } catch (java.lang.AssertionError err) {
            System.out.println("...");
            System.out.println(err);
        }
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        try {
            tester.setWorkingForm("assignments");
            tester.checkCheckbox("delete[]");
            tester.clickButtonWithText("Edit");
            tester.assertMatch("Edit Assignment");
            tester.setWorkingForm("editassignment");
            tester.setHiddenField("page2", "5 '>" + utils.getMylink()
                    + "<br '");
            addSubmitButton("//form[@name='editassignment']", tester);
            tester.submit();
        } catch (java.lang.AssertionError err) {
            System.out.println("...");
        }
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testDelete() {
        try {
            tester.setWorkingForm("assignments");
            tester.getElementByXPath("//input[@type='checkbox' and @value='9']")
                    .setAttribute("value", "1 -- ' />" + utils.getMylink());
            tester.checkCheckbox("delete[]");
            tester.clickButtonWithText("Edit");
            tester.assertMatch("Edit Assignment");
        } catch (java.lang.AssertionError err) {
            System.out.println("...");
        }
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        try {
            tester.setWorkingForm("assignments");
            tester.checkCheckbox("delete[]");
            tester.clickButtonWithText("Edit");
            tester.assertMatch("Edit Assignment");
            tester.setWorkingForm("editassignment");
            tester.setHiddenField("selectclass", "1 '>" + utils.getMylink()
                    + "<br '");
            addSubmitButton("//form[@name='editassignment']", tester);
            tester.submit();
        } catch (java.lang.AssertionError err) {
            System.out.println("...");
        }
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
