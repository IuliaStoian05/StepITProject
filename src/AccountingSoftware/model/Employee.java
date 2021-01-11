package AccountingSoftware.model;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private Department department;
    LocalDate employmentDate;
    LocalDate dateOfBirth;
    private Double salary;
    private String phoneNumber;
    private String position;
    private String immediateSuperior;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateSuperior() {
        return immediateSuperior;
    }

    public void setImmediateSuperior(String immediateSuperior) {
        this.immediateSuperior = immediateSuperior;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (employmentDate != null ? !employmentDate.equals(employee.employmentDate) : employee.employmentDate != null)
        if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null)
        if (gender != null ? !gender.equals(employee.gender) : employee.gender != null)
        if (phoneNumber != null ? !phoneNumber.equals(employee.phoneNumber) : employee.phoneNumber != null)
        if (position != null ? !position.equals(employee.position) : employee.position != null)
        if (immediateSuperior != null ? !immediateSuperior.equals(employee.immediateSuperior) : employee.immediateSuperior != null)
            return false;

        return salary != null ? salary.equals(employee.salary) : employee.salary == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result * (name != null ? name.hashCode() : 0);
        result = 31 * result * (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result * (gender != null ? gender.hashCode() : 0);
        result = 31 * result * (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result * (position != null ? position.hashCode() : 0);
        result = 31 * result * (department != null ? department.hashCode() : 0);
        result = 31 * result * (immediateSuperior != null ? immediateSuperior.hashCode() : 0);
        result = 31 * result * (employmentDate != null ? employmentDate.hashCode() : 0);
        result = 31 * result * (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth +
                ", gender=" + gender +
                ", phoneNumber=" + phoneNumber +
                ", position=" + position +
                ", department=" + department +
                ", immediateSuperior=" + immediateSuperior +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                '}';
    }
}

