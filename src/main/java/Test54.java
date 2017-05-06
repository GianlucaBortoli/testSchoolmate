import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static common.settings.*;


public class Test54 {
    private WebTester tester;
    private String oldValue = null;

    @Before
    public void prepare(){
        tester = createWebTester();
    }

    @Test
    public void test(){
        loginAsAdmin(tester);
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");
        tester.assertMatch("Manage School Information");
        oldValue = tester.getElementByXPath("html//textarea[@name='sitetext']")
                .getTextContent();
        tester.setTextField("sitetext", oldValue + getMylink());
        tester.clickButtonWithText(" Update ");
        tester.assertMatch("Manage School Information");
        tester.clickLinkWithText("Log Out");
        tester.assertLinkNotPresentWithExactText(getMyLinkName());
    }

    @After
    public void cleanup(){
        if (oldValue != null) {
            loginAsAdmin(tester);
            tester.assertMatch("Manage Classes");
            tester.clickLinkWithText("School");
            tester.assertMatch("Manage School Information");
            tester.setTextField("sitetext", oldValue);
            tester.clickButtonWithText(" Update ");
        }
    }
}
