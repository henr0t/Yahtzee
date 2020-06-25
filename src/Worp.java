import java.util.Arrays;

class Worp {
    int worpUitslag[] = new int[5];

    void opslaanWorp() {
        Worp gooi = new Worp();
        for (int i = 0; i < gooi.worpUitslag.length; i++) {
            gooi.worpUitslag[i] = YahtzeeSpel.dobbelstenen.get(i).x;
        }
        System.out.println(Arrays.toString(gooi.worpUitslag) + " <--DOBBELSTENEN");
    }
}
