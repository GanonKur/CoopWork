package FileWork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSaver {

    public static <T> void saveToFile(List<T> list, String filename, String header) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(header + ":\n");
            for (T item : list) {
                writer.write(item.toString() + "\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}