package lt.bit.ketv;
//perskaityti tekstini faila (daug eiluciu)
//atspausdinti kiekviena eilute
//atspausdinti eiluciu (ilgesniu nei 30 simboliu) kieki
//atspausdinti raidziu kieki zodziuose, kurie yra ilgesni, nei 5 raides

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Run2 {

    // Vyto varijantas

    public static void main(String[] args) throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("src/lt/bit/ketv/tekstas.txt");
             Reader r = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(r);
        ) {
            List<String> l = new ArrayList<>();
            String s;
            while ((s = br.readLine()) != null) {
                l.add(s);
            }
            System.out.println("Kiekviena eilute:");
            l.stream().forEach(el -> System.out.println(el));
            System.out.println("----------------");
            System.out.print("Eilutciu ilgesniu nei 30 simboliu, kiekis yra: ");
            System.out.println(l.stream().filter(el -> el.length() >= 30).count());
            System.out.println("Raidziu kiekis ilgesniuose nei 5 raides zodziuose: ");
            l.stream().forEach(line -> {
                String[] zodziai = line.split(" ");
                for (int i = 0; i < zodziai.length; i++) {
                    if (zodziai[i].length() > 5) {
                        System.out.println(zodziai[i] + " " + zodziai[i].length());
                    }
                }
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}