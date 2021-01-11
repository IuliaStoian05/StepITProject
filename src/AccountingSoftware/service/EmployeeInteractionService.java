package AccountingSoftware.service;

import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;

public interface EmployeeInteractionService {
    Employee addEmployeeAction();
    Integer deleteEmployeeAction();
    Employee updateEmployeeAction();
    Department chooseDepartmentAction();
}
