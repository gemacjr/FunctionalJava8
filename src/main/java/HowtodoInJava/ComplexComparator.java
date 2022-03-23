package HowtodoInJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexComparator {

    public static void main(String[] args) {
        ArrayList<EmployeeT> employees = getUnsortedEmployeesList();

        //Compare by first name and then last name
        Comparator<EmployeeT> compareByName = Comparator
                .comparing(EmployeeT::getFirstName)
                .thenComparing(EmployeeT::getLastName);

        List<EmployeeT> sortedEmployees = employees.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());

        System.out.println(sortedEmployees);
    }

    private static ArrayList<EmployeeT> getUnsortedEmployeesList(){
        ArrayList<EmployeeT> list = new ArrayList<>();
        list.add(new EmployeeT(21, "Lokesh", "Gupta"));
        list.add( new EmployeeT(1l, "Alex", "Gussin") );
        list.add( new EmployeeT(4l, "Brian", "Sux") );
        list.add( new EmployeeT(5l, "Neon", "Piper") );
        list.add( new EmployeeT(3l, "David", "Beckham") );
        list.add( new EmployeeT(7l, "Alex", "Beckham") );
        list.add( new EmployeeT(6l, "Brian", "Suxena") );
        return list;
    }
}
