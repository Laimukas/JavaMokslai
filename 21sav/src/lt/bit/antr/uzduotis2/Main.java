package lt.bit.antr.uzduotis2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 *
 * VYTO GADLIAUSKO VARIJANTAS
 *
 * zmoniu sarasas
 * <p>
 * programa duoda pasirinkima:
 * 1. paziureti visus
 * 2. ivesti nauja
 * 3. istrinti
 * 0. baigti
 * <p>
 * 1. perskaito is failo zmoniu sarasa,
 * surusiuoja pagal varda (jei vardai vienodi, tai pagal pavarde)
 * atspausdina i ekrana
 * 2. papraso ivesti varda ir pavarde
 * prideda ivesta zmogu prie esamo zmoniu saraso (faile)
 * 3. papraso nurodyti zmogu, kuri reikia istrinti
 * (reikia patiems sugalvoti buda, kaip nurodyti)
 * istrina is failo nurodyta zmogu
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("src/lt/bit/antr/uzduotis2/zmones.obj");
        Scanner scanner = new Scanner(System.in);
        if (file != null) {
            ArrayList<Zmogus> zmones = readFile(file);
            int komanda = 10;
            while (komanda != 0) {
                printMeniu();
                komanda = Integer.parseInt(scanner.nextLine());
                switch (komanda) {
                    case 1:
                        printZmones(zmones);
                        break;
                    case 2:
                        zmones.add(ivestiZmogu(scanner));
                        break;
                    case 3:
                        istrintiZmogu(zmones,scanner);
                        break;
                    case 0:
                        writeFile(file,zmones);
                }
            }
        } else {
            System.out.println("Klaida nuskaitant duomenu faila");
        }
    }
    public static ArrayList<Zmogus> istrintiZmogu(ArrayList<Zmogus> zmones,Scanner scanner){
        System.out.print("Vardas: ");
        String vardas = scanner.nextLine();
        System.out.print("Pavarde: ");
        String pavarde = scanner.nextLine();
        for (int i = 0; i < zmones.size(); i++) {
            if(vardas.equals(zmones.get(i).getVardas()) && pavarde.equals(zmones.get(i).getPavarde())){
                zmones.remove(zmones.get(i));
            }
        }
        return zmones;
    }
    public static Zmogus ivestiZmogu(Scanner scanner){
        System.out.print("Vardas: ");
        String vardas = scanner.nextLine();
        System.out.print("Pavarde: ");
        String pavarde = scanner.nextLine();
        Zmogus zmogus = new Zmogus(vardas,pavarde);
        return zmogus;
    }
    public static void printZmones(ArrayList<Zmogus> zmones) {
        System.out.println("----------Zmoniu sarasas-----------");
        Comparator<Zmogus> compareByVardas = Comparator.comparing( Zmogus::getVardas );
        Comparator<Zmogus> compareByPavarde = Comparator.comparing( Zmogus::getPavarde );
        Comparator<Zmogus> comparator = compareByVardas.thenComparing(compareByPavarde);
        ArrayList<Zmogus> zmonesSorted = (ArrayList<Zmogus>) zmones.stream().sorted(comparator).collect(Collectors.toList());
        zmonesSorted.forEach(el -> System.out.println(el));
        System.out.println("zmoniu skaicius: "+zmones.size());
    }
    public static ArrayList<Zmogus> readFile(File file) {
        ArrayList<Zmogus> zmones = null;
        if (file.length() == 0) {
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                zmones = new ArrayList<>();
                oos.writeObject(zmones);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            zmones = (ArrayList<Zmogus>) ois.readObject();
            if (zmones == null) {
                zmones = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return zmones;
    }
    public static void writeFile(File file, ArrayList<Zmogus> zmones) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(zmones);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printMeniu() {
        System.out.println("---------------------Menu------------------");
        System.out.println(" 1. paziureti visus");
        System.out.println(" 2. ivesti nauja");
        System.out.println(" 3. istrinti");
        System.out.println(" 0. baigti");
        System.out.print("Iveskite pasirinkima: ");
    }
}
