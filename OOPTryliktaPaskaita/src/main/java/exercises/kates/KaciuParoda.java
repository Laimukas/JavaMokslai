package exercises.kates;

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

public class KaciuParoda {

    private static final String KACIU_SARASAS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPTryliktaPaskaita\\src\\main\\resources\\kates.csv";

    private ArrayList<Kate> kates;

    public KaciuParoda(){
        kates = new ArrayList<>();
    }

    public void paieska(String lytis, int amzius) throws KaciuParodosServisoKlaida {
        getKates();
        kates.forEach(kate -> {
            if(kate.getLytis().equals(lytis) && kate.getAmzius() == amzius){
                System.out.println(kate);
            }
        });
    }

    public void paieska(String veisle) throws KaciuParodosServisoKlaida {
        getKates();
        kates.forEach(kate -> {
            if(kate.getVeisle().equals(veisle)){
                System.out.println(kate);
            }
        });
    }

    public void paieska() throws KaciuParodosServisoKlaida {
        getKates();
        double svorioSuma = 0;

        for (Kate kate : kates) {
            svorioSuma += kate.getSvoris();
        }

        double vidurkis = svorioSuma / kates.size();

        kates.forEach(kate -> {
            if (kate.getSvoris() <= vidurkis) {
                System.out.println(kate);
            }
        });
    }

    public void pasalintiIsSaraso(Kate kate) throws KaciuParodosServisoKlaida {
        getKates();
        kates.removeIf(k -> k.getVardas().equals(kate.getVardas()) && k.getVeisle().equals(kate.getVeisle()));
        perkrautiFaila();
        getKates();
    }

    public void papildytiSarasa(Kate kate) throws KaciuParodosServisoKlaida {
        kates.add(kate);
        perkrautiFaila();
        getKates();
    }

    private void perkrautiFaila() throws KaciuParodosServisoKlaida{
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(KACIU_SARASAS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for(Kate kateIsSaraso : kates){
                csvPrinter.printRecord(Arrays.asList(kateIsSaraso.getVardas(), kateIsSaraso.getVeisle(),
                        kateIsSaraso.getLytis(), kateIsSaraso.getSvoris(), kateIsSaraso.getAmzius()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new KaciuParodosServisoKlaida("Deja, nepavyko irasyti kates i saraso failiuka", e);
        }

    }

    public void perziuretiKates() throws KaciuParodosServisoKlaida {
        getKates();
        kates.forEach(kate -> System.out.println(kate));
    }


    private void getKates() throws KaciuParodosServisoKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(KACIU_SARASAS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new KaciuParodosServisoKlaida("Deja, nepavyko nuskaityti kaciu saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) throws KaciuParodosServisoKlaida {
        kates = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String veisle = csvRecord.get(1);
            String lytis = csvRecord.get(2);

            double svoris;
            int amzius;

            try {
                svoris = Double.parseDouble(csvRecord.get(3));
                amzius = Integer.parseInt(csvRecord.get(4));
            } catch (NumberFormatException e) {
                throw new KaciuParodosServisoKlaida("Deja, bet nepavyko konvertuoti teksto i skaiciu", e);
            }

            kates.add(new Kate(vardas, veisle, lytis, svoris, amzius));
        }
    }
}
