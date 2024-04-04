import java.util.Scanner;

public class MenuKeuze {
    // Methode om het menu weer te geven
    public void displayMainMenu() {
        System.out.println("=== Retro Game Store ===");
        System.out.println("1. Toon alle games");
        System.out.println("4. Voeg een review toe voor een game");
        System.out.println("3. Toon reviews op basis van genre");
        System.out.println("4. Voeg nieuwe game toe");
        System.out.println("5. Speel game");
        System.out.println("6. Afsluiten");
    }


    public void start() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            displayMainMenu();
            System.out.print("Voer uw keuze in: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    break;
                case 2:
                    System.out.print("Voer de titel van de nieuwe game in: ");
                    String title = scanner.nextLine();
                    System.out.print("Voer het genre van de nieuwe game in: ");
                    String genre = scanner.nextLine();
                    System.out.print("Voer de prijs van de nieuwe game in: ");
                    double price = scanner.nextDouble();
                    System.out.println("Nieuwe game toegevoegd!");
                    break;
                case 3:
                    System.out.print("Voer het genre in om de reviews te tonen: ");
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Bedankt voor uw bezoek aan de Retro Game Store!");
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        } while (choice != 5);
    }
}
