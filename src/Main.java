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

        // file path
        String filePath = "ToDoList.txt";

        // Sets up frame
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);

        // Sets up text area and adds it to frame
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        frame.add(textArea);

        // Printing file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            textArea.read(reader, null);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(textArea, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Writing to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            textArea.write(writer);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing file: " + ex.getMessage());
        }
    }
}