import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test93 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Parents");
        tester.assertMatch("Manage Parents");
        tester.setWorkingForm("parents");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='parents']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "22 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='parents']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
