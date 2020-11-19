package p04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        Map<String, List<Employee>> items = new HashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            switch (tokens.length){
                case 4:
                    Employee employee = new Employee(name,salary,position,department);
                    items = addToMap(items, employee, department);
                    break;

                case 5:
                    try {
                        int age = Integer.parseInt(tokens[4]);
                        Employee employee1 = new Employee(name,salary,position,department,age);
                        items = addToMap(items, employee1, department);
                    } catch (Exception ex){
                        String email = tokens[4];
                        Employee employee1 = new Employee(name,salary,position,department,email);
                        items = addToMap(items, employee1, department);
                    }
                    break;
                case 6:
                    int age = Integer.parseInt(tokens[5]);
                    String email = tokens[4];
                    Employee employee1 = new Employee(name,salary,position,department, email,age);
                    items = addToMap(items, employee1, department);
                    break;
            }
        }

        items.entrySet().stream()
                .sorted((kv1,kv2) -> {
            double sumSalaryKV1 = kv1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            double sumSalaryKV2 = kv2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            return Double.compare(sumSalaryKV2, sumSalaryKV1);
                })
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();
                    result.append(String.format("Highest Average Salary: %s", d.getKey())).append(System.lineSeparator());

                    d.getValue().stream().sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(employee -> result.append(String.format("%s %.2f %s %d", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()))
                            .append(System.lineSeparator()));

                    System.out.print(result.toString());
                });
    }

    private static Map<String, List<Employee>> addToMap(Map<String, List<Employee>> items, Employee employee, String department) {
        if (!items.containsKey(department)){
            items.put(department, new ArrayList<>());
        }
        items.get(department).add(employee);

        return items;
    }

}
