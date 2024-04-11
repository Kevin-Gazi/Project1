import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogusTest {
    @Test
    public void testVoegGameToe() {
        Catalogus catalogus = new Catalogus();
        Game game = new Game("TestGame", "TestGenre", 10.0);

        catalogus.voegGameToe(game);
        ArrayList<Game> games = catalogus.games;

        Assertions.assertTrue(games.contains(game));
    }

    @Test
    public void testBerekenGemiddeldeScore() {
        Catalogus catalogus = new Catalogus();
        Game game = new Game("TestGame", "TestGenre", 10.0);
        Review review1 = new Review(4, 5, 3, "TestReview1");
        Review review2 = new Review(2, 3, 4, "TestReview2");

        game.voegReviewToe(review1);
        game.voegReviewToe(review2);

        catalogus.voegGameToe(game);

        double expectedAverageScore = (4 + 5 + 3 + 2 + 3 + 4) / (3.0 * 2); // Gemiddelde van alle scores
        double actualAverageScore = catalogus.berekenGemiddeldeScore(game);

        Assertions.assertEquals(expectedAverageScore, actualAverageScore);
    }

}