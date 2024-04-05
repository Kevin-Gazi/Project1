import java.util.ArrayList;

public class Vraag {
    private String vraag;
    private ArrayList<String> vervolgVraag = new ArrayList<>();

    public Vraag (String vraag){
        this.vraag = vraag;
    }
    public String getVraag() {
        return vraag;
    }
    public void setVraag (String vraag) {
        this.vraag = vraag;
    }
    public void voegVraagToe() {
        vervolgVraag.add(vraag);

    }

}
