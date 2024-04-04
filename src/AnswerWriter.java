import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnswerWriter {
    // Methode om gegevens naar een CSV-bestand te schrijven
    public static void writeToCSV(String fileName) {
        try {
            // Open het bestand in schrijfmodus (creëert een nieuw bestand of overschrijft het bestaande)
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Schrijf koptekst
            bufferedWriter.write("Name, Age, City");
            bufferedWriter.newLine(); // Voeg een nieuwe regel toe

            // Schrijf gegevens
            bufferedWriter.write("John Doe, 30, New York");
            bufferedWriter.newLine(); // Voeg een nieuwe regel toe
            bufferedWriter.write("Jane Smith, 25, Los Angeles");

            // Sluit het bestand
            bufferedWriter.close();

            System.out.println("Gegevens succesvol naar het CSV-bestand geschreven.");
        } catch (IOException e) {
            System.out.println("Er is een fout opgetreden tijdens het schrijven naar het bestand: " + e.getMessage());
        }
    }
}
