import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testGetReviewLijst() {
        Game game = new Game("TestGame", "TestGenre", 10.0);

        Review review1 = new Review(4, 5, 3, "TestReview1");
        Review review2 = new Review(2, 3, 4, "TestReview2");
        game.voegReviewToe(review1);
        game.voegReviewToe(review2);

        // Controleer of de reviewlijst correct wordt gegeven
        ArrayList<Review> expectedReviewList = new ArrayList<>();
        expectedReviewList.add(review1);
        expectedReviewList.add(review2);
        Assertions.assertEquals(expectedReviewList, game.getReviewLijst());
    }
}