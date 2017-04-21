/**
 * Created by gian on 10/04/17.
 */

package common;

import net.sourceforge.jwebunit.junit.WebTester;

public class settings {
    public static String getMylink() {
        return " <a href=\"www.unitn.it\">" +
                getMyLinkName() +
                "</a>";
    }

    public static String getMyLinkName() {
        return "mylink";
    }

    public static WebTester createWebTester() {
        WebTester tester = new WebTester();
        tester.setBaseUrl("http://192.168.53.146");
        return tester;
    }

    public static void loginAsAdmin(WebTester t) {
        t.beginAt("index.php");
        t.setTextField("username", "test");
        t.setTextField("password", "test");
        t.submit();
    }

    public static void loginAsTeacher(WebTester t) {
        t.beginAt("index.php");
        t.setTextField("username", "maths");
        t.setTextField("password", "maths");
        t.submit();
    }
}
