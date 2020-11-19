package metubev2.web.filters;

import metubev2.domain.models.binding.UserRegisterBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/register")
public class UserRegisterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().toLowerCase().equals("post")) {
            UserRegisterBindingModel userRegisterBindingModel = new UserRegisterBindingModel();
            userRegisterBindingModel.setUsername(request.getParameter("username"));
            userRegisterBindingModel.setPassword(request.getParameter("password"));
            userRegisterBindingModel.setConfirmPassword(request.getParameter("confirmPassword"));
            userRegisterBindingModel.setEmail(request.getParameter("email"));

            request.setAttribute("model", userRegisterBindingModel);
        }

        filterChain.doFilter(request, response);
    }
}
