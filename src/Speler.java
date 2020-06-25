import java.util.ArrayList;

class Speler {
    static ArrayList<Integer> worpgeschiedenis = new ArrayList<Integer>();

    Speler() {
        for (int i = 0; i < YahtzeeSpel.dobbelstenen.size(); i++) {
            worpgeschiedenis.add(YahtzeeSpel.dobbelstenen.get(i).x);
        }
    }

}
