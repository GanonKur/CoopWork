package Random;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Algorithms.*;
import Classes.Bus;
import Classes.Student;
import Classes.User;
import FileWork.FileReader;
import FileWork.FileSaver;

import static Random.Random.random;

public class MainMenu {
    static List<User> users = new ArrayList<>();
    static List<Bus> buses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n*** Меню приложения сортировки ***");
            System.out.println("1. Выбрать способ заполнения массива");
            System.out.println("2. Записать значение в файл");
            System.out.println("3. Выполнить сортировку массива");
            System.out.println("4. Найти элемент в отсортированном массиве (бинарный поиск)");
            System.out.println("5 Вывести данные в консоль");
            System.out.println("0. Выход из приложения");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chooseArrayFillMethod(scanner);
                    break;
                case 2:
                    setArrayLength();
                    break;
                case 3:
                    sortArray();
                    break;
                case 4:
                    binarySearchInArray(scanner);
                    break;
                case 5 :
                    for (User user : users) {
                        System.out.println(user);
                    }
                    for (Bus buses : buses) {
                        System.out.println(buses);
                    }
                    for (Student student : students) {
                        System.out.println(student);
                    }
                case 0:
                    System.out.println("Выход из приложения");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор! Пожалуйста, выберите пункт из меню.");
            }
        }
        scanner.close();
    }

    // Метод для выбора способа заполнения массива
    private static void chooseArrayFillMethod(Scanner scanner) {


        System.out.println("\nВыберите способ заполнения массива:");
        System.out.println("1. Заполнить массив из файла");
        System.out.println("2. Заполнить массив случайными числами");
        System.out.println("3. Заполнить массив вручную");

        System.out.print("Ваш выбор: ");
        int fillMethodChoice = scanner.nextInt();

        switch (fillMethodChoice) {
            case 1:
                System.out.println("Заполнение из файла.");
                String filename = "src/Files/Reader.txt";

                FileReader.readFromFile(filename, users, buses, students);
                break;
            case 2:
                System.out.println("Случайное заполнение:");
                random();
                break;
            case 3:
                System.out.println("Заполнение массива вручную.");
                break;
            default:
                System.out.println("Неверный выбор! Попробуйте снова.");
        }
    }

    // Метод для установки длины массива
    private static void setArrayLength() {
        File file = new File("src/Files/file.txt");
        file.delete();
        String filename2 = "src/Files/file.txt";
        FileSaver.saveToFile(users,filename2, "Users");
        FileSaver.saveToFile(buses, filename2, "Buses");
        FileSaver.saveToFile(students, filename2, "Students");
    }

    // Метод для выполнения сортировки массива
    private static void sortArray() {
        System.out.println("\nВыполняется сортировка массива...");
        if (!users.isEmpty())
            QuickSort.quickSort(users);
        if (!buses.isEmpty())
            QuickSort.quickSort(buses);
        if (!students.isEmpty())
            QuickSort.quickSort(students);
    }

    // Метод для выполнения бинарного поиска в массиве
    private static void binarySearchInArray(Scanner scanner) {
        System.out.print("\nВведите значение для поиска: ");
        int searchValue = scanner.nextInt();
        System.out.println("Поиск значения " + searchValue + " в отсортированном массиве...");
        // Реализация бинарного поиска
    }
}