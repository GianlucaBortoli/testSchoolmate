/**
 * Created by gian on 10/04/17.
 */

package common;

import net.sourceforge.jwebunit.junit.WebTester;

public class settings {
    public static WebTester createWebTester() {
        WebTester tester = new WebTester();
        tester.setBaseUrl("http://192.168.53.146");
        return tester;
    }
}
