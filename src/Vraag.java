import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vraag {

    Scanner scanner = new Scanner(System.in);

    private String[] openVragen = {
            "wat is uw leeftijd?",
            "Welke game trekt u van onze webshop het meest aan?",
            "Zijn er andere soorten games die u in ons voorraad zou willen zien?"};

    private String[] openVragenMetVervolg = {
            "Zou je onze website aanbevelen aan andere voor het achterlaten van reviews? (ja/nee)",
            "Heb je ooit moeilijkheden ondervonden bij het vinden van een specifiek spel in de catalogus? (ja/nee)"};

    private String[] meerkeuzeVragen = {
            "Welke soort games spreekt u het meest aan? (meerdere keuzes mogelijk)",
            "Hoe tevreden ben je over de gebruiksvriendelijkheid voor het achterlaten van reviews? (meerdere keuzes mogelijk)"};
    private String[][] meerkeuzeAntwoorden = {
            {"Actie", "Avontuur", "Horror", "Strategie"},
            {"Zeer tevreden", "Tevreden", "Neutraal", "Ontevreden", "Zeer ontevreden"}
    };

    private List<String> antwoorden = new ArrayList<>();

    public void VragenBeantwoorden() {

        for (String vraag : openVragen) {
            System.out.println(vraag);
            String antwoord = scanner.nextLine();
            antwoorden.add(antwoord);
        }

        for (String vraag : openVragenMetVervolg) {
            System.out.println(vraag);
            String antwoord = scanner.nextLine();
            antwoorden.add(antwoord);

            if (antwoord.equalsIgnoreCase("ja")) {
                System.out.println("Waarom?");
                antwoord = scanner.nextLine();
                antwoorden.add(antwoord);
            }
        }

        for (int i = 0; i < meerkeuzeVragen.length; i++) {
            System.out.println(meerkeuzeVragen[i]);
            for (int j = 0; j < meerkeuzeAntwoorden[i].length; j++) {
                System.out.println((char) ('a' + j) + ") " + meerkeuzeAntwoorden[i][j]);
            }
            System.out.print("Maak keuze (bijv. abc): ");
            String antwoord = scanner.nextLine();
            antwoorden.add(antwoord);
        }
    }

    public List<String> getAntwoorden() {
        return antwoorden;
    }
}
