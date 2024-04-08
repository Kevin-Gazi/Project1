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
        System.out.println();
        System.out.println("Games in de catalogus:");
        for (Game game : games) {
            double gemiddeldeScore = berekenGemiddeldeScore(game);
            double oudePrijs = game.getGamePrijs();
            String prijsNaKorting;

            if (gemiddeldeScore == 0 || gemiddeldeScore == 3) {
                prijsNaKorting = "N.V.T.";
            } else {
                if (gemiddeldeScore > 4) {
                    game.setGamePrijs(game.getGamePrijs() * 1.10);
                } else if (gemiddeldeScore < 3) {
                    game.setGamePrijs(game.getGamePrijs() * 0.90);
                }
                prijsNaKorting = String.format("%.2f", game.getGamePrijs());
            }

            System.out.printf("Titel: %s, Genre: %s, Prijs: %.2f, Prijs na Korting: %s, Gemiddelde score: %.1f\n",
                    game.getGameNaam(), game.getGameGenre(), oudePrijs, prijsNaKorting, gemiddeldeScore);
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

                String antwoord = "";
                while (!antwoord.equalsIgnoreCase("Ja") && !antwoord.equalsIgnoreCase("Nee")) {
                    antwoord = sc.nextLine();
                    if (!antwoord.equalsIgnoreCase("Ja") && !antwoord.equalsIgnoreCase("Nee")) {
                        System.out.println("Ongeldige invoer. Voer 'Ja' of 'Nee' in.");
                    }
                }

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

                int reviewNummer = 1;
                for (Review review : game.getReviewLijst()) {
                    System.out.println("Review " + reviewNummer + ":");
                    System.out.println("Gameplay Score: " + review.getGameplayScore());
                    System.out.println("Graphics Score: " + review.getGraphicsScore());
                    System.out.println("Story Score: " + review.getStoryScore());
                    System.out.println("Toelichting: " + review.getToelichting());
                    System.out.println();
                    reviewNummer++;
                }

                if (game.getReviewLijst().isEmpty()) {
                    System.out.println("Er zijn geen reviews voor dit spel.");
                }
            }
        }

        if (!gameGevonden) {
            System.out.println("Deze game staat niet in de catalogus.");
        }
    }

    public void toonGamesOpGenre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer het genre in om games te tonen:");
        String genre = scanner.nextLine();

        boolean gamesGevonden = false;

        System.out.println("Games in het genre " + genre + ":");
        for (Game game : games) {
            if (game.getGameGenre().equalsIgnoreCase(genre)) {
                System.out.println("Titel: " + game.getGameNaam() + ", Prijs: " + game.getGamePrijs());
                gamesGevonden = true;
            }
        }

        if (!gamesGevonden) {
            System.out.println("Er zijn geen games gevonden in het genre " + genre + ".");
        }
    }

    public double berekenGemiddeldeScore(Game game) {
        double totaleScore = 0;
        int aantalReviews = game.getReviewLijst().size();

        if (aantalReviews == 0) {
            return 0;
        }

        for (Review review : game.getReviewLijst()) {
            totaleScore += review.getGameplayScore() + review.getGraphicsScore() + review.getStoryScore();
        }

        return totaleScore / (3.0 * aantalReviews);
    }

    public void toonGamesMetKorting() {
        System.out.println("Games met korting:");
        for (Game game : games) {
            double gemiddeldeScore = berekenGemiddeldeScore(game);
            if (gemiddeldeScore > 0 && gemiddeldeScore <= 2) {
                double oudePrijs = game.getGamePrijs();
                double nieuwePrijs = oudePrijs * 0.90;

                System.out.printf("Titel: %s, Oude Prijs: %.2f, Nieuwe Prijs: %.2f\n", game.getGameNaam(), oudePrijs, nieuwePrijs);
            }
        }
    }

}
