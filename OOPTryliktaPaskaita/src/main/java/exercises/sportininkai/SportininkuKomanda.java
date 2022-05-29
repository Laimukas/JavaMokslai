package exercises.sportininkai;

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

public class SportininkuKomanda {

    private static final String SPORTININKU_SARASAS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPTryliktaPaskaita\\src\\main\\resources\\sportininkai.csv";

    private ArrayList<Sportininkas> sportininkai;

    public SportininkuKomanda() {
        sportininkai = new ArrayList<>();
    }

    public void paieskaPagalVardaPavardeKomanda(String vardas, String pavarde, String komanda) throws SportininkuKomanduKlaida {
        getSportininkai();
        sportininkai.forEach(sportininkas -> {
            if (sportininkas.getVardas().equals(vardas)
                    && sportininkas.getPavarde().equals(pavarde)
                    && sportininkas.getKomandosPavadinimas().equals(komanda)) {
                System.out.println(sportininkas);
            }
        });
    }

    public void didziausioNarioPaieskaNurodziusKomanda(String komanda) throws SportininkuKomanduKlaida {
        getSportininkai();
        int maxUgis = 0;
        Sportininkas auksciausias = null;
        for (Sportininkas sportininkas : sportininkai) {
            if (sportininkas.getKomandosPavadinimas().equals(komanda) && maxUgis < sportininkas.getUgis()) {
                maxUgis = sportininkas.getUgis();
                if (sportininkas.getKomandosPavadinimas().equals(komanda) && maxUgis == sportininkas.getUgis()) {
                    auksciausias = sportininkas;
                }
            }
        }
        System.out.println(auksciausias);
    }

    public void komandosSarasasPagalPavadinimaPateikiantIrNariuKieki(String komanda) throws SportininkuKomanduKlaida {
        getSportininkai();
        int counter = 0;

        for (Sportininkas sportininkas : sportininkai) {
            if (sportininkas.getKomandosPavadinimas().equals(komanda)) {
                System.out.println(sportininkas);
                counter++;
            }
        }
        System.out.println("Komandoje yra: " + counter + " nariai.");
    }

    public void pasalintiIsSaraso(Sportininkas sportininkas) throws SportininkuKomanduKlaida {
        getSportininkai();
        sportininkai.removeIf(s -> s.getVardas().equals(sportininkas.getVardas()) && s.getPavarde().equals(sportininkas.getPavarde()));
        perkrautiFaila();
        getSportininkai();
    }

    public void papildytiSarasa(Sportininkas sportininkas) throws SportininkuKomanduKlaida {
        sportininkai.add(sportininkas);
        perkrautiFaila();
        getSportininkai();
    }

    private void perkrautiFaila() throws SportininkuKomanduKlaida {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SPORTININKU_SARASAS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Sportininkas sportininkasIsSaraso : sportininkai) {
                csvPrinter.printRecord(Arrays.asList(sportininkasIsSaraso.getVardas(), sportininkasIsSaraso.getPavarde(),
                        sportininkasIsSaraso.getKomandosPavadinimas(), sportininkasIsSaraso.getUgis(),
                        sportininkasIsSaraso.getSvoris()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new SportininkuKomanduKlaida("Deja, nepavyko irasyti sportininko i saraso failiuka", e);
        }

    }

    public void perziuretiSportininkus() throws SportininkuKomanduKlaida {
        getSportininkai();
        sportininkai.forEach(sportininkas -> System.out.println(sportininkas));
    }


    private void getSportininkai() throws SportininkuKomanduKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SPORTININKU_SARASAS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new SportininkuKomanduKlaida("Deja, nepavyko nuskaityti sportininku saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) throws SportininkuKomanduKlaida {
        sportininkai = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String pavarde = csvRecord.get(1);
            String komandosName = csvRecord.get(2);

            int ugis;
            double svoris;

            try {
                ugis = Integer.parseInt(csvRecord.get(3));
                svoris = Double.parseDouble(csvRecord.get(4));
            } catch (NumberFormatException e) {
                throw new SportininkuKomanduKlaida("Deja, bet nepavyko konvertuoti teksto i skaiciu", e);
            }

            sportininkai.add(new Sportininkas(vardas, pavarde, komandosName, ugis, svoris));
        }
    }

}
