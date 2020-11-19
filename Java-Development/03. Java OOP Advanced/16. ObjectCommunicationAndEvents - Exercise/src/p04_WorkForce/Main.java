package p04_WorkForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Map<String, Employee> employeeMap = new LinkedHashMap<>();
        JobRepository repo = new JobRepository();
        Job job = null;

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split(" ");

            switch (Commands.valueOf(info[0].toUpperCase())){
                case STANDARTEMPLOYEE:
                    executeStandartEmployee(employeeMap,info);
                    break;
                case PARTTIMEEMPLOYEE:
                    executePartTimeEmployee(employeeMap, info);
                    break;
                case JOB:
                   executeJob(employeeMap, repo, info);
                    break;
                case PASS:
                    executePass(repo);
                    break;
                case STATUS:
                    executeStatus(repo);
                    break;
            }
        }
    }

    private static void executeStatus(JobRepository repository) {
        repository.status();
    }

    private static void executePass(JobRepository repository) {
        repository.pass();
    }

    private static void executeJob(Map<String, Employee> employeeMap, JobRepository repo, String[] info) {
        Employee currEmpl = employeeMap.get(info[3]);
        Job job = new Job(info[1], Integer.parseInt(info[2]), currEmpl);
        repo.addJob(job);
    }

    private static void executePartTimeEmployee(Map<String, Employee> employeeMap, String[] info) {
        Employee employee = new PartTimeEmployee(info[1]);
        employeeMap.put(employee.getName(), employee);
    }

    private static void executeStandartEmployee(Map<String, Employee> employeeMap, String[] info) {
        Employee employee = new StandartEmployee(info[1]);
        employeeMap.put(employee.getName(), employee);
    }
}
