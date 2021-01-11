package AccountingSoftware.repository;

import java.util.List;

public interface EmployeeRepository {
    void insertLine(String csvLine);
    List<String> readCsv();
    void deleteLine(int empoyeeId);
    void updateLine(int employeeId, String employeeDetails);
}
