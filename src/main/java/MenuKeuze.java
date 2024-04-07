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
        System.out.println("3. Toon games op basis van genre");
        System.out.println("4. Voeg een review toe voor een game");
        System.out.println("5. Toon reviews");
        System.out.println();
        System.out.println("9. Afsluiten");
    }


    public void start() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        catalogus.maakRetroGames();

        do {
            displayMainMenu();
            System.out.print("Voer uw keuze in: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    catalogus.toonCatalogus();
                    break;
                case 2:
                    Game.voegGameToe(scanner, catalogus);
                    break;
                case 3:
                    catalogus.toonGamesOpGenre();
                    break;
                case 4:
                    catalogus.voegReviewToe();
                    break;
                case 5:
                    catalogus.toonReviews();
                    break;
                case 9:
                    System.out.println("Bedankt voor uw bezoek aan de Retro Game Store!");
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        } while (choice != 9);
    }
}
