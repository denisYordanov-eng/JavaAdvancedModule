package p03_employee_info;

import java.util.List;

public interface Database<T>{
    List<T> readEmployees();
}
