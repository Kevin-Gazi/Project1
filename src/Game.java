import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    String gameNaam;
    String gameGenre;
    double gamePrijs;
    ArrayList<Review> reviewLijst;

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
}
