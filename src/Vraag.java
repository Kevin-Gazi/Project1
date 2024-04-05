import java.util.ArrayList;

public class Vraag {
    private String vraag;
    private ArrayList<String> vervolgVraag;

    public Vraag (String vraag){
        this.vraag = vraag;
        this.vervolgVraag = new ArrayList<>();
    }
    public String getVraag() {
        return vraag;
    }
    public void setVraag (String vraag) {
        this.vraag = vraag;
    }
    public void voegVraagToe(String vervolgVraag) {
        this.vervolgVraag.add(vervolgVraag);
    }
}
