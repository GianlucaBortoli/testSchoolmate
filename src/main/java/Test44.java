import common.utils;
import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test44 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        utils.loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Terms");
        tester.assertMatch("Manage Terms");
        tester.setWorkingForm("terms");
        tester.checkCheckbox("delete[]");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='terms']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "6 '>" + utils.getMylink() + "<br '");
        addSubmitButton("//form[@name='terms']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }

    @Test
    public void testDelete() {
        tester.getElementByXPath("//input[@type='checkbox' and @value='1']")
                .setAttribute("value", "1 -- ' />" + utils.getMylink());
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");
        tester.assertLinkNotPresentWithText(utils.getMyLinkName());
    }
}
