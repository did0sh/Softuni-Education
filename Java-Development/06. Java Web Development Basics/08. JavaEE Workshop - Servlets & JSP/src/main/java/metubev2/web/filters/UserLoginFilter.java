package metubev2.web.filters;

import metubev2.domain.models.binding.UserLoginBindingModel;
import metubev2.domain.models.binding.UserRegisterBindingModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class UserLoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().toLowerCase().equals("post")) {
            UserLoginBindingModel userLoginBindingModel = new UserLoginBindingModel();
            userLoginBindingModel.setUsername(request.getParameter("username"));
            userLoginBindingModel.setPassword(request.getParameter("password"));

            request.setAttribute("loginModel", userLoginBindingModel);
        }

        filterChain.doFilter(request, response);
    }
}
