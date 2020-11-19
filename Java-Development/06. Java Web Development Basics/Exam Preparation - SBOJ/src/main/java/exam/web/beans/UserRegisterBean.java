package exam.web.beans;

import exam.domain.models.binding.UserRegisterBindingModel;
import exam.domain.models.service.UserServiceModel;
import exam.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class UserRegisterBean implements Serializable {

    private UserRegisterBindingModel userRegisterBindingModel;

    private UserService userService;

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

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register() throws IOException {
        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("/faces/view/register.xhtml");
            return;
        }

        this.userService.registerUser(userServiceModel);

        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/faces/view/login.xhtml");
    }
}
