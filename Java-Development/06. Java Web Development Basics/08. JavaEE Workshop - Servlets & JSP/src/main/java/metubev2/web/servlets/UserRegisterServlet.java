package metubev2.web.servlets;

import metubev2.domain.models.binding.UserRegisterBindingModel;
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

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {

    private final UserService userService;
    private final ModelMapper mapper;

    @Inject
    public UserRegisterServlet(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegisterBindingModel userRegisterBindingModel = (UserRegisterBindingModel) req.getAttribute("model");

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            req.getRequestDispatcher("/jsps/register.jsp")
                    .forward(req, resp);
            return;
        }

        this.userService.registerUser(this.mapper.map(userRegisterBindingModel, UserServiceModel.class));

        resp.sendRedirect("/login");
    }
}