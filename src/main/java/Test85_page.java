import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test85_page {
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

        tester.setWorkingForm("semesters");
        tester.checkCheckbox("delete[]");
        tester.clickButtonWithText("Edit");

        tester.setWorkingForm("editsemester");
        tester.setHiddenField("page", "1 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='editsemester']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
