package common;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.InputElementFactory;
import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.htmlunit.HtmlUnitElementImpl;
import net.sourceforge.jwebunit.junit.WebTester;
import org.xml.sax.helpers.AttributesImpl;

public class utils {
    public static void addSubmitButton(String formXpath, WebTester t) {
        IElement el = t.getElementByXPath(formXpath);
        DomElement form = ((HtmlUnitElementImpl)el).getHtmlElement();
        InputElementFactory factory = InputElementFactory.instance;
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "", "type", "", "submit");
        HtmlElement submit = factory.createElement(form.getPage(), "input", attrs);
        form.appendChild(submit);
    }

    public static String getMylink() {
        return " <a href=\"www.unitn.it\">" +
                getMyLinkName() +
                "</a>";
    }

    public static String getMyLinkName() {
        return "mylink";
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

    public static void loginAsStudent(WebTester t) {
        t.beginAt("index.php");
        t.setTextField("username", "student1");
        t.setTextField("password", "student1");
        t.submit();
    }

    public static void loginAsParent(WebTester t) {
        t.beginAt("index.php");
        t.setTextField("username", "parent1");
        t.setTextField("password", "parent1");
        t.submit();
    }
}
