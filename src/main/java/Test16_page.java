import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test16_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");

        tester.clickLinkWithText("Announcements");
        tester.assertMatch("Manage Announcements");

        tester.clickButtonWithText("Add");
        tester.assertMatch("Add New Announcement");

        tester.setWorkingForm("addannouncement");
        tester.setHiddenField("page", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='addannouncement']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
