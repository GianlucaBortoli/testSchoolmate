import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test76_page {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
    }

    @Test
    public void test() {
        loginAsTeacher(tester);
        tester.assertMatch("maths damaths\'s Classes");
        tester.selectOption("semester", "SecondSemester");
        tester.selectOption("semester", "FirstSemester");

        tester.clickLinkWithText("sec_test");
        tester.assertMatch("Class Settings");

        tester.clickLinkWithText("Grades");
        tester.assertMatch("Grades");

        tester.setWorkingForm("grades");
        tester.checkCheckbox("delete[]");
        tester.setHiddenField("page", "2 '>" + getMylink() + "<br '");
        addSubmitButton("//form[@name='grades']", tester);
        tester.submit();

        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
