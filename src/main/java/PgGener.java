import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PgGener {
    private static final String HTML_DIR = "template";

    private static PgGener pageGenerator;
    private final Configuration cfg;

    public static PgGener instance() {
        if (pageGenerator == null)
            pageGenerator = new PgGener();
        return pageGenerator;
    }

    public String getPage(String filename, Map<String, Object> data) {
        Writer stream = new StringWriter();
        try {
            Template template = cfg.getTemplate(HTML_DIR + File.separator + filename);
            template.process(data, stream);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

    private PgGener() {
        cfg = new Configuration();
    }
}



