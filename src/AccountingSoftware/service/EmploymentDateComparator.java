package AccountingSoftware.service;

import AccountingSoftware.model.Employee;

import java.time.LocalDate;
import java.util.Comparator;

public class EmploymentDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmploymentDate().compareTo(o2.getEmploymentDate());
    }
}
