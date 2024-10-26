import java.util.Random;
import java.util.Scanner;

public class Main {

    // Массивы для хранения списка имен и фамилий
    private static final String[] NAMES = {
            "Alexander", "Mikhail", "Dmitry", "Andrey", "Sergey", "Nikolay", "Ivan", "Alexey",
            "Vladimir", "Evgeny", "Maxim", "Oleg", "Pavel", "Konstantin", "Roman", "Yuri",
            "Viktor", "Vitaly", "Boris", "Anton",  // Мужские имена
            "Anna", "Maria", "Elena", "Olga", "Svetlana", "Tatiana", "Irina", "Natalia",
            "Ekaterina", "Galina" // Женские имена
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
            // Меню выбора действий
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Сгенерировать массив объектов Bus");
            System.out.println("2 - Сгенерировать массив объектов User");
            System.out.println("3 - Сгенерировать массив объектов Student");
            System.out.println("0 - Выйти из программы");
            int choice = scanner.nextInt();

            // Обработка выхода из программы
            if (choice == 0) {
                System.out.println("Выход из программы...");
                continueProgram = false;
                continue;
            }

            // Пользователь выбирает размер массива
            System.out.println("Введите размер массива (от 1 до 20):");
            int arraySize = scanner.nextInt();
            if (arraySize < 1 || arraySize > 20) {
                System.out.println("Размер массива должен быть в пределах от 1 до 20.");
                continue;  // Возвращаемся к выбору действия
            }

            // В зависимости от выбора создаем массив и заполняем случайными значениями
            switch (choice) {
                case 1: // Bus
                    Bus[] buses = new Bus[arraySize];
                    for (int i = 0; i < arraySize; i++) {
                        buses[i] = new Bus(
                                "Bus-" + random.nextInt(1000),  // случайный номер автобуса
                                "Model-" + (char)(random.nextInt(26) + 'A'),  // случайная модель
                                random.nextInt(100000)  // случайный пробег
                        );
                    }
                    printArray(buses);
                    break;

                case 2: // User
                    User[] users = new User[arraySize];
                    for (int i = 0; i < arraySize; i++) {
                        String fullName = generateRandomFullName(random);  // Случайное человеческое имя
                        users[i] = new User(
                                fullName,  // случайное имя и фамилия
                                "Pass" + random.nextInt(1000),  // случайный пароль
                                fullName.replace(" ", ".").toLowerCase() + "@example.com"  // генерируем email на основе имени
                        );
                    }
                    printArray(users);
                    break;

                case 3: // Student
                    Student[] students = new Student[arraySize];
                    for (int i = 0; i < arraySize; i++) {
                        students[i] = new Student(
                                "Group" + random.nextInt(100),  // случайный номер группы
                                2 + random.nextDouble() * 3,
                                "ID-" + random.nextInt(10000)  // случайный номер студенческого
                        );
                    }
                    printArray(students);
                    break;

                default:
                    System.out.println("Неверный выбор!");
                    break;
            }
        }
        scanner.close();
    }

    // Метод для генерации случайного полного имени (имя + фамилия)
    private static String generateRandomFullName(Random random) {
        String name = NAMES[random.nextInt(NAMES.length)];
        String surname = SURNAMES[random.nextInt(SURNAMES.length)];
        return name + " " + surname;
    }

    // Метод для вывода массива объектов
    public static <T> void printArray(T[] array) {
        for (T item : array) {
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
