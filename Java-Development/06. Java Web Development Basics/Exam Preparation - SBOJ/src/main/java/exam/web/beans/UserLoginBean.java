package exam.web.beans;

import exam.domain.models.binding.UserLoginBindingModel;
import exam.domain.models.service.UserServiceModel;
import exam.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class UserLoginBean implements Serializable {

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

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() throws IOException {
        UserServiceModel userServiceModel =
                this.userService.login(this.modelMapper.map(userLoginBindingModel, UserServiceModel.class));

        if (userServiceModel == null){
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/faces/view/login.xhtml");
            return;
        }

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        httpSession.setAttribute("username", userServiceModel.getUsername());

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("/faces/view/home.xhtml");
    }
}
