package AccountingSoftware.service;

import AccountingSoftware.Exception.InvalidUserInteractionException;
import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;

import java.util.Scanner;

import static AccountingSoftware.util.Constants.*;

public class UserInteractionServiceImpl implements UserInteractionService {
    private Scanner scanner = new Scanner(System.in);
    EmployeeInteractionService employeeInteractionService = new EmployeeInteractionServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    public void initInteraction() {
        switch (chooseInitialAction()) {
            case ACCESS_DATABASE:
                switch (chooseAccessDatabaseAction()) {
                    case LIST_EMPLOYEES:
                        employeeService.listEmployees();
                        break;
                    case ADD_EMPLOYEES:
                        Employee employee = employeeInteractionService.addEmployeeAction();
                        employeeService.addEmployee(employee);
                        break;
                    case DELETE_EMPLOYEE:
                        int idToBeDeleted = employeeInteractionService.deleteEmployeeAction();
                        employeeService.deleteEmployee(idToBeDeleted);
                        break;
                    case UPDATE_EMPLOYEE:
                        Employee employeeToBeUpdated = employeeInteractionService.updateEmployeeAction();
                        employeeService.updateEmployee(employeeToBeUpdated);
                        break;
                    case RETURN_TO_MENU:
                        initInteraction();
                        break;
                }
                break;
            case VIEW_REPORTS:
                switch (chooseViewReportsAction()) {
                    case AVERAGE_SALARY_BY_COMPANY:
                        System.out.println("Show average salary: " + employeeService.calculateAverageSalary());
                        break;
                    case AVERAGE_SALARY_BY_DEPARTMENT:
                        Department department = employeeInteractionService.chooseDepartmentAction();
                        Double avgByDepartment = employeeService.calculateAverageSalaryByDepartment(department);
                        System.out.println("Show average salary by department: " + department + " is " + avgByDepartment);
                        break;
                    case MOST_EXPENSIVE_EMPLOYEES:
                        System.out.println("Top 10 of the most expensive employees in terms of salary: ");
                        System.out.println(employeeService.showTheMostExpensiveEmployees());
                        break;
                    case MOST_LOYAL_EMPLOYEES:
                        System.out.println("Top 10 of the most loyal employees in the number of years worked in the company: ");
                        System.out.println(employeeService.showTheMostLoyalEmployees());
                        break;
                    case RETURN_TO_MENU:
                        initInteraction();
                }
                break;
        }
        initInteraction();
    }

    private Integer chooseViewReportsAction() {
        System.out.println("Average salary by company - press " + AVERAGE_SALARY_BY_COMPANY);
        System.out.println("Average salary by DEPARTMENT - press " + AVERAGE_SALARY_BY_DEPARTMENT);
        System.out.println("Show top 10 most expensive employees in terms of salary - press " + MOST_EXPENSIVE_EMPLOYEES);
        System.out.println("Show top 10 most loyal employees in the number of years worked in the company - press " + MOST_LOYAL_EMPLOYEES);
        System.out.println("To return to the initial menu - press " + RETURN_TO_MENU);
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != AVERAGE_SALARY_BY_COMPANY &&
                    action != AVERAGE_SALARY_BY_DEPARTMENT &&
                    action != MOST_EXPENSIVE_EMPLOYEES &&
                    action != MOST_LOYAL_EMPLOYEES &&
                    action != RETURN_TO_MENU) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Please enter a valid number for your action!");
        }
        return chooseViewReportsAction();
    }

    private Integer chooseInitialAction() {
        System.out.println("Choose action: ");
        System.out.println("Access database - press " + ACCESS_DATABASE);
        System.out.println("View reports - press " + VIEW_REPORTS);
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != ACCESS_DATABASE && action != VIEW_REPORTS) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception ex) {
            System.out.println("Please enter a valid number" + ACCESS_DATABASE + " (access database)" +
                    " or " + VIEW_REPORTS + " (view reports)!");
        }
        return chooseInitialAction();
    }

    private Integer chooseAccessDatabaseAction() {
        System.out.println("List employees - press " + LIST_EMPLOYEES);
        System.out.println("Add employees - press " + ADD_EMPLOYEES);
        System.out.println("Delete employees - press " + DELETE_EMPLOYEE);
        System.out.println("Update employees - press " + UPDATE_EMPLOYEE);
        System.out.println("To return to the initial menu - press " + RETURN_TO_MENU);
        try {
            int action = Integer.parseInt(scanner.nextLine());
            if (action != LIST_EMPLOYEES && action != ADD_EMPLOYEES &&
                    action != DELETE_EMPLOYEE &&
                    action != UPDATE_EMPLOYEE &&
                    action != RETURN_TO_MENU) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Please enter a valid number for your action!");
        }
        return chooseAccessDatabaseAction();
    }
}
