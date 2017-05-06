import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test92 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.assertMatch("Manage School Information");
        tester.setWorkingForm("info");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='info']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='info']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
