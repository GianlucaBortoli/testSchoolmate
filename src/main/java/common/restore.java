package common;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;
import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;
import org.xml.sax.helpers.AttributesImpl;

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
        tester.clickButtonWithText(" Update ");
    }

    public static void terms(WebTester tester) {
        tester.assertMatch("Manage Classes");
        tester.clickLinkWithText("Terms");
        tester.setWorkingForm("terms");
        // click the checkbox
        tester.clickElementByXPath(
                "/html/body/table[2]/tbody/tr[2]/td[3]/table/tbody/tr/td/table[1]/tbody/tr/td/form/table/tbody/tr[6]/td[1]/input");
        // get the hidden delete field
        IElement element = tester.getElementByXPath(
                "/html/body/table[2]/tbody/tr[2]/td[3]/table/tbody/tr/td/table[1]/tbody/tr/td/form/input[7]");
        element.setAttribute("value", "1");
        // add button to form
        addSubmitButton(tester,
                "/html/body/table[2]/tbody/tr[2]/td[3]/table/tbody/tr/td/table[1]/tbody/tr/td/form");
        tester.submit();
    }

    private static void addSubmitButton(WebTester tester, String xpath) {
        IElement element = tester.getElementByXPath(xpath);
        DomElement form = ((HtmlUnitElementImpl)element).getHtmlElement();
        InputElementFactory factory = InputElementFactory.instance;
        AttributesImpl attributes = new AttributesImpl();
        attributes.addAttribute("", "", "type", "", "submit");
        attributes.addAttribute("", "", "onclick", "", "document.terms.deleteterm.value=1;");
        attributes.addAttribute("", "", "value", "", "Delete");
        HtmlElement submit = factory.createElement(form.getPage(), "input", attributes);
        form.appendChild(submit);
    }
}
