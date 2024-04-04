import java.util.ArrayList;
public class Catalogus {
    private ArrayList<Game> games;

    public Catalogus() {
        this.games = new ArrayList<>();
    }

    // Methode om een game toe te voegen aan de catalogus
    public void voegGameToe(Game game) {
        games.add(game);
    }

    // Methode om alle games in de catalogus weer te geven
    public void toonCatalogus() {
        if (games.isEmpty()) {
            System.out.println("De catalogus bevat geen games.");
        } else {
            System.out.println("Games in de catalogus:");
            for (Game game : games) {
                System.out.println("Titel: " + game.getGameNaam() + ", Genre: " + game.getGameGenre() + ", Prijs: " + game.getGamePrijs());
            }
        }
    }
}