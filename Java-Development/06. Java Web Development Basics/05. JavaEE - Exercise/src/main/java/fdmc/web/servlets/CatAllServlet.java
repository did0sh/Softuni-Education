package fdmc.web.servlets;

import fdmc.domain.entities.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cats/all")
public class CatAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>All Cats</h1><hr/>");

        Map<String,Cat> cats = ((Map<String, Cat>) req.getSession().getAttribute("cats"));

        if (cats == null){
            writer.println("<h3>There are no cats.</h3><a href=/cats/create>Create some!</a><br/></br>");
        } else {
             cats.forEach((name, cat) -> writer.println(String.format("<a href=\"/cats/profile?catName=%s\">%s</a><br/></br>", name, name)));
        }

        writer.println(String.format("<a href=\"/\">Back to Home</a>"));
    }
}
