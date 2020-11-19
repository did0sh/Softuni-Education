package p03_employee_info;

public class EngineImpl implements Engine {

    private InfoProvider employeeInfo;
    private Formatter formatter;

    public EngineImpl(InfoProvider employeeInfo, Formatter formatter) {
        this.employeeInfo = employeeInfo;
        this.formatter = formatter;
    }

    @Override
    public void run(){
        String output = this.formatter.format(this.employeeInfo.getEmployeesByName());
        System.out.print(output);
    }
}
