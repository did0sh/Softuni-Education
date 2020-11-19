package panda.web;

import org.modelmapper.ModelMapper;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.service.UserServiceModel;
import panda.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserRegisterBean {

    private UserService userService;
    private UserRegisterBindingModel userRegisterBindingModel;
    private ModelMapper modelMapper;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userRegisterBindingModel = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return this.userRegisterBindingModel;
    }

    public void register() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            context.redirect("/faces/view/register.xhtml");
            return;
        }

        UserServiceModel userServiceModel =
                this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        this.userService.registerUser(userServiceModel);


        context.redirect("/faces/view/login.xhtml");
    }
}
