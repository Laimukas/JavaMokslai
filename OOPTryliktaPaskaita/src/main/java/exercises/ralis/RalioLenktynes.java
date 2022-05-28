package exercises.ralis;

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

public class RalioLenktynes {

    private static final String RALIO_SARASAS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPTryliktaPaskaita\\src\\main\\resources\\raliai.csv";

    private ArrayList<Ralis> raliai;

    public RalioLenktynes(){
        raliai = new ArrayList<>();
    }

    public void paieskaPagalMarkeModeliMaxGreiti(String marke, String modelis, double maxGreitis) throws RalioLenktyniuKlaida {
        getRaliai();
        raliai.forEach(ralis -> {
            if(ralis.getAutomobilioMarke().equals(marke)
                    && ralis.getModelis().equals(modelis)
                    && ralis.getMaksimalusGreitis()==maxGreitis){
                System.out.println(ralis);
            }
        });
    }

    public void paieskaPagalModeli(String modelis) throws RalioLenktyniuKlaida {
        getRaliai();
        raliai.forEach(ralis -> {
            if(ralis.getModelis().equals(modelis)){
                System.out.println(ralis);
            }
        });
    }

    public void paieskaPagalVariklioTuriuIntervala(double minReiksme,double maxReiksme) throws RalioLenktyniuKlaida {
        getRaliai();

        raliai.forEach(ralis -> {
            if (ralis.getVariklioTuris() > minReiksme && ralis.getVariklioTuris()<maxReiksme) {
                System.out.println(ralis);
            }
        });
    }

    public void pasalintiIsSaraso(Ralis ralis) throws RalioLenktyniuKlaida {
        getRaliai();
        raliai.removeIf(r -> r.getAutomobilioMarke().equals(ralis.getAutomobilioMarke()) && r.getModelis().equals(ralis.getModelis()));
        perkrautiFaila();
        getRaliai();
    }

    public void papildytiSarasa(Ralis ralis) throws RalioLenktyniuKlaida {
        raliai.add(ralis);
        perkrautiFaila();
        getRaliai();
    }
    private void perkrautiFaila() throws RalioLenktyniuKlaida{
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(RALIO_SARASAS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for(Ralis ralisIsSaraso : raliai){
                csvPrinter.printRecord(Arrays.asList(ralisIsSaraso.getAutomobilioMarke(), ralisIsSaraso.getModelis(),
                        ralisIsSaraso.getVariklioTuris(), ralisIsSaraso.getMaksimalusGreitis()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new RalioLenktyniuKlaida("Deja, nepavyko irasyti ralio i saraso failiuka", e);
        }

    }

    public void perziuretiRalius() throws RalioLenktyniuKlaida {
        getRaliai();
        raliai.forEach(ralis -> System.out.println(ralis));
    }


    private void getRaliai() throws RalioLenktyniuKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(RALIO_SARASAS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new RalioLenktyniuKlaida("Deja, nepavyko nuskaityti ralio saraso failiuko", e);
        }
    }


    private void nuskaitytiNuoFailo(CSVParser csvParser) throws RalioLenktyniuKlaida {
        raliai = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String autoMarke = csvRecord.get(0);
            String modelis = csvRecord.get(1);

            double variklioTuris;
            double maxGreitis;

            try {
                variklioTuris = Double.parseDouble(csvRecord.get(2));
                maxGreitis = Double.parseDouble(csvRecord.get(3));
            } catch (NumberFormatException e) {
                throw new RalioLenktyniuKlaida("Deja, bet nepavyko konvertuoti teksto i skaiciu", e);
            }

            raliai.add(new Ralis(autoMarke, modelis, variklioTuris, maxGreitis));
        }
    }
}
