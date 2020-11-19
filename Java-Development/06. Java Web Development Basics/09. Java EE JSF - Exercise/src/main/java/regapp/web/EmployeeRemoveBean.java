package regapp.web;

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
public class EmployeeRemoveBean implements Serializable {

    private EmployeeService employeeService;

    public EmployeeRemoveBean() {
    }

    @Inject
    public EmployeeRemoveBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void remove(String id) throws IOException {
        this.employeeService.removeEmployee(id);

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
