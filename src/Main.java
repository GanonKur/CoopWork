
import Algorithms.*;
import FileWork.*;
import Classes.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alie", "password2", "alice@example.com"));
        users.add(new User("Bob", "password1", "bob@example.com"));
        users.add(new User("car", "password3", "charlie@example.com"));
        users.add(new User("Alie", "password1", "alice123@example.com"));
        users.add(new User("Bob", "password2", "bob123@example.com"));
        users.add(new User("Oleg"));

        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus(3, "Model A", 50000));
        buses.add(new Bus(1, "Model B", 70000));
        buses.add(new Bus(2, "Model A", 30000));
        buses.add(new Bus(1, "Model C", 40000));

        List<Student> students = new ArrayList<>();
        students.add(new Student(5, 5.3F,6));
        students.add(new Student(1, 5.4F,6));
        students.add(new Student(1, 5.4F,7));
        students.add(new Student(1, 5.3F,6));

        System.out.println("До сортировки:");
        for (User user : users) {
            System.out.println(user.toString());
        }

        QuickSort.quickSort(users);

        System.out.println("После сортировки:");
        for (User user : users) {
            System.out.println(user);
        }


        System.out.println("До сортировки:");
        for (Bus bus : buses) {
            System.out.println(bus);
        }

        QuickSort.quickSort(buses);

        System.out.println("После сортировки:");
        for (Bus bus : buses) {
            System.out.println(bus);
        }

        QuickSort.quickSort(students);
        for (Student student: students){
        System.out.println(student);
        }
        System.out.println(BinarySearch.binarySearch(students,new Student(1, 5.3F,16)));
        String filename2 = "src/Files/file.txt";

        String filename = "src/Files/Reader.txt";

        FileReader.readFromFile(filename, users, buses, students);

        System.out.println("Users: " + users);
        System.out.println("Buses: " + buses);
        System.out.println("Students: " + students);
        FileSaver.saveToFile(users,filename2, "Users");
        FileSaver.saveToFile(buses, filename2, "Buses");
        FileSaver.saveToFile(students, filename2, "Students");
    }

}

