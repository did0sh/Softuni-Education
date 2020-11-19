package regapp.service;

import org.modelmapper.ModelMapper;
import regapp.domain.entities.Employee;
import regapp.domain.service.EmployeeServiceModel;
import regapp.repository.EmployeeRepository;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerEmployee(EmployeeServiceModel employeeServiceModel){
        try {
            this.employeeRepository.save(this.modelMapper.map(employeeServiceModel, Employee.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {
        return this.employeeRepository.findAll()
                .stream()
                .map(employee -> this.modelMapper.map(employee, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeEmployee(String id) {
        try {
            this.employeeRepository.removeEmployee(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public BigDecimal getTotalSum() {
        return this.employeeRepository.findAll()
                .stream().map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getAverageSalary() {
        if (this.employeeRepository.findAll().size() <= 0){
            return BigDecimal.ZERO;
        }

        return this.employeeRepository.findAll()
                .stream().map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(this.employeeRepository.findAll().size()), RoundingMode.HALF_DOWN);
    }
}
