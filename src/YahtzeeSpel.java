import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class YahtzeeSpel {
    static ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    boolean exit;
    int blokkeerArray[] = {0, 0, 0, 0, 0};


    void spelen() {
        System.out.println("Yahtzee!\n[ENTER] om te gooien \n[q] om af te sluiten");

        int worpCounter = 0;
        Scanner input = new Scanner(System.in);


        do {

            String userInput = input.nextLine();

            for (Dobbelsteen steen : dobbelstenen) {
                steen.werpen();

            }
            System.out.println("Worp geschiedenis: "+ Speler.worpgeschiedenis);
            worpCounter++;
            System.out.println("WORP" + worpCounter);


            if (userInput.equals("q")) {
                exit = true;
                break;
            }

            System.out.println("[1, 2, 3, 4, 5] <--POSITIE");
            toonWorp().opslaanWorp();

            vasthouden();
            toonGeschiedenis();

        }
        while (!exit);
    }

    void vasthouden() {
        System.out.println("Welke posities wil je vasthouden?");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        for (int i = 0; i < userInput.length(); i++) {
            int indivInput = (Character.getNumericValue(userInput.charAt(i))) - 1;   //uitelkaar halen van het invoer
            for (int j = 0; j < blokkeerArray.length; j++) {
                if (indivInput == j) {                                                //als input gelijk is aan 1-5
                    blokkeerArray[j] = 1;                                           //maak 0 naar 1
                }
            }
        }
        for (int i = 0; i < dobbelstenen.size(); i++) {
            if (blokkeerArray[i] == 0) {
                dobbelstenen.get(i).werpen();
            }
        }
        Arrays.fill(blokkeerArray, 0);
        toonWorp().opslaanWorp();
    }

    Worp toonWorp() {
        return new Worp();
    }

    Speler toonGeschiedenis(){
        return new Speler();
    }


    YahtzeeSpel() {
        for (int i = 0; i < 5; i++) {
            dobbelstenen.add(new Dobbelsteen());
        }
    }
}

class Speler {
    static ArrayList<Integer> worpgeschiedenis = new ArrayList<Integer>();

    Speler() {
        for (int i = 0; i < YahtzeeSpel.dobbelstenen.size(); i++) {
            worpgeschiedenis.add(YahtzeeSpel.dobbelstenen.get(i).x);
        }
    }

}
