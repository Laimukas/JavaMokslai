package Zmogus;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ZmoniuSarasas {

    private static final String ZMONIU_DUOMENYS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\Zmogus\\src\\main\\resources\\zmones.csv";

    private ArrayList<Zmogus> zmones;

    public ZmoniuSarasas() {
        zmones = new ArrayList<>();
    }

    Scanner scanner = new Scanner(System.in);

    public void rikiavimasPagalVardaCollectionMetodu() throws ZmoniuSarasoKlaidos{
        getZmones();
        System.out.println("Rikiavimo budas naudojant Collections metoda.");
        Collections.sort(zmones,((o1, o2) -> o1.getVardas().compareTo(o2.getVardas())));
        zmones.forEach(zmogus -> System.out.println(zmogus));
    }

    public void pasalintiIsSaraso() throws ZmoniuSarasoKlaidos {
        getZmones();
        System.out.println("Kuri zmogu salinam?");
        System.out.print("Vardas: ");
        String vardas = scanner.nextLine();
        System.out.print("Pavarde: ");
        String pavarde = scanner.nextLine();
        Zmogus zmogus = new Zmogus(vardas,pavarde);
        if (zmogus == null) {
            throw new ZmoniuSarasoKlaidos("Reik nurodyti jau egzistuojanti zmogu, kad ji pasalinti!");
        }

        System.out.println("Nurodyto zmogaus salinimas.");
        zmones.removeIf(z -> z.getVardas().equals(zmogus.getVardas()) && z.getPavarde().equals(zmogus.getPavarde()));
        perkrautiFaila();
        getZmones();
    }

    public void papildytiSarasa() throws ZmoniuSarasoKlaidos {
        getZmones();
        System.out.println("Irasykite naujoko duomenis!");
        System.out.print("Vardas: ");
        String vardas = scanner.nextLine();
        System.out.print("Pavarde: ");
        String pavarde = scanner.nextLine();
        Zmogus zmogus = new Zmogus(vardas,pavarde);
        System.out.println("Zmoniu papildymas.");
        if (zmogus == null) {
            throw new ZmoniuSarasoKlaidos("Reik nurodyti zmogu, kad ji prideti!");
        }
        zmones.add(zmogus);
        perkrautiFaila();
        getZmones();
    }

    private void perkrautiFaila() throws ZmoniuSarasoKlaidos {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(ZMONIU_DUOMENYS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Zmogus zmogusIsSaraso : zmones) {
                csvPrinter.printRecord(Arrays.asList(zmogusIsSaraso.getVardas(), zmogusIsSaraso.getPavarde()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new ZmoniuSarasoKlaidos("Deja, nepavyko irasyti zmogaus i saraso failiuka", e);
        }
    }

    public void perziuretiZmones() throws ZmoniuSarasoKlaidos {
        rikiavimasPagalVardaCollectionMetodu();
        zmones.forEach(zmogus -> System.out.println(zmogus));
    }

    private void getZmones() throws ZmoniuSarasoKlaidos {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ZMONIU_DUOMENYS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new ZmoniuSarasoKlaidos("Deja, nepavyko nuskaityti adresu saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) {
        zmones = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String pavarde = csvRecord.get(1);

            zmones.add(new Zmogus(vardas, pavarde));
        }
    }
}
