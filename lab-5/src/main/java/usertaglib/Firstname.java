package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Firstname extends TagSupport {
    private String value = "";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<label>Firstname&nbsp &nbsp</label>"
                    + "<input name =\"firstname\" type = \"text\" width = \"150\" maxlength= \"30\" placeholder = \"Firstname\" ";
            out.print(in + (this.value.equals("") ? "><br/>" : "value =\"" + this.value + "\"><br/>"));
        } catch (IOException e) {
            System.out.println("usertaglib.Firstname: " + e);
        }
        return SKIP_BODY;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}