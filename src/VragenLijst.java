import java.util.ArrayList;
import java.util.Scanner;

public class VragenLijst {
    private ArrayList<Vraag> vragen;

    public VragenLijst() {
        vragen = new ArrayList<>();

        vragen.add(new MeerkeuzeVragen("1.\tHoe tevreden ben je over de gebruiksvriendelijkheid van de website van Good ol’ games voor het achterlaten van reviews?", new String[]{"Zeer tevreden", "Tevreden", "Neutraal", "Ontevreden", "Zeer ontevreden"}));
        vragen.add(new MeerkeuzeVragen("2.\tHoe nuttig vind je de informatie die wordt verstrekt over de games in de catalogus van Good ol' games?", new String[]{"Zeer nuttig", "Nuttig", "Niet erg nuttig", "Helemaal niet nuttig"}));
        vragen.add(new Vraag("2a.\tZou je onze website aanbevelen aan andere voor het achterhalen van reviews? (Dit is een Open Vraag)"));
        vragen.add(new MeerkeuzeVragen("3.\tWat motiveerde je om een review achter te lante op de website van Good ol’ games?", new String[]{"Aanbeveling van een vriend", "Eerdere ervaring met het spel", "Nieuwsgierigheid naar de meningen van anderen"}));
        vragen.add(new Vraag("4.\tHeb je ooit moeilijkheden ondervonden bij het vinden vaan een specifiek spel in de catalogus? (Ja (indien ja, gelieve te specificeren, nee)"));
        vragen.add(new MeerkeuzeVragen("5.\tWelke soorten games zou je graag vaker willen zien in de catalogus van Good ol’ games?", new String[]{"Avontuur", "Strategie", "Role-Playing", "Simulatie"}));

    }
        public void voegVraagToe(Vraag vraag){
            vragen.add(vraag);
        }

        public void vragenLijst () {
            Scanner scanner = new Scanner(System.in);
            for (Vraag vraag : vragen) {
                System.out.println(vraag.getVraag());

                // Controleer of het een MeerkeuzeVraag is
                if (vraag instanceof MeerkeuzeVragen) {
                    MeerkeuzeVragen mcVraag = (MeerkeuzeVragen) vraag;
                    System.out.println("Opties:");
                    for (int i = 0; i < mcVraag.getOpties().length; i++) {
                        System.out.println((i + 1) + ". " + mcVraag.getOpties()[i]);
                    }
                    System.out.print("Antwoord (1-" + mcVraag.getOpties().length + "): ");
                    int keuze = scanner.nextInt();
                    scanner.nextLine(); // Om de rest van de regel te verwijderen
                    vraag.setAntwoord(mcVraag.getOpties()[keuze - 1]);
                } else { // Als het geen meerkeuzevraag is, open vraag
                    System.out.print("Antwoord: ");
                    String antwoord = scanner.nextLine();
                    vraag.setAntwoord(antwoord);


                }
            }
        }


    }

