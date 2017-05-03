import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test19_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Terms");
        tester.assertMatch("Manage Terms");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Term");

        tester.setWorkingForm("addterm");
        tester.setHiddenField("page2", "8 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addterm']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
