package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Submit extends TagSupport {
    private String value = "";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<br/><div><input style=\"margin-right:10px\" type = \"reset\" value = \"Cancel\" />";
            out.print(in);
            in = "<input type = \"submit\" value = \"OK\" /></div>";
            out.print(in);
        } catch (IOException e) {
            System.out.println("usertaglib.Submit: " + e);
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