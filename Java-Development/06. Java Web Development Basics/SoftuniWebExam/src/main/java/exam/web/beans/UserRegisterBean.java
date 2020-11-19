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

@Named
@RequestScoped
public class UserRegisterBean {

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
        if (!this.userRegisterBindingModel.getPassword().equals(this.userRegisterBindingModel.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match!");
        }

        if (!this.userService.registerUser(this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class))) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/view/login.xhtml");
    }
}
