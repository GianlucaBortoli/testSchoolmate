import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;

public class Test141_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.setWorkingForm("classes");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        tester.clickButtonWithText("Add");

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
