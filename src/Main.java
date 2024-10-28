import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String[] NAMES = {
            "Alexander", "Mikhail", "Dmitry", "Andrey", "Sergey", "Nikolay", "Ivan", "Alexey",
            "Vladimir", "Evgeny", "Maxim", "Oleg", "Pavel", "Konstantin", "Roman", "Yuri",
            "Viktor", "Vitaly", "Boris", "Anton", "Anna", "Maria", "Elena", "Olga", "Svetlana",
            "Tatiana", "Irina", "Natalia", "Ekaterina", "Galina"
    };

    private static final String[] SURNAMES = {
            "Ivanov", "Petrov", "Sidorov", "Smirnov", "Volkov", "Fedorov", "Morozov",
            "Vasilyev", "Popov", "Kuznetsov", "Pavlov", "Rogov", "Karpov", "Mikhailov",
            "Lebedev", "Sokolov", "Orlov", "Kovalev", "Borisov", "Zaytsev"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Сгенерировать список объектов Bus");
                System.out.println("2 - Сгенерировать список объектов User");
                System.out.println("3 - Сгенерировать список объектов Student");
                System.out.println("0 - Выйти из программы");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Выход из программы...");
                    continueProgram = false;
                    continue;
                }

                System.out.println("Введите размер списка (от 1 до 20):");
                int listSize = scanner.nextInt();
                if (listSize < 1 || listSize > 20) {
                    System.out.println("Размер списка должен быть в пределах от 1 до 20.");
                    continue;
                }

                switch (choice) {
                    case 1: // Bus
                        List<Bus> buses = new ArrayList<>();
                        for (int i = 0; i < listSize; i++) {
                            buses.add(new Bus(
                                    "Bus-" + random.nextInt(1000),
                                    "Model-" + (char)(random.nextInt(26) + 'A'),
                                    random.nextInt(100000)
                            ));
                        }
                        printList(buses);
                        break;

                    case 2: // User
                        List<User> users = new ArrayList<>();
                        for (int i = 0; i < listSize; i++) {
                            String fullName = generateRandomFullName(random);
                            users.add(new User(
                                    fullName,
                                    "Pass" + random.nextInt(1000),
                                    fullName.replace(" ", ".").toLowerCase() + "@example.com"
                            ));
                        }
                        printList(users);
                        break;

                    case 3: // Student
                        List<Student> students = new ArrayList<>();
                        for (int i = 0; i < listSize; i++) {
                            students.add(new Student(
                                    "Group" + random.nextInt(100),
                                    2 + random.nextDouble() * 3,
                                    "ID-" + random.nextInt(10000)
                            ));
                        }
                        printList(students);
                        break;

                    default:
                        System.out.println("Неверный выбор!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите корректное числовое значение.");
                scanner.next(); // Очищаем ввод, чтобы избежать бесконечного цикла
            }
        }
        scanner.close();
    }

    private static String generateRandomFullName(Random random) {
        String name = NAMES[random.nextInt(NAMES.length)];
        String surname = SURNAMES[random.nextInt(SURNAMES.length)];
        return name + " " + surname;
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}


// Класс Bus
class Bus {
    String number;
    String model;
    int mileage;

    public Bus(String number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}

// Класс User
class User {
    String name;
    String password;
    String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

// Класс Student
class Student {
    String groupNumber;
    double averageScore;
    String studentIdCard;

    public Student(String groupNumber, double averageScore, String studentIdCard) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.studentIdCard = studentIdCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "groupNumber='" + groupNumber + '\'' +
                ", averageScore=" + averageScore +
                ", studentIdCard='" + studentIdCard + '\'' +
                '}';
    }
}
