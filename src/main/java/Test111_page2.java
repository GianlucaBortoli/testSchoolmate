import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.*;

public class Test111_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Teachers");
        tester.assertMatch("Manage Teachers");

        tester.setWorkingForm("teachers");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page2", "3 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='teachers']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
