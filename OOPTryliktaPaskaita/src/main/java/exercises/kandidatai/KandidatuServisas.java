package exercises.kandidatai;

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

public class KandidatuServisas {

    private static final String KANDIDATU_SARASO_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPTryliktaPaskaita\\src\\main\\resources\\kandidatai.csv";

    private ArrayList<Kandidatas> kandidatuSarasas;

    public KandidatuServisas() {
        kandidatuSarasas = new ArrayList<>();
    }

    public void paieska(String vardas, String pavarde, String pareigos, int profesinePatirtis) throws KandidatuServisoKlaida {
        getKandidatai();
        kandidatuSarasas.forEach(kandidatas -> {
            if (kandidatas.getVardas().equals(vardas) &&
                    kandidatas.getPavarde().equals(pavarde) &&
                    kandidatas.getPareigos().equals(pareigos) &&
                    kandidatas.getProfesinePatirtis() == profesinePatirtis) {
                System.out.println(kandidatas);
            }
        });
    }

    public void paieska() throws KandidatuServisoKlaida {
        getKandidatai();
        double suma = 0;

        for (Kandidatas kandidatas : kandidatuSarasas) {
            suma += kandidatas.getPageidaujamasAtlygis();
        }

        double vidurkis = suma / kandidatuSarasas.size();

        kandidatuSarasas.forEach(kandidatas -> {
            if (kandidatas.getPageidaujamasAtlygis() <= vidurkis) {
                System.out.println(kandidatas);
            }
        });
    }

    public void paieska(String vardas, String pavarde) throws KandidatuServisoKlaida {
        getKandidatai();
        kandidatuSarasas.forEach(kandidatas -> {
            if (kandidatas.getVardas().equals(vardas) && kandidatas.getPavarde().equals(pavarde)) {
                System.out.println(kandidatas);
            }
        });
    }

    public void papildytiSarasa(Kandidatas kandidatas) throws KandidatuServisoKlaida {
        kandidatuSarasas.add(kandidatas);
        perkrautiFaila();
        getKandidatai();
    }

    public void pasalintiIsSaraso(Kandidatas kandidatas) throws KandidatuServisoKlaida {
        getKandidatai();
        kandidatuSarasas.removeIf(k -> k.getVardas().equals(kandidatas.getVardas()) && k.getPavarde().equals(kandidatas.getPavarde()));
        perkrautiFaila();
    }

    public void perkrautiFaila() throws KandidatuServisoKlaida {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(KANDIDATU_SARASO_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Kandidatas kanditasIsSaraso : kandidatuSarasas) {
                csvPrinter.printRecord(
                        Arrays.asList(kanditasIsSaraso.getVardas(), kanditasIsSaraso.getPavarde(),
                                kanditasIsSaraso.getPareigos(), kanditasIsSaraso.getProfesinePatirtis(),
                                kanditasIsSaraso.getPageidaujamasAtlygis()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new KandidatuServisoKlaida("Deja, nepavyko irasyti kandidato i saraso failiuka", e);
        }

        getKandidatai();
    }

    public void perziuretiKandidatus() throws KandidatuServisoKlaida {
        getKandidatai();
        kandidatuSarasas.forEach(kandidatas -> System.out.println(kandidatas));
    }


    private void getKandidatai() throws KandidatuServisoKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(KANDIDATU_SARASO_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new KandidatuServisoKlaida("Deja, nepavyko nuskaityti kandidatu saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) throws KandidatuServisoKlaida {
        kandidatuSarasas = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String pavarde = csvRecord.get(1);
            String pareigos = csvRecord.get(2);

            int profesinePatirtis;
            double pageidaujamasAtlygis;

            try {
                profesinePatirtis = Integer.parseInt(csvRecord.get(3));
                pageidaujamasAtlygis = Double.parseDouble(csvRecord.get(4));
            } catch (NumberFormatException e) {
                throw new KandidatuServisoKlaida("Deja, bet nepavyko konvertuoti teksto i skaiciu", e);
            }

            kandidatuSarasas.add(new Kandidatas(vardas, pavarde, pareigos, profesinePatirtis, pageidaujamasAtlygis));
        }
    }
}
