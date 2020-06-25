import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class YahtzeeSpel {
    static ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    boolean exit;
    boolean spelerBeurt;
    int blokkeerArray[] = {0, 0, 0, 0, 0};

    void spelen() {
        System.out.println("Yahtzee!\n[ENTER] om te gooien \n[q] om af te sluiten");

        Speler speler = null;
        Speler speler1 = new Speler();
        Speler speler2 = new Speler();

        Scanner input = new Scanner(System.in);

        do {
            if (spelerBeurt) {
                speler = speler2;
                System.out.println("\nSpeler 2 is aan de beurt:");
            } else if (!spelerBeurt) {
                speler = speler1;
                System.out.println("\nSpeler 1 is aan de beurt:");
            }

            int worpCounter = 0;
            String userInput = input.nextLine();

            if (userInput.equals("q")) {
                exit = true;
                break;
            }

            for (Dobbelsteen steen : dobbelstenen) {
                steen.werpen();

            }

            while (worpCounter < 4) {
                worpCounter++;
                System.out.println("WORP" + worpCounter);

                toonWorp().opslaanWorp();
                vasthouden();
            }
            toonWorp().opslaanWorp();
            Geschiedenis(speler);

            if (spelerBeurt) {
                spelerBeurt = false;
            } else if (!spelerBeurt) {
                spelerBeurt = true;
            }

        }
        while (!exit);
    }

    void vasthouden() {
        System.out.println("Welke posities wil je vasthouden?");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        for (int i = 0; i < userInput.length(); i++) {
            int indivInput = (Character.getNumericValue(userInput.charAt(i))) - 1;      //uitelkaar halen van het invoer
            for (int j = 0; j < blokkeerArray.length; j++) {
                if (indivInput == j) {                                                  //als input gelijk is aan 1-5
                    blokkeerArray[j] = 1;                                               //maak 0 naar 1
                }
            }
        }
        for (int i = 0; i < dobbelstenen.size(); i++) {
            if (blokkeerArray[i] == 0) {
                dobbelstenen.get(i).werpen();
            }
        }
        Arrays.fill(blokkeerArray, 0);
    }

    Worp toonWorp() {
        return new Worp();
    }

    Speler Geschiedenis(Speler speler) {
        for (int i = 0; i < YahtzeeSpel.dobbelstenen.size(); i++) {
            speler.worpgeschiedenis.add(YahtzeeSpel.dobbelstenen.get(i).x);
        }
        System.out.println("GESCHIEDENIS: \n" + speler.worpgeschiedenis);
        return new Speler();
    }

    YahtzeeSpel() {
        for (int i = 0; i < 5; i++) {
            dobbelstenen.add(new Dobbelsteen());
        }
    }
}