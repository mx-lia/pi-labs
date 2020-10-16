package usertaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Sex extends TagSupport {
    private Boolean value = false;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            String in = "<label>Sex:&nbsp&nbsp</label>";
            out.print(in);
            String male = "<input name =\"sex\" type = \"radio\" value=\"male\"/>&nbspMale";
            out.print(male);
            String female = "<input name =\"sex\" type = \"radio\" value=\"female\"/>&nbspFemale";
            out.print(female);
        } catch (IOException e) {
            System.out.println("usertaglib.Sex: " + e);
        }
        return SKIP_BODY;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}