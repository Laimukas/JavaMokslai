package exercise.penkt;

public class GameOfLife {

    public static void main(String[] args) {
//        char[][] field = new char[20][50];
//        // random uzpildymas
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                field[i][j] = (Math.random() < 0.2) ? 'X' : '.';
//            }
//        }
        char[][] field = {
                {'.', '.', 'X', '.', '.'},
                {'.', 'X', '.', 'X', '.'},
                {'.', '.', '.', 'X', '.'},
                {'.', '.', '.', 'X', '.'},
                {'.', '.', '.', '.', '.'}
        };
        // spausdinimas
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 50; i++) {

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

    }
}


