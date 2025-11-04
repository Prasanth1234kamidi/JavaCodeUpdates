import java.util.*;

public class CompanyInfo {
    private final List<String> employees;
    private final Set<String> departments;
    private final Map<Integer, String> empDirectory;

    public CompanyInfo(List<String> employees, Set<String> departments, Map<Integer, String> empDirectory) {
        // Unmodifiable copies using Java 10 copyOf()
        this.employees = List.copyOf(employees);
        this.departments = Set.copyOf(departments);
        this.empDirectory = Map.copyOf(empDirectory);
    }

    public List<String> getEmployees() {
        return employees; // safe to return
    }

    public Set<String> getDepartments() {
        return departments; // safe to return
    }

    public Map<Integer, String> getEmpDirectory() {
        return empDirectory; // safe to return
    }

    public static void main(String[] args) {
        // Original mutable collections
        List<String> empList = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));
        Set<String> deptSet = new HashSet<>(Set.of("HR", "IT", "Finance"));
        Map<Integer, String> empMap = new HashMap<>();
        empMap.put(101, "Alice");
        empMap.put(102, "Bob");

        // Pass to CompanyInfo
        CompanyInfo company = new CompanyInfo(empList, deptSet, empMap);

        // Modify original collections after object creation
        empList.add("David");
        deptSet.add("Admin");
        empMap.put(103, "Eve");

        // Unmodifiable copies remain unchanged
        System.out.println("Employees: " + company.getEmployees());
        System.out.println("Departments: " + company.getDepartments());
        System.out.println("Employee Directory: " + company.getEmpDirectory());

        // Trying to modify returned data throws exception
        company.getEmployees().add("Frank");  // ❌ UnsupportedOperationException
    }
}

