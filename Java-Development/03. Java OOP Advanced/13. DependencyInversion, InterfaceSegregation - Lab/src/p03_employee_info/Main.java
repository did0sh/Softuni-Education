package p03_employee_info;

public class Main {
    public static void main(String[] args) {
        InfoProvider infoProvider = new EmployeeInfoProvider();
        Formatter formatter = new ConsoleFormatter();

        Engine engine = new EngineImpl(infoProvider, formatter);
        engine.run();
    }
}
