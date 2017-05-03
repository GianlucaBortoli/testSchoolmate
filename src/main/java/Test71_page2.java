import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test71_page2 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Semesters");
        tester.assertMatch("Manage Semesters");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Semester");

        tester.setWorkingForm("addsemester");
        tester.setHiddenField("page2", "5 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addsemester']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
