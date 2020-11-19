package regapp.web;

import org.modelmapper.ModelMapper;
import regapp.domain.models.EmployeeListViewModel;
import regapp.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class EmployeeListBean implements Serializable {

    private List<EmployeeListViewModel> employees;

    private ModelMapper modelMapper;
    private EmployeeService employeeService;

    public EmployeeListBean() {

    }

    @Inject
    public EmployeeListBean(ModelMapper modelMapper, EmployeeService employeeService) {
        this.modelMapper = modelMapper;
        this.employeeService = employeeService;
        this.employees = this.employeeService.findAllEmployees()
                .stream()
                .map(employeeServiceModel -> this.modelMapper.map(employeeServiceModel, EmployeeListViewModel.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeListViewModel> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<EmployeeListViewModel> employees) {
        this.employees = employees;
    }

    public BigDecimal calculateMoneyNeeded(){
        return this.employeeService.getTotalSum();
    }

    public BigDecimal calculateAverageSalary(){
        return this.employeeService.getAverageSalary();
    }
}
