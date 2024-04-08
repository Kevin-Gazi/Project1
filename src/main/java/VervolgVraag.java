import java.util.Scanner;

class VervolgVraag extends Vraag {
    private boolean vervolg;

    public VervolgVraag(String vraag) {
        super(vraag);
        this.vervolg = false;
    }

    public void vraagVervolgVraag() { //
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aan wat moet u denken? ");
        String antwoord = scanner.nextLine();
        this.vervolg = true;
        super.setAntwoord(antwoord);
    }

    public String getvraagVervolgVraag() {
        if (vervolg) {
            return super.getAntwoord();
        }
        return "";
    }
}