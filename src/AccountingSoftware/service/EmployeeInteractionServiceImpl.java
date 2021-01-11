package AccountingSoftware.service;

import AccountingSoftware.Exception.InvalidUserInteractionException;
import AccountingSoftware.model.Department;
import AccountingSoftware.model.Employee;
import AccountingSoftware.util.Constants;
import AccountingSoftware.model.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeInteractionServiceImpl implements EmployeeInteractionService {
    private Scanner scanner = new Scanner(System.in);


    @Override
    public Employee addEmployeeAction() {
        Employee employee = new Employee();
        employee.setId(getId());
        employee.setName(getName());
        employee.setDateOfBirth(getDateOfBirth());
        employee.setGender(String.valueOf(getGender()));
        employee.setPhoneNumber(getPhoneNumber());
        employee.setPosition(getPosition());
        employee.setDepartment(getDepartment());
        employee.setImmediateSuperior(getImmediateSuperior());
        employee.setEmploymentDate(getEmploymentDate());
        employee.setSalary(getSalary());
        return employee;
    }

    @Override
    public Integer deleteEmployeeAction() {
        return getId();
    }

    @Override
    public Employee updateEmployeeAction() {
        return addEmployeeAction();
    }

    @Override
    public Department chooseDepartmentAction() {
        return getDepartment();
    }

    private Integer getId() {
        System.out.println("Id: ");
        try {
            Integer id = Integer.parseInt(scanner.nextLine());
            return id;
        } catch (Exception ex) {
            System.out.println("Wrong id. Try again!");
        }
        return getId();
    }

    private String getName() {
        System.out.println("Name: ");
        try {
            String name = scanner.nextLine();
            return name;
        } catch (Exception ex) {
            System.out.println("Wrong name. Try again!");
        }
        return getName();
    }

    private Department getDepartment() {
        System.out.println("Department:" + Department.IT.getValue() + " - IT, " + Department.HR.getValue() + " - HR, " + Department.SALES.getValue() + " - SALES ");
        try {
            Integer depId = Integer.parseInt(scanner.nextLine());
            if (depId != 1 && depId != 2 && depId != 3) {
                throw new InvalidUserInteractionException();
            }
            Department department = depId == 1 ? Department.IT : depId == 2 ? Department.HR : Department.SALES;
            return department;
        } catch (Exception ex) {
            System.out.println("Wrong department. Try again!");
        }
        return getDepartment();
    }

    private LocalDate getEmploymentDate() {
        System.out.println("Employment Date(" + Constants.DATE_FORMAT + "):");
        try {
            return LocalDate.parse(scanner.nextLine());
        } catch (Exception ex) {
            System.out.println("Wrong employment date format. Try again!");
        }
        return getEmploymentDate();
    }

    private Double getSalary() {
        System.out.println("Salary: ");
        try {
            return Double.parseDouble(scanner.nextLine());

        } catch (Exception e) {
            System.out.println("Wrong salary. Try again!");
        }
        return getSalary();
    }

    private LocalDate getDateOfBirth() {
        System.out.println("Date of birth(" + Constants.DATE_FORMAT + "):");
        try {
            return LocalDate.parse(scanner.nextLine());
        } catch (Exception ex) {
            System.out.println("Wrong date format. Try again!");
        }
        return getDateOfBirth();
    }

    private Serializable getGender() {
        System.out.println("Gender:" + Gender.M.getValue() + " - Male, " + Gender.F.getValue() + " - Female, " + Gender.O.getValue() + " - Other ");
        try {
            Integer gen = Integer.parseInt(scanner.nextLine());
            if (gen != 1 && gen != 2 && gen != 3) {
                throw new InvalidUserInteractionException();
            }
            Gender gender = gen == 1 ? Gender.M : gen == 2 ? Gender.F : Gender.O;
            return gender;
        } catch (Exception ex) {
            System.out.println("Wrong input for gender. Try again!");
        }
        return getGender();
    }

    private String getPhoneNumber() {
        System.out.println("Phone number: ");
        try {
            String number = scanner.nextLine();
            String phoneNumber;
            if(number.matches("\\d*") && number.length() == 10){
                phoneNumber = number;
                return phoneNumber;
            }else{
                throw new InvalidUserInteractionException();
            }
        } catch (Exception ex) {
            System.out.println("Wrong phone number. Try again!");
        }
        return getPhoneNumber();
    }

    private String getPosition() {
        System.out.println("Position: ");
        try {
            String position = scanner.nextLine();
            return position;
        } catch (Exception ex) {
            System.out.println("Wrong employee position. Try again!");
        }
        return getPosition();
    }

    private String getImmediateSuperior() {
        System.out.println("Name of superior (if any): ");
        try {
            String immediateSuperior = scanner.nextLine();
            if (immediateSuperior == null) {
                System.out.println("There is no superior for this position!");
            } else {
                return immediateSuperior;
            }
        } catch (Exception ex) {
            System.out.println("Wrong name of superior. Try again!");
        }
        return getImmediateSuperior();
    }


}