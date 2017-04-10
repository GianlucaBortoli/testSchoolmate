import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gian on 10/04/17.
 */
public class test54 {
    private WebTester tester;
    private String previousValue = null;

    @Before
    public void prepare(){
        tester = new WebTester();
        tester.setBaseUrl("http://192.168.53.146");
    }

    @Test
    public void test(){
        tester.beginAt("index.php");
        tester.setTextField("username", "schoolmate");
        tester.setTextField("password", "schoolmate");
        tester.submit();

        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("School");

        tester.assertMatch("Manage School Information");
        previousValue = tester.getElementByXPath("html//textarea[@name='sitetext']").getTextContent();
        tester.setTextField("sitetext", "original message "
                + "<a href=www.unitn.it>malicious link</a>");
        tester.clickButtonWithText(" Update ");

        tester.assertMatch("Manage School Information");
        tester.clickLinkWithText("Log Out");

        tester.assertLinkNotPresentWithExactText("malicious link");
    }

    @After
    public void cleanup(){
        if (previousValue != null) {
            tester.beginAt("index.php");
            tester.setTextField("username", "schoolmate");
            tester.setTextField("password", "schoolmate");
            tester.submit();

            tester.assertMatch("Manage Classes");
            tester.clickLinkWithText("School");

            tester.assertMatch("Manage School Information");
            tester.setTextField("sitetext", previousValue);
            tester.clickButtonWithText(" Update ");
        }
    }

}
