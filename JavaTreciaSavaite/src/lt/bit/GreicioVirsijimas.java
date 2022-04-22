package lt.bit;
// Programa skaiciuos ar jus virsijote greiti esant vidutinio greicio atkarpoje kameroms.

import java.util.Scanner;

public class GreicioVirsijimas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Koks leistinas greitis atkarpoje? ");
        double leistinasGreitis = in.nextDouble();
        System.out.println("Koks yra atstumas tarp greiti matuojanciu kameru (km.)? ");
        double atstumasTarpKameru = in.nextDouble();
        System.out.println("Iveskite laika, per kuri iveiket greicio ribojimo atkarpa (sek.): ");
        double laikasPerKuriIveiketAtstuma = in.nextDouble();
        double jusuGreicioVidurkis = atstumasTarpKameru / (laikasPerKuriIveiketAtstuma / 3600);
        double greiciuSkirtumas = jusuGreicioVidurkis - leistinasGreitis;
        if (greiciuSkirtumas <= 0) {
            System.out.println("Leistinas greitis: " + leistinasGreitis + " km/val. Jus vaziavote: " + jusuGreicioVidurkis + " km/val. Jus greicio nevirsijote. Liuks!!!");
        } else if (greiciuSkirtumas > 50) {
            System.out.println("Leistinas greitis: " + leistinasGreitis + " km/val. Jus vaziavote: " + jusuGreicioVidurkis + " km/val. Tu virsijai greiti: " + greiciuSkirtumas + " km/val. Pristabdyk arklius!!!");
        } else {
            System.out.println("Leistinas greitis: " + leistinasGreitis + " km/val. Jus vaziavote: " + jusuGreicioVidurkis + " km/val. Jus virsijote greiti: " + greiciuSkirtumas + " km/val. Elkis kelyje atsakingai!!!");
        }
    }
}
