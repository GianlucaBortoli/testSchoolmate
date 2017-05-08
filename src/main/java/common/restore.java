package common;

import net.sourceforge.jwebunit.junit.WebTester;

public class restore {
    public static void schoolInfo(WebTester tester) {
        String address = "Via Sommarive Povo";
        String phone = "52365895";
        String numsemesters = "2";
        String numperiods = "5";
        String sitemessage = "Better safe than sorry";
        String sitetext = "This is a login page";

        tester.clickButtonWithText(" Update ");
        tester.setTextField("schooladdress", address);
        tester.setTextField("schoolphone", phone);
        tester.setTextField("numsemesters", numsemesters);
        tester.setTextField("numperiods", numperiods);
        tester.setTextField("sitemessage", sitemessage);
        tester.setTextField("sitetext", sitetext);
        tester.assertMatch("Manage School Information");
    }
}
