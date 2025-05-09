import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String gameNaam;
    private String gameGenre;
    private double gamePrijs;
    ArrayList <Review> reviewLijst;

    public Game (String gameNaam, String gameGenre, double gamePrijs) {
        this.gameNaam = gameNaam;
        this.gameGenre = gameGenre;
        this.gamePrijs = gamePrijs;
        this.reviewLijst = new ArrayList<>();
    }

    public String getGameNaam() {
        return gameNaam;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public double getGamePrijs() {
        return gamePrijs;
    }

    public void setGamePrijs(double gamePrijs) {
        this.gamePrijs = gamePrijs;
    }

    public ArrayList<Review> getReviewLijst() {
        return reviewLijst;
    }

    public static void voegGameToe(Scanner scanner, Catalogus catalogus) {
        System.out.print("Voer de titel van de nieuwe game in: ");
        String titel = scanner.nextLine();
        System.out.print("Voer het genre van de nieuwe game in: ");
        String genre = scanner.nextLine();
        double prijs;
        while (true) {
            System.out.print("Voer de prijs van de nieuwe game in: ");
            double input = scanner.nextDouble();
            try {
                prijs = input;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in voor de prijs.");
            }
        }

        Game nieuweGame = new Game(titel, genre, prijs);
        catalogus.voegGameToe(nieuweGame);
        System.out.println("Nieuwe game toegevoegd aan de catalogus!");
    }

    public void voegReviewToe(Review review){
        reviewLijst.add(review);
    }

}
