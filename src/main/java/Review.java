import java.util.ArrayList;

public class Review {
    private int gameplayScore;
    private int graphicsScore;
    private int storyScore;
    private String toelichting;
    ArrayList <Vraag> vragen;

    public Review (int gameplayScore, int graphicsScore, int storyScore, String toelichting){
        this.gameplayScore = gameplayScore;
        this.graphicsScore = graphicsScore;
        this.storyScore = storyScore;
        this.toelichting = toelichting;
        this.vragen = new ArrayList<>();
    }

    public int getGameplayScore() {
        return gameplayScore;
    }

    public int getGraphicsScore() {
        return graphicsScore;
    }

    public int getStoryScore() {
        return storyScore;
    }

    public String getToelichting()   {
        return toelichting;
    }
}
