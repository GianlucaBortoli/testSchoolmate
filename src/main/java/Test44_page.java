import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test44_page {
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

        tester.setWorkingForm("terms");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='terms']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
