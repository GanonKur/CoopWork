import Classes.Bus;
import Classes.Student;
import Classes.User;

public class Main {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .setGroupNumber(101)
                .setAverageScore(4.8)
                .setStudentIdCard("12345")
                .build();
        System.out.println(student);
        User user = new User.UserBuilder()
                 .setName("Петя")
                .setPassword("мтсьбь")
                .setEmail("12345")
                .build();
        System.out.println(user);
        Bus bus = new Bus.BusBuilder()
                .setNumber(5)
                .setModel("Мерседес")
                .setMileage(12345)
                .build();
        System.out.println(bus);
    }
}