package p03_employee_info;

import java.util.List;

public interface InfoProvider<T> {
    List<T> getEmployeesByName();

    Iterable<T> getEmployeesBySalary();
}
