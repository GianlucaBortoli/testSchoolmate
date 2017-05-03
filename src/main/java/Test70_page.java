import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test70_page {
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

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Student");

        tester.setWorkingForm("addstudent");
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addstudent']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
