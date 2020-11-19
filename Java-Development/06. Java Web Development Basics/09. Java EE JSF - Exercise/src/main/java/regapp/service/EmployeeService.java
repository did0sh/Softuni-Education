package regapp.service;

import regapp.domain.entities.Employee;
import regapp.domain.models.EmployeeListViewModel;
import regapp.domain.service.EmployeeServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    boolean registerEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAllEmployees();

    boolean removeEmployee(String id);

    BigDecimal getTotalSum();

    BigDecimal getAverageSalary();
}
