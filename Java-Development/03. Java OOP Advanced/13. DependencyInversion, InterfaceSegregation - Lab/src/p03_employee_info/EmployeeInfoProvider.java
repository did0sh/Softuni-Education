package p03_employee_info;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private DataBase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    @Override
    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
