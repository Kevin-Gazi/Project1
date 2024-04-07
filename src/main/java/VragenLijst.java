import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VragenLijst {
    private ArrayList<Vraag> vragen;

    public VragenLijst() {
        vragen = new ArrayList<>();

        vragen.add(new MeerkeuzeVragen("1.\tHoe tevreden ben je over de gebruiksvriendelijkheid van de website van Good ol’ games voor het achterlaten van reviews?", new String[]{"Zeer tevreden", "Tevreden", "Neutraal", "Ontevreden", "Zeer ontevreden"}));
        vragen.add(new MeerkeuzeVragen("2.\tHoe nuttig vind je de informatie die wordt verstrekt over de games in de catalogus van Good ol' games?", new String[]{"Zeer nuttig", "Nuttig", "Niet erg nuttig", "Helemaal niet nuttig"}));
        vragen.add(new Vraag("2a.\tZou je onze website aanbevelen aan andere voor het achterhalen van reviews? (Dit is een Open Vraag)"));
        vragen.add(new MeerkeuzeVragen("3.\tWat motiveerde je om een review achter te laten op de website van Good ol’ games?", new String[]{"Aanbeveling van een vriend", "Eerdere ervaring met het spel", "Nieuwsgierigheid naar de meningen van anderen"}));
        vragen.add(new Vraag("4.\tHeb je ooit moeilijkheden ondervonden bij het vinden van een specifiek spel in de catalogus? (Ja, gelieve te specificeren, nee)"));
        vragen.add(new MeerkeuzeVragen("5.\tWelke soorten games zou je graag vaker willen zien in de catalogus van Good ol’ games?", new String[]{"Avontuur", "Strategie", "Role-Playing", "Simulatie"}));
    }

    public void voegVraagToe(Vraag vraag) {
        vragen.add(vraag);
    }

    public void vragenLijst() {
        Scanner scanner = new Scanner(System.in);

        for (Vraag vraag : vragen) {
            System.out.println(vraag.getVraag());

            if (vraag instanceof MeerkeuzeVragen) {
                MeerkeuzeVragen mkVraag = (MeerkeuzeVragen) vraag;
                System.out.println("Opties:");
                for (int i = 0; i < mkVraag.getOpties().length; i++) {
                    System.out.println((i + 1) + ". " + mkVraag.getOpties()[i]);
                }

                int keuze = -1;

                while (keuze == -1) {
                    System.out.print("Antwoord (1-" + mkVraag.getOpties().length + "): ");
                    keuze = scanner.nextInt();
                    scanner.nextLine();

                    if (keuze < 1 || keuze > mkVraag.getOpties().length) {
                        System.out.println("Het cijfer moet tussen 1 en " + mkVraag.getOpties().length + " liggen. Voer een nieuw cijfer in.");
                        keuze = -1;
                    }
                }

                vraag.setAntwoord(mkVraag.getOpties()[keuze - 1]);
            } else {
                System.out.print("Antwoord: ");
                String antwoord = scanner.nextLine();
                vraag.setAntwoord(antwoord);
                System.out.println();
            }
        }

        schrijfNaarCsv("src/main/resources/VragenLijst.csv");
        System.out.println("Bedankt voor het invullen van de vragenlijst!");
    }

    public void schrijfNaarCsv(String csvBestand) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvBestand))) {
            for (Vraag vraag : vragen) {
                writer.writeNext(new String[]{vraag.getVraag(), vraag.getAntwoord()});
                writer.writeNext(new String[]{""});
            }
            System.out.println("De vragenlijst is opgeslagen in " + csvBestand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
