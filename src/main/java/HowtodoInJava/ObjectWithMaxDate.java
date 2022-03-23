package HowtodoInJava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ObjectWithMaxDate {

    public static void main(String[] args) {
        Comparator<EmployeeDob> employeeAgeComparator = Comparator
                .comparing(EmployeeDob::getDateOfBirth);

        EmployeeDob youngestEmployee = getEmployeeList().stream()
                .max(employeeAgeComparator)
                .get();

        System.out.println(youngestEmployee); //Prints Employee 'D'
    }

    private static List<EmployeeDob> getEmployeeList()
    {
        List<EmployeeDob> empList = new ArrayList<>();
        empList.add(new EmployeeDob(1, "A", LocalDate.of(1991, 1, 1), 30000));
        empList.add(new EmployeeDob(2, "B", LocalDate.of(1976, 7, 9), 30000));
        empList.add(new EmployeeDob(3, "C", LocalDate.of(1992, 8, 1), 50000));
        empList.add(new EmployeeDob(4, "D", LocalDate.of(2001, 3, 11), 50000));
        return empList;
    }
}
