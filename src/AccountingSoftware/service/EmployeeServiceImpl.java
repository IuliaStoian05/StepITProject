package AccountingSoftware.service;

import AccountingSoftware.mapper.EmployeeMapper;
import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;
import AccountingSoftware.repository.EmployeeRepository;
import AccountingSoftware.repository.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    private EmployeeMapper employeeMapper = new EmployeeMapper();

    public void listEmployees() {
        List<String> csvLines = employeeRepository.readCsv();
        for (String csvLine : csvLines) {
            Employee employee = employeeMapper.getEmployeeFromCsvLine(csvLine);
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    @Override
    public void addEmployee(Employee employee) {

        String employeeString = employeeMapper.getCsvLineFromEmployee(employee);
        employeeRepository.insertLine(employeeString);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteLine(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String employeeString = employeeMapper.getCsvLineFromEmployee(employee);
        employeeRepository.updateLine(employee.getId(), employeeString);
    }

    @Override
    public Double calculateAverageSalary() {
        List<Employee> employees = employeeMapper.getEmployeeList(employeeRepository.readCsv());
        return calculateAverageSalary(employees);
    }

    @Override
    public Double calculateAverageSalaryByDepartment(Department department) {
        List<Employee> employees = employeeMapper.getEmployeeList(employeeRepository.readCsv());
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                filteredEmployees.add(employee);
            }
        }
        return calculateAverageSalary(filteredEmployees);
    }

    @Override
    public String showTheMostExpensiveEmployees() {
        List<Employee> employees = employeeMapper.getEmployeeList(employeeRepository.readCsv());
        employees.sort(new EmployeeSalaryComparator());
        for (int i = 0; i < 10; i++) {
            System.out.println(employees.get(i).getName() + " " + employees.get(i).getSalary());
        }
        return " ";
    }

    @Override
    public String showTheMostLoyalEmployees() {
        List<Employee> employees = employeeMapper.getEmployeeList(employeeRepository.readCsv());
        employees.sort(new EmploymentDateComparator());
        for (int i = 0; i < 10; i++) {
            System.out.println(employees.get(i).getName() + " " + employees.get(i).getEmploymentDate());
        }
        return " ";
    }


    private Double calculateAverageSalary(List<Employee> employees) {
        Double salarySum = 0.0;
        for (Employee employee : employees) {
            salarySum += employee.getSalary();
        }
        if (employees.size() < 1) {
            return 0.0;
        }
        return salarySum / employees.size();
    }
}
