import javax.swing.*;
import java.io.*;

// Will write to file
public class Main extends JFrame{

    // adds text area and file so that it fits scope
    private final JTextArea textArea;
    private File file;

    public Main() {
        // Setting up text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        printFile();

        // Add a WindowListener to save file when closed
        // When X is pressed to close screen it saves text to file
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                WriteToFile();
            }
        });
        // Sets up frame
        setTitle("To Do List");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }
    // Prints what's in the file to the text area
    private void printFile(){
        file = new File("ToDoList.txt");
        // Printing file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.read(reader, null);
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            JOptionPane.showMessageDialog(textArea, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Writes text to the file
    private void WriteToFile() {
        // Writing to file
        if (this.file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.file))) {
                this.textArea.write(writer);
                writer.flush();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this.textArea, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this.textArea, "No file to save.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}