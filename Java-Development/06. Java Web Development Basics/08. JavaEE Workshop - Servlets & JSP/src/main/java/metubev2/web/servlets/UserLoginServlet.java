package metubev2.web.servlets;

import metubev2.domain.models.binding.UserLoginBindingModel;
import metubev2.domain.models.service.UserServiceModel;
import metubev2.service.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private final UserService userService;
    private final ModelMapper mapper;

    @Inject
    public UserLoginServlet(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLoginBindingModel userLoginBindingModel = (UserLoginBindingModel) req.getAttribute("loginModel");

        if (!this.userService.loginUser(this.mapper.map(userLoginBindingModel, UserServiceModel.class))){
            req.getRequestDispatcher("/jsps/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute("username", userLoginBindingModel.getUsername());
        resp.sendRedirect("/home");
    }
}
