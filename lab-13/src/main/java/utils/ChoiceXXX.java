package utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static java.lang.String.format;

public class ChoiceXXX {
    public String listxxx[];

    protected class OnlyXXX implements FilenameFilter {

        private String xxx;

        public OnlyXXX(final String xxx) {
            this.xxx = xxx;
        }

        @Override
        public boolean accept(final File file, final String name) {
            return name.endsWith(xxx);
        }
    }

    public ChoiceXXX(final String d, final String xxx) {
        final File dir = new File(d);
        if (dir.exists()) {
            listxxx = dir.list(new OnlyXXX(xxx));
        }
    }

    public static void outputDoc(final File file, final HttpServletResponse response) {
        response.setContentType("application/msword");
        response.addHeader("Content-Disposition", format("attachment; filename=%s", file.getName()));
        response.setContentLength((int)file.length());
        try {
            final FileInputStream in = new FileInputStream(file);
            final BufferedInputStream buf = new BufferedInputStream(in);
            final ServletOutputStream out = response.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1) {
                out.write(readBytes);
            }
            out.close();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
