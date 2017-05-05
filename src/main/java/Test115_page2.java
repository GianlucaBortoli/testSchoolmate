import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.*;

public class Test115_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Students");
        tester.assertMatch("Manage Students");

        tester.setWorkingForm("students");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page2", "2 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='students']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
