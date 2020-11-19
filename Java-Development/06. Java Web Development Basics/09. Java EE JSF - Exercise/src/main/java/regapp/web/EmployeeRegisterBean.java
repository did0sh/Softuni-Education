package regapp.web;

import org.modelmapper.ModelMapper;
import regapp.domain.models.EmployeeRegisterBindingModel;
import regapp.domain.service.EmployeeServiceModel;
import regapp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class EmployeeRegisterBean implements Serializable {

    private EmployeeRegisterBindingModel employeeRegisterBindingModel;
    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public EmployeeRegisterBean() {
        this.employeeRegisterBindingModel = new EmployeeRegisterBindingModel();
    }

    @Inject
    public EmployeeRegisterBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this();
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    public EmployeeRegisterBindingModel getEmployeeRegisterBindingModel() {
        return this.employeeRegisterBindingModel;
    }

    public void setEmployeeRegisterBindingModel(EmployeeRegisterBindingModel employeeRegisterBindingModel) {
        this.employeeRegisterBindingModel = employeeRegisterBindingModel;
    }

    public void register() throws IOException {
        this.employeeService
                .registerEmployee(this.modelMapper
                        .map(employeeRegisterBindingModel, EmployeeServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
