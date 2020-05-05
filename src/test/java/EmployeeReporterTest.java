import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

public class EmployeeReporterTest {

    @Test
    public void should_return_empty_list_given_empty_employees() {
        assertThat(new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(List.of()), is(empty()));
    }

    @Test
    public void should_allow_to_work_on_sunday_for_employees_older_or_equals_than_18_years_old() {
        var employees = List.of(new Employee("Mike", 18));

        assertThat(new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(employees), is(List.of(new Employee("MIKE", 18))));
    }

    @Test
    public void should_not_allow_to_work_on_sunday_for_employees_younger_than_18_years_old() {
        var employees = List.of(new Employee("Nina", 17));

        assertThat(new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(employees), is(empty()));
    }

    @Test
    public void should_return_employees_allowed_to_work_on_sunday() {
        var employees = List.of(
                new Employee("Max", 17),
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51)
        );

        assertThat(new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(employees), is(List.of(new Employee("MIKE", 51), new Employee("SEPP", 18))));
    }

    @Test
    public void should_order_employees_by_name() {
        var employees = List.of(new Employee("Mike", 18), new Employee("Alice", 18));

        List<Employee> employeesAllowedToWorkOnSunday = new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(employees);

        assertThat(employeesAllowedToWorkOnSunday, is(List.of(new Employee("ALICE", 18), new Employee("MIKE", 18))));
    }

    @Test
    public void should_capitalize_names() {
        var employees = List.of(new Employee("Mike", 18));

        assertThat(new EmployeeReporter().findEmployeesAllowedToWorkOnSunday(employees), is(List.of(new Employee("MIKE", 18))));
    }
}
