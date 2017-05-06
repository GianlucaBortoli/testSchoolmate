import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;
import static common.utils.addSubmitButton;

public class Test165 {
    private WebTester tester;

    @Before
    public void prepare() {
        tester = createWebTester();
        loginAsStudent(tester);
        tester.assertMatch("student1 dastud1's Classes");
        tester.setWorkingForm("student");
    }

    @Test
    public void testPage() {
        tester.setHiddenField("page", "4 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testPageTwo() {
        tester.setHiddenField("page2", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }

    @Test
    public void testSelectClass() {
        tester.setHiddenField("selectclass", "1 '>" + getMylink()
                + "<br '");
        addSubmitButton("//form[@name='student']", tester);
        tester.submit();
        tester.assertLinkNotPresentWithText(getMyLinkName());
    }
}
