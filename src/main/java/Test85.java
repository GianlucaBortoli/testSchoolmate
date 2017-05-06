import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test85 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Semesters");
        tester.assertMatch("Manage Semesters");
        tester.setWorkingForm("semesters");
        tester.checkCheckbox("delete[]");
    }

    @Test
    public void testPage() {
        tester.clickButtonWithText("Edit");
        tester.setWorkingForm("editsemester");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='editsemester']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.clickButtonWithText("Edit");
        tester.setWorkingForm("editsemester");
        tester.setHiddenField("page2", "13 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='editsemester']", tester);
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
}
