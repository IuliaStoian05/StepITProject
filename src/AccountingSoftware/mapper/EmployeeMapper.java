package AccountingSoftware.mapper;

import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static AccountingSoftware.util.Constants.COMMA_DELIMITER;

public class EmployeeMapper {
    public Employee getEmployeeFromCsvLine(String csvLine) {
        if (csvLine != null && csvLine.length() > 0) {
            String[] values = csvLine.split(COMMA_DELIMITER);
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(values[0]));
            employee.setName(values[1]);
            employee.setDateOfBirth(LocalDate.parse(values[2]));
            employee.setGender((values[3]));
            employee.setPhoneNumber(values[4]);
            employee.setPosition(values[5]);
            if (values[6].equals("IT")) {
                employee.setDepartment(Department.IT);
            } else if (values[6].equals("HR")) {
                employee.setDepartment(Department.HR);
            } else {
                employee.setDepartment(Department.SALES);
            }
            employee.setImmediateSuperior(values[7]);
            employee.setEmploymentDate(LocalDate.parse(values[8]));
            employee.setSalary(Double.parseDouble(values[9]));
            return employee;
        } else {
            return new Employee();
        }
    }

    public String getCsvLineFromEmployee(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getId());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getName());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getDateOfBirth().toString());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getGender());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getPhoneNumber());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getPosition());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getDepartment());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getImmediateSuperior());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getEmploymentDate().toString());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getSalary());
        return sb.toString();
    }

    public List<Employee> getEmployeeList(List<String> stringEmployees) {
        List<Employee> employees = new ArrayList<>();
        for (String employeeString : stringEmployees) {
            employees.add(getEmployeeFromCsvLine(employeeString));
        }
        return employees;
    }
}
