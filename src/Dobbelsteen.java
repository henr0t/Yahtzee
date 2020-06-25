import java.util.Random;

class Dobbelsteen {
    int werpVast;
    int x;

    int werpen() {
        Random rnd = new Random();
        x = rnd.nextInt(6) + 1;
        opslaan(x);
        return x;

    }

    public String toString() {
        return x + "";
    }

    void opslaan(int worp) {
        werpVast = worp;
    }
}
