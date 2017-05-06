import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test161 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Parents");
        tester.assertMatch("Manage Parents");
    }

    @Test
    public void testPage() {
        tester.setWorkingForm("parents");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='parents']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setWorkingForm("parents");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page2", "10 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='parents']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testDelete() {
        tester.setWorkingForm("parents");
        tester.getElementByXPath("//input[@type='checkbox' and @value='1']")
                .setAttribute("value", "1) -- ' />" + getMylink());
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
