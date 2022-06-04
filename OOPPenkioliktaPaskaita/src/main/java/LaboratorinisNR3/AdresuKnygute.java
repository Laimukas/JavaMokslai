package LaboratorinisNR3;

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

public class AdresuKnygute {

    private static final String ADRESU_DUOMENYS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPPenkioliktaPaskaita\\src\\main\\resources\\adresai.csv";

    private ArrayList<Adresas> adresai;

    public AdresuKnygute() {
        adresai = new ArrayList<>();
    }

    public void paieskaPagalPavardeIrTelefNumSaliesKoda(String surname, String CountryCode) throws AdresuKnygutesKlaida {
        getAdresai();
        System.out.println("Paieska pagal Pavarde ir Telefono numerio Salies koda.");
        adresai.forEach(adresas -> {
            if (adresas.getPavarde().equals(surname)
                    && adresas.getTelNumeris().startsWith(CountryCode)) {
                System.out.println(adresas);
            }
        });
    }

    public ArrayList<Adresas> rikiavimasPagalPavardes(SortOrder sortOrder) {
        System.out.println("Rikiavimas pagal pavarde "+sortOrder.name()+ " tvarka.");
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

    public void nurodytoMiestoGyventojuKiekioPaieska(String city) throws AdresuKnygutesKlaida {
        getAdresai();
        System.out.println("Nurodyto miesto gyventoju kiekio paieska.");
        int counter = 0;

        for (Adresas adresas : adresai) {
            if (adresas.getMiestas().equals(city)) {
                System.out.println(adresas);
                counter++;
            }
        }
        System.out.println(city+" mieste yra: " + counter + " gyventojai.");
    }

    public void pasalintiIsSaraso(Adresas adresas) throws AdresuKnygutesKlaida {
        getAdresai();
        System.out.println("Nurodyto adresato salinimas.");
        adresai.removeIf(s -> s.getVardas().equals(adresas.getVardas()) && s.getPavarde().equals(adresas.getPavarde()));
        perkrautiFaila();
        getAdresai();
    }

    public void papildytiSarasa(Adresas adresas) throws AdresuKnygutesKlaida {
        System.out.println("Adresatu papildymas.");
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

    private void nuskaitytiNuoFailo(CSVParser csvParser) throws AdresuKnygutesKlaida {
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
