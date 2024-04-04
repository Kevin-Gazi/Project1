import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt"; // Name of the text file

        try {
            // Open the file in append mode
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data to the file
            bufferedWriter.write("Hello, World!");
            bufferedWriter.newLine(); // Add a new line

            // Write more data
            bufferedWriter.write("This is a sample text.");

            // Close the file
            bufferedWriter.close();

            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}