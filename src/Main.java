import java.util.List;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello world!");

        QuestionReader reader = new QuestionReader("<Locatie uit te lezen bestand>");
        List<String> vragen = reader.readAllLines();

        AnswerWriter writer = new AnswerWriter("<Locatie uit te lezen bestand>");
        writer.writeAllLines(List.of("42", "Extra test")); // test

        for (String vraag : vragen) {
            System.out.println(vraag);
        }

    }
}