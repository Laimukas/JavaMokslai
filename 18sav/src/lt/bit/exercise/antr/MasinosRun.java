package lt.bit.exercise.antr;

public class MasinosRun {
    public static void main(String[] args) {
        Masina[] masinos = {
                new Masina("Ford", 220),
                new Masina("BMW", 260),
                new Masina("Audi", 250),
                new Masina("Mercedes", 260),
                new Masina("Lexus", 250),
                new Masina("Saab", 210),
                new Masina("Volkswagen", 220),
                new Masina("Ferrari", 280)
        };

        int ratas = 1;
        boolean lenktynesBaigesi = false;
        while (!lenktynesBaigesi) {
            // keiciasi masinu greitis (gazuoja/pristabdo)
            for (int i = 0; i < masinos.length; i++) {
                int pasikeitimas = atsitiktinis(-3, 10);
                if (pasikeitimas > 0) {
                    masinos[i].gazas(pasikeitimas);
                } else {
                    masinos[i].stabdis(-pasikeitimas);
                }
            }
            // masinos vaziuoja
            for (int i = 0; i < masinos.length; i++) {
                masinos[i].vaziuojam();
            }
            // komentatorius ir lyderis
            int lyderis = 0;
            for (int i = 1; i < masinos.length; i++) {
                if (masinos[i].getKelias() > masinos[lyderis].getKelias()) {
                    lyderis = i;
                }
            }
            if (masinos[lyderis].getKelias() > ratas * 200) {
                System.out.println("Po " + (ratas * 200) + " pirmauja " + masinos[lyderis].getPavadinimas());
                System.out.println("Jis nuvaziavo " + masinos[lyderis].getKelias());
                System.out.println("Jo greitis " + masinos[lyderis].getGreitis());
                System.out.println("_________________________________________________________________________________");
                ratas++;
            }
            // ieskom kada kas nors nuvaziuoja 3000 ir baigiam lenktynes
            for (int i = 0; i < masinos.length; i++) {
                if (masinos[i].getKelias() >= 3000) {
                    lenktynesBaigesi = true;
                    break;
                }
            }
        }
        // surandam laimetoja
        int laimetojas = 0;
        for (int i = 1; i < masinos.length; i++) {
            if (masinos[i].getKelias() > masinos[laimetojas].getKelias()) {
                laimetojas = i;
            }
        }

        System.out.println("Laimejo " + masinos[laimetojas].getPavadinimas());
        System.out.println("Jis nuvaziavo " + masinos[laimetojas].getKelias());
        System.out.println("Jo greitis " + masinos[laimetojas].getGreitis());
    }

    public static int atsitiktinis(int nuo, int iki) {
        if (nuo > iki) {
            int tmp = nuo;
            nuo = iki;
            iki = tmp;
        }
        return (int) (Math.random() * (iki - nuo + 1) + nuo);
    }
}
