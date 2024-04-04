import java.util.ArrayList;

public class Game {
    String gameNaam;
    String gameGenre;
    double gamePrijs;
    ArrayList<Review> reviewLijst = new ArrayList<>();

    public Game (String gameNaam, String gameGenre, double gamePrijs) {
        this.gameNaam = gameNaam;
        this.gameGenre = gameGenre;
        this.gamePrijs = gamePrijs;
    }



    public void voegGameToe() {
    }
}
