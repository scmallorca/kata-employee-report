import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeReporter {

    public List<Employee> findEmployeesAllowedToWorkOnSunday(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.isAdult())
                .map(employee -> new Employee(employee.getName().toUpperCase(), employee.getAge()))
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

}
