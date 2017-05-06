import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test105 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void testPage() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.setWorkingForm("admin");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        tester.setHiddenField("logout", "0");
        addSubmitButton("//form[@name='admin']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
