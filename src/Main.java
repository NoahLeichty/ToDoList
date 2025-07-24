import javax.swing.*;
import java.io.*;

// Will write to file
public class Main extends JFrame{

    private final JTextArea textArea;
    private final File file;

    public Main() {
        file = new File("ToDoList.txt");
        // Sets up frame
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        printFile();

        // Add a WindowListener to save file when closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                WriteToFile();
            }
        });
    }
    private void printFile(){
        // Printing file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.read(reader, null);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(textArea, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void WriteToFile() {
        // Writing to file
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                writer.flush(); // Ensure all buffered data is written
            } catch (IOException e) {
                JOptionPane.showMessageDialog(textArea, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(textArea, "No file to save.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}