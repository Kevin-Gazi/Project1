import java.util.Scanner;

public class MenuKeuze {
    private Catalogus catalogus;

    public MenuKeuze() {
        this.catalogus = new Catalogus();
    }

    public void displayMainMenu() {
        System.out.println("=== Retro Game Store ===");
        System.out.println("1. Toon alle games");
        System.out.println("2. Voeg nieuwe game toe");
        System.out.println("3. Toon reviews op basis van genre");
        System.out.println("4. Voeg een review toe voor een game");
        System.out.println();
        System.out.println("5. Afsluiten");
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
                    catalogus.toonCatalogus();
                    break;
                case 2:
                    voegGameToe(scanner);
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

    public void voegGameToe(Scanner scanner) {
        System.out.print("Voer de titel van de nieuwe game in: ");
        String titel = scanner.nextLine();
        System.out.print("Voer het genre van de nieuwe game in: ");
        String genre = scanner.nextLine();
        System.out.print("Voer de prijs van de nieuwe game in: ");
        double prijs = scanner.nextDouble();
        Game nieuweGame = new Game(titel, genre, prijs);
        catalogus.voegGameToe(nieuweGame);
        System.out.println("Nieuwe game toegevoegd aan de catalogus!");
    }
}
