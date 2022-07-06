package lt.bit.antr.uzduotis2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    //Simono metodas,atitinkamai reiktu klases atsirinkt ir metodus su prierasu "2"
    public static void main(String[] args) {
        String filePath = "src/lt/bit/antr/uzduotis2/in.txt";
        Scanner sc = new Scanner(System.in);
        System.out.println("Pasirinkite viena is siu skaiciu:");
        System.out.println("1. paziureti visus");
        System.out.println("2. ivesti nauja");
        System.out.println("3. istrinti");
        System.out.println("0. baigti");
        int i = 0;
        do{
            System.out.print("Jusu pasirinkimas: ");
            i = sc.nextInt();
            switch (i) {
                case 0 -> System.out.println("Baigta.");
                case 1 -> rodytiVisus(filePath);
                case 2 -> ivestiNauja(filePath, sc);
                case 3 -> istrintiZmogu(filePath, sc);
                default -> System.out.println("Tokio pasirinkimo nera. Bandykite dar karta.");
            }
        } while(i != 0);
    }
    public static void rodytiVisus(String filePath){
        List<Zmogusss> zmogussses = skaitytiFaila(filePath);
        List<Zmogusss> surusiuotiZmones = rusiuoti(zmogussses);
        for(Zmogusss z : surusiuotiZmones){
            System.out.println(z);
        }
    }
    public static List<Zmogusss> rusiuoti(List<Zmogusss> zmones){
        zmones.sort(Zmogusss::compareTo);
        return zmones;
    }
    public static void ivestiNauja(String filePath, Scanner sc){
        List<Zmogusss> zmogussses = skaitytiFaila(filePath);
        System.out.print("Iveskite varda: ");
        String vardas = sc.next();
        System.out.print("Iveskite pavarde: ");
        String pavarde = sc.next();
        Zmogusss naujasISarasa = new Zmogusss(vardas, pavarde, null);
        naujasISarasa.setId(naujasISarasa.generateUniqueId(zmogussses));
        zmogussses.add(naujasISarasa);
        rasytiFaila(filePath, zmogussses);
    }
    public static void istrintiZmogu(String filePath, Scanner sc){
        System.out.print("Iveskite Id zmogaus, kuri norite istrinti: ");
        Long id = sc.nextLong();
        Zmogusss zmogusToRemove = null;
        List <Zmogusss> zmogussses = skaitytiFaila(filePath);
        for(Zmogusss z : zmogussses){
            if(z.getId().equals(id)){
                zmogusToRemove = z;
            }
        }
        zmogussses.remove(zmogusToRemove);
        rasytiFaila(filePath, zmogussses);
    }
    public static List<Zmogusss> skaitytiFaila(String filePath){
        List<Zmogusss> zmogussses = new ArrayList<>();
        try(
                Reader r = new FileReader(filePath);
                BufferedReader bf = new BufferedReader(r)
        ){
            String line;
            while((line = bf.readLine()) != null){
                String[] lineArr = line.split(" ");
                String vardas = lineArr[0];
                String pavarde = lineArr[1];
                Long id = Long.parseLong(lineArr[2]);
                Zmogusss zmogusss = new Zmogusss(vardas, pavarde, id);
                zmogussses.add(zmogusss);
            }
        } catch (IOException e){
            System.out.println("File not found " + e.getMessage());
        }
        return zmogussses;
    }
    public static void rasytiFaila(String filePath, List<Zmogusss> zmones){
        try(
                Writer w = new FileWriter(filePath);
                BufferedWriter br = new BufferedWriter(w)
        ) {
            for(int i = 0; i < zmones.size(); i++){
                String pilnaZmogausString = zmones.get(i).getVardas()
                        + " " + zmones.get(i).getPavarde()
                        + " " + zmones.get(i).getId();
                if(i < zmones.size() - 1){
                    pilnaZmogausString += "\n";
                }
                br.write(pilnaZmogausString);
            }
        } catch (IOException e){
            System.out.println("File not found " + e.getMessage());
        }
    }
}
