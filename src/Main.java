import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Will write to file
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // file path
        String filePath = "ToDoList.txt";

        // Printing file to console
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}