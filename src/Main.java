import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// Will write to file
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Frame frame = new Frame("To Do List");
        frame.setSize(300, 400);
        frame.setVisible(true);

        TextField textField = new TextField();
        textField.setEditable(true);
        frame.add(textField);

        // file path
        String filePath = "ToDoList.txt";

        // Printing file
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                textField.setText(textField.getText() +  scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}