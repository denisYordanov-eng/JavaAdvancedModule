package p03_employee_info;

public class Main {

    public static void main(String[] args) {
        Database<Employee> database = new EmployeeDatabase();
        InfoProvider<Employee> employeeInfo = new EmployeeInfoProvider(database);
        Formatter<Employee> formatter = new ConsoleFormatter();

        String output = formatter.format(employeeInfo.getEmployeesByName());
        System.out.println(output);
    }
}
