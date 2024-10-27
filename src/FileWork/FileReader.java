package FileWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import Classes.*;
public class FileReader {

    public static void readFromFile(String filename, List<User> users, List<Bus> buses, List<Student> students) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filename))) {
            String line;
            String currentType = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                switch (line) {
                    case "Users:" -> {
                        currentType = "User";
                        continue;
                    }
                    case "Buses:" -> {
                        currentType = "Bus";
                        continue;
                    }
                    case "Students:" -> {
                        currentType = "Student";
                        continue;
                    }
                }

                if (line.isEmpty()) {
                    continue;
                }

                switch (currentType) {
                    case "User":
                        users.add(parseUser(line));
                        break;
                    case "Bus":
                        buses.add(parseBus(line));
                        break;
                    case "Student":
                        students.add(parseStudent(line));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    private static User parseUser(String line) {
        String name = extractValue(line, "name='", "'");
        String password = extractValue(line, "password='", "'");
        String email = extractValue(line, "email='", "'");
        return new User(name, password, email);
    }

    private static Bus parseBus(String line) {
        int number = Integer.parseInt(extractValue(line, "number=", ","));
        String model = extractValue(line, "model='", "'");
        int mileage = Integer.parseInt(extractValue(line, "mileage=", "}"));
        return new Bus(number, model, mileage);
    }

    private static Student parseStudent(String line) {
        int groupNumber = Integer.parseInt(extractValue(line, "groupNumber=", ","));
        float averageScore = Float.parseFloat(extractValue(line, "averageScore=", ","));
        int studentIdCard = Integer.parseInt(extractValue(line, "studentIdCard=", "}"));
        return new Student(groupNumber, averageScore, studentIdCard);
    }


    private static String extractValue(String line, String start, String end) {
        int startIndex = line.indexOf(start) + start.length();
        int endIndex = line.indexOf(end, startIndex);
        return line.substring(startIndex, endIndex);
    }


}