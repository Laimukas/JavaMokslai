package exercise.penkt;

public class GameOfLife {

    public static void main(String[] args) {
        char[][] field = new char[20][50];
        // random uzpildymas
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = (Math.random() < 0.2) ? 'X' : '.';
            }
        }
//        char[][] field = {
//            {'.', '.', '.', '.', '.'},
//            {'Х', '.', '.', 'X', '.'},
//            {'Х', '.', '.', 'X', '.'},
//            {'.', '.', '.', 'X', '.'},
//            {'.', '.', '.', '.', '.'}
//        };
        // spausdinimas
        System.out.println("0-------------------------");
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                System.out.print(field[y][x]);
            }
            System.out.println();
        }
        char[][][] history = new char[50][field.length][field[0].length];
        for (int i = 0; i < 50; i++) {
            // sukurem nauja lauka
            char[][] newField = new char[field.length][field[0].length];
            // einam per kiekviena langeli ir uzpildom nauja lauka
            for (int y = 0; y < field.length; y++) {
                for (int x = 0; x < field[y].length; x++) {
                    // skaiciuojam kaimynus aplink laukeli y x
                    int kaimynai = 0;
                    if (y > 0) {
                        kaimynai += (x > 0 && field[y - 1][x - 1] == 'X') ? 1 : 0;
                        kaimynai += field[y - 1][x] == 'X' ? 1 : 0;
                        kaimynai += (x < field[y].length - 1 && field[y - 1][x + 1] == 'X') ? 1 : 0;
                    }
                    kaimynai += (x > 0 && field[y][x - 1] == 'X') ? 1 : 0;
                    kaimynai += (x < field[y].length - 1 && field[y][x + 1] == 'X') ? 1 : 0;
                    if (y < field.length - 1) {
                        kaimynai += (x > 0 && field[y + 1][x - 1] == 'X') ? 1 : 0;
                        kaimynai += field[y + 1][x] == 'X' ? 1 : 0;
                        kaimynai += (x < field[y].length - 1 && field[y + 1][x + 1] == 'X') ? 1 : 0;
                    }
                    // pazymim naujame lauke
                    if (field[y][x] == 'X') {
                        newField[y][x] = (kaimynai == 2 || kaimynai == 3) ? 'X' : '.';
                    } else {
                        newField[y][x] = (kaimynai == 3) ? 'X' : '.';
                    }
                }
            }
// sprendimas su *
//            // lyginam sena ir nauja iteracijas
//            boolean vienodos = true;
//            for (int y = 0; y < field.length && vienodos; y++) {
//                for (int x = 0; x < field[y].length && vienodos; x++) {
//                    if (field[y][x] != newField[y][x]) {
//                        vienodos = false;
//                    }
//                }
//            }
//            // jei iteracijos vienodos - nutraukiam cikla
//            if (vienodos) {
//                System.out.println(i + " iteracija tokia pati");
//                break;
//            }
// sprendimas su *
// sprendimas su **
            // padedam i istorija
            history[i] = field;
            // tikrinam su istoriniais laukais
            int j;
            for (j = i; j >= 0; j--) {
                boolean vienodos = true;
                for (int y = 0; y < history[j].length && vienodos; y++) {
                    for (int x = 0; x < history[j][y].length && vienodos; x++) {
                        if (history[j][y][x] != newField[y][x]) {
                            vienodos = false;
                        }
                    }
                }
                if (vienodos) {
                    break;
                }
            }
            // jei pries tai buves ciklas suveike pilnai t.y. j pasidare -1
            if (j >= 0) {
                System.out.println((i + 1) + " iteracija tokia pati, kaip ir " + j + " iteracija");
                break;
            }
// sprendimas su **
            // ismetam sena lauka ir naudosim nauja
            field = newField;
//            // isvalo ekrana (IDE neveikia)
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
            // spausdinimas
            System.out.println((i + 1) + "-------------------------");
            for (int y = 0; y < field.length; y++) {
                for (int x = 0; x < field[y].length; x++) {
                    System.out.print(field[y][x]);
                }
                System.out.println();
            }
//            // pamiega 0.2 sekundes
//            try {
//                Thread.sleep(200);
//            } catch (Exception ex) {
//                // ignored
//            }
        }
    }
}
/*
sugeneruoti 50 iteraciju
*) - sustabdyti iteracijas, jei naujai sugeneruota iteracija yra identiska pries tai buvusiai
**)- sustabdyti iteracijas, jei naujai sugeneruota iteracija buvo istorijoje
jei pries tai buvusioj iteracijoj langelyje nebuvo gyventojo:
naujoj iteracijoj gyventojas atsiras, jei senoj buvo 3 kaimynai
naujoj iteracijoj gyventojas neatsiras, jei senoj buvo maziau nei 3 arba daugiau nei 3 kaimynai
jei pries tai buvusioj iteracijoj langelyje buvo gyventojas:
naujoj iteracijoj gyventojas liks gyventi, jei senoj buvo 2 arba 3 kaimynai
naujoj iteracijoj gyventojas mirs (nebus), jei senoj buvo maziau nei 2 arba daugiau nei 3 kaimynai
*/