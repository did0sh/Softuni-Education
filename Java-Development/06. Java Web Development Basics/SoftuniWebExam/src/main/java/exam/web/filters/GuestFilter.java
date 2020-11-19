package exam.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({
        "/faces/view/home.xhtml",
        "/faces/view/schedule.xhtml",
        "/faces/view/print.xhtml",
        "/faces/view/details.xhtml",
        "/faces/view/logout.xhtml"
})
public class GuestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if (session.getAttribute("username") == null) {
            resp.sendRedirect("/faces/view/index.xhtml");
        } else {
            chain.doFilter(req, resp);
        }
    }
}
