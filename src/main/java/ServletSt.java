import javax.json.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/student")
public class ServletSt extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Получение json из потока
        Map<String, Object> pageVariables = new HashMap<String, Object>();
        pageVariables.put("msg","zdarova");



        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //Готовим ответ на корректность пароля и логина
        resp.setContentType("text/html; charset=UTF-8");
        /*PrintWriter out = resp.getWriter();
        DatabaseHelp dbHelper = new DatabaseHelp();

        //Отправляем в ответ
        out.print(dbHelper.checkUser(username));*/
        resp.getWriter().println(PgGener.instance().getPage("form.html", pageVariables));
    }

    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        JsonReader reader = Json.createReader(req.getInputStream());
        JsonObject nJason = reader.readObject();
        reader.close();

        //String username = nJason.getString('login');
        // String pass = nJason.getString('password');

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        helper dbhelp = new helper();

        //out.println(dbhelp.checkUser((username)));
        //resp.getWriter().println(PageGenerator.instance().getPage("form.html", PageVa));
    }
}
