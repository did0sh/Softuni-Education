package P04_DetailPrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Deyan");
        Employee manager = new Manager("Gosho", new ArrayList<String>(){{
            add("doc1");
            add("doc2");
            add("doc3");
        }});

        Employee dev = new Developer("Pesho", new ArrayList<String>(){{
            add("task1");
            add("task2");
            add("task3");
        }});

        DetailsPrinter printer = new DetailsPrinter(new ArrayList<Employee>(){{
            add(employee);
            add(manager);
            add(dev);
        }});

        printer.printDetails();
    }
}
