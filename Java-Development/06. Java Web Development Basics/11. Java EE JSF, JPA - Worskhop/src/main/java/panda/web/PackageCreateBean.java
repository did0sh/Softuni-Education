package panda.web;

import org.modelmapper.ModelMapper;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.domain.models.service.PackageServiceModel;
import panda.domain.models.service.UserServiceModel;
import panda.service.PackageService;
import panda.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class PackageCreateBean implements Serializable {

    private List<String> users;
    private PackageCreateBindingModel packageCreateBindingModel;

    private UserService userService;
    private PackageService packageService;
    private ModelMapper modelMapper;

    public PackageCreateBean() {
    }

    @Inject
    public PackageCreateBean(UserService userService, PackageService packageService, ModelMapper modelMapper) {
        this.userService = userService;
        this.packageService = packageService;
        this.modelMapper = modelMapper;
        this.packageCreateBindingModel = new PackageCreateBindingModel();
        this.initUsers();
    }

    private void initUsers(){
       this.users = this.userService.findAllUsers()
                .stream()
                .map(UserServiceModel::getUsername)
                .collect(Collectors.toList());

    }

    public List<String> getUsers() {
        return this.users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public PackageCreateBindingModel getPackageCreateBindingModel() {
        return this.packageCreateBindingModel;
    }

    public void setPackageCreateBindingModel(PackageCreateBindingModel packageCreateBindingModel) {
        this.packageCreateBindingModel = packageCreateBindingModel;
    }

    public void create() throws IOException {
        PackageServiceModel packageServiceModel =
                this.modelMapper.map(this.packageCreateBindingModel, PackageServiceModel.class);

        packageServiceModel.setRecipient(this.userService.findByUsername(this.packageCreateBindingModel.getRecipient()));

        this.packageService.createPackage(packageServiceModel);

        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/faces/view/home.xhtml");
    }
}
