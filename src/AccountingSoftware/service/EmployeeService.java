package AccountingSoftware.service;

import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;

public interface EmployeeService {

    void listEmployees();
    void addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    void updateEmployee(Employee employee);
    Double calculateAverageSalary();
    Double calculateAverageSalaryByDepartment(Department department);
    String showTheMostExpensiveEmployees();
    String showTheMostLoyalEmployees();
}
