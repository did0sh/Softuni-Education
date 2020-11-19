package panda.web;

import org.modelmapper.ModelMapper;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.service.UserServiceModel;
import panda.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class UserLoginBean {

    private UserService userService;
    private ModelMapper modelMapper;
    private UserLoginBindingModel userLoginBindingModel;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return this.userLoginBindingModel;
    }

    public void login() throws IOException {
        UserServiceModel userServiceModel =
                this.userService.loginUser(this.modelMapper.map(userLoginBindingModel, UserServiceModel.class));

        if (userServiceModel == null){
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/faces/view/login.xhtml");
            return;
        }

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        httpSession.setAttribute("username", userServiceModel.getUsername());
        httpSession.setAttribute("role", userServiceModel.getRole());

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("/faces/view/home.xhtml");
    }
}
