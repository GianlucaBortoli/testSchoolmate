import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test41 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Announcements");
        tester.assertMatch("Manage Announcements");
        tester.setWorkingForm("announcements");
        tester.checkCheckbox("delete[]");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='announcements']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "4 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='announcements']", tester);
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
