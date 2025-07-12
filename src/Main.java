import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
// Will write to file
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Sets up frame
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);

        // Sets up text area and adds it to frame
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        frame.add(textArea);

        // file path
        String filePath = "ToDoList.txt";

        // Printing file
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                textArea.setText(textArea.getText() +  scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        // Writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}