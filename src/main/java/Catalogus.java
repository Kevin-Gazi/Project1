import java.util.ArrayList;
import java.util.Scanner;

public class Catalogus {
    public ArrayList<Game> games;

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
        game1.KortingGame(50);
        voegGameToe(game1);

        Game game2 = new Game("Super Mario Bros", "Adventure", 19.99);
        game2.KortingGame(50);
        voegGameToe(game2);

        Game game3 = new Game("The Legend of Zelda", "Adventure", 29.99);
        game3.KortingGame(25);
        voegGameToe(game3);

        Game game4 = new Game("Tetris", "Puzzle", 14.99);
        game4.KortingGame(10);
        voegGameToe(game4);

        Game game5 = new Game("Space Invaders", "Shooter", 9.99);
        game5.KortingGame(10);
        voegGameToe(game5);
    }

    public void voegReviewToe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welke game wil je reviewen?");
        String reviewKeuze = sc.nextLine();

        boolean gameGevonden = false;

        for (Game spel : games) {
            if (spel.getGameNaam().equalsIgnoreCase(reviewKeuze)) {
                gameGevonden = true;
                System.out.println("Voor de volgende categorieën kan je een geheel cijfer van 1 tot 5 geven.");

                System.out.println("Welk cijfer geef je dit spel voor de categorie gameplay?");
                int cijferGameplay = sc.nextInt();
                while (cijferGameplay < 1 || cijferGameplay > 5) {
                    System.out.println("Ongeldige score. Het cijfer moet tussen 1 en 5 liggen, voer een nieuw cijfer in.");
                    cijferGameplay = sc.nextInt();
                }

                System.out.println("Welk cijfer geef je dit spel voor de categorie storyline?");
                int cijferStoryline = sc.nextInt();
                while (cijferStoryline < 1 || cijferStoryline > 5) {
                    System.out.println("Ongeldige score. Het cijfer moet tussen 1 en 5 liggen, voer een nieuw cijfer in.");
                    cijferStoryline = sc.nextInt();
                }

                System.out.println("Welk cijfer geef je dit spel voor de categorie graphics?");
                int cijferGraphics = sc.nextInt();
                while (cijferGraphics < 1 || cijferGraphics > 5) {
                    System.out.println("Ongeldige score. Het cijfer moet tussen 1 en 5 liggen, voer een nieuw cijfer in.");
                    cijferGraphics = sc.nextInt();
                }

                sc.nextLine();

                System.out.println("Geef een toelichting van je cijfers:");
                String toelichting = sc.nextLine();

                Review review = new Review(cijferGameplay, cijferGraphics, cijferStoryline, toelichting);
                spel.voegReviewToe(review);

                System.out.println("Bedankt voor het geven van een review op de game:" +spel.getGameNaam());
                System.out.println("Heeft u tijd om een vragenlijst in te vullen? (Ja/Nee)");

                String antwoord =sc.nextLine();
                if (antwoord.equalsIgnoreCase("Ja")) {
                    VragenLijst vragenlijst = new VragenLijst();
                    vragenlijst.vragenLijst();
                }
            }
        }

        if (!gameGevonden) {
            System.out.println("Deze game staat niet in de catalogus.");
        }
    }

    public void toonReviews() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welke game wil je de reviews van zien?");
        String gameKeuze = sc.nextLine();

        boolean gameGevonden = false;

        for (Game game : games) {
            if (game.getGameNaam().equalsIgnoreCase(gameKeuze)) {
                gameGevonden = true;
                System.out.println("Reviews voor " + gameKeuze + ":");

                double totaleScore = 0;
                int aantalReviews = game.getReviewLijst().size();

                for (Review review : game.getReviewLijst()) {
                    System.out.println("Gameplay Score: " + review.getGameplayScore());
                    System.out.println("Graphics Score: " + review.getGraphicsScore());
                    System.out.println("Story Score: " + review.getStoryScore());
                    System.out.println("Toelichting: " + review.getToelichting());
                    System.out.println();

                    totaleScore += review.getGameplayScore() + review.getGraphicsScore() + review.getStoryScore();
                }

                if (aantalReviews != 0) {
                    double gemiddeldeScore = totaleScore / 3.0; // Correctie hier
                    System.out.println("Gemiddelde score: " + gemiddeldeScore);
                }
            }
        }

        if (!gameGevonden) {
            System.out.println("Deze game staat niet in de catalogus.");
        }
    }

}
