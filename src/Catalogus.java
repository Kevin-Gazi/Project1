import java.util.ArrayList;
public class Catalogus {
    private ArrayList<Game> games;

    public Catalogus() {
        this.games = new ArrayList<>();
    }

    public void voegGameToe(Game game) {
        games.add(game);
    }

    public void toonCatalogus() {
            System.out.println("Games in de catalogus:");
            for (Game game : games) {
                System.out.println("Titel: " + game.getGameNaam() + ", Genre: " + game.getGameGenre() + ", Prijs: " + game.getGamePrijs());
        }
    }

    public void maakRetroGames() {
        Game game1 = new Game("Pac-Man", "Arcade", 9.99);
        voegGameToe(game1);

        Game game2 = new Game("Super Mario Bros", "Adventure", 19.99);
        voegGameToe(game2);

        Game game3 = new Game("The Legend of Zelda", "Adventure", 29.99);
        voegGameToe(game3);

        Game game4 = new Game("Tetris", "Puzzle", 14.99);
        voegGameToe(game4);

        Game game5 = new Game("Space Invaders", "Shooter", 9.99);
        voegGameToe(game5);
    }
}