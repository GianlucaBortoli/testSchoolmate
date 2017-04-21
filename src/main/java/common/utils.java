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
}
