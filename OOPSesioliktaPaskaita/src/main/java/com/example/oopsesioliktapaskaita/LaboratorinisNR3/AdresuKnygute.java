package com.example.oopsesioliktapaskaita.LaboratorinisNR3;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AdresuKnygute {

    private static final String ADRESU_DUOMENYS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPSesioliktaPaskaita\\src\\main\\resources\\adresai.csv";

    private ArrayList<Adresas> adresai;

    public AdresuKnygute() {
        adresai = new ArrayList<>();
    }

    public void paieskaPagalPavardeIrTelefNumSaliesKoda(String surname, String CountryCode) throws AdresuKnygutesKlaida {
        if (surname != null && surname.equals("")) {
            throw new AdresuKnygutesKlaida("Deja, nurodyta pavarde neegzistuoja!");
        }else if (CountryCode !=null && CountryCode.equals("")){
            throw new AdresuKnygutesKlaida("Deja, nurodytas salies kodas neegzistuoja!");
        }
        getAdresai();
        System.out.println("Paieska pagal Pavarde ir Telefono numerio Salies koda.");
        adresai.forEach(adresas -> {
            if (adresas.getPavarde().equals(surname)
                    && adresas.getTelNumeris().startsWith(CountryCode)) {
                System.out.println(adresas);
            }
        });
    }
    public void rikiavimasPagalPavardeCollectionMetodu() throws AdresuKnygutesKlaida{
        getAdresai();
        System.out.println("Kitas rikiavimo budas naudojant Collections metoda.");
        Collections.sort(adresai,((o1, o2) -> o1.getPavarde().compareTo(o2.getPavarde())));
        adresai.forEach(adresas -> System.out.println(adresas));
    }

    public ArrayList<Adresas> rikiavimasPagalPavardes(SortOrder sortOrder) {
        System.out.println("Rikiavimas pagal pavarde " + sortOrder.name() + " tvarka.");
        if (SortOrder.ASCENDING.equals(sortOrder)) {
            adresai.sort((o1, o2) -> o1.getPavarde().compareTo(o2.getPavarde()));
            adresai.forEach(adresas -> System.out.println(adresas));
        }

        if (SortOrder.DESCENDING.equals(sortOrder)) {
            adresai.sort((o1, o2) -> o2.getPavarde().compareTo(o1.getPavarde()));
            adresai.forEach(adresas -> System.out.println(adresas));
        }
        return adresai;
    }

    public void paieskaPagalVardaPavardeMiesta(String vardas, String pavarde, String city) throws AdresuKnygutesKlaida {
        if (city != null && city.equals("")) {
            throw new AdresuKnygutesKlaida("Deja, nurodytas miestas neegzistuoja!");
        }else if (pavarde !=null && pavarde.equals("")){
            throw new AdresuKnygutesKlaida("Deja, nurodyta pavarde neegzistuoja!");
        }else if (vardas !=null && vardas.equals("")){
            throw new AdresuKnygutesKlaida("Deja, nurodytas vardas neegzistuoja!");
        }

        getAdresai();
        System.out.println("Paieska pagal Varda,Pavarde,Miesta.");
        adresai.forEach(adresas -> {
            if (adresas.getVardas().equals(vardas)
                    && adresas.getPavarde().equals(pavarde)
                    && adresas.getMiestas().equals(city)) {
                System.out.println(adresas);
            }
        });
    }

    public int nurodytoMiestoGyventojuKiekioPaieska(String city) throws AdresuKnygutesKlaida {
        if (city != null && city.equals("")) {
            throw new AdresuKnygutesKlaida("Deja, nurodytas miestas neegzistuoja!");
        }

        getAdresai();
        System.out.println("Nurodyto miesto ( '" + city + "' ) gyventoju kiekio paieska.");
        int counter = 0;

        for (Adresas adresas : adresai) {
            if (adresas.getMiestas().equals(city)) {
                System.out.println(adresas);
                counter++;
            }
        }
        System.out.println(city + " mieste yra: " + counter + " gyventojai.");
        return counter;
    }

    public void pasalintiIsSaraso(Adresas adresas) throws AdresuKnygutesKlaida {
        if (adresas == null) {
            throw new AdresuKnygutesKlaida("Reik nurodyti jau egzistuojanti adresata, kad ji pasalinti!");
        }
        getAdresai();
        System.out.println("Nurodyto adresato salinimas.");
        adresai.removeIf(s -> s.getVardas().equals(adresas.getVardas()) && s.getPavarde().equals(adresas.getPavarde()));
        perkrautiFaila();
        getAdresai();
    }

    public void papildytiSarasa(Adresas adresas) throws AdresuKnygutesKlaida {
        System.out.println("Adresatu papildymas.");
        if (adresas == null) {
            throw new AdresuKnygutesKlaida("Reik nurodyti adresata, kad ji prideti!");
        }
        adresai.add(adresas);
        perkrautiFaila();
        getAdresai();
    }

    private void perkrautiFaila() throws AdresuKnygutesKlaida {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(ADRESU_DUOMENYS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Adresas adresasIsSaraso : adresai) {
                csvPrinter.printRecord(Arrays.asList(adresasIsSaraso.getVardas(), adresasIsSaraso.getPavarde(),
                        adresasIsSaraso.getMiestas(), adresasIsSaraso.getTelNumeris()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new AdresuKnygutesKlaida("Deja, nepavyko irasyti adreso i saraso failiuka", e);
        }
    }

    public void perziuretiAdresus() throws AdresuKnygutesKlaida {
        getAdresai();
        adresai.forEach(adresas -> System.out.println(adresas));
    }


    private void getAdresai() throws AdresuKnygutesKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(ADRESU_DUOMENYS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new AdresuKnygutesKlaida("Deja, nepavyko nuskaityti adresu saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) {
        adresai = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String pavarde = csvRecord.get(1);
            String miestas = csvRecord.get(2);
            String telefNum = csvRecord.get(3);

            adresai.add(new Adresas(vardas, pavarde, miestas, telefNum));
        }
    }
}
