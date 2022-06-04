package exercises.studentai;

import exercises.sportininkai.Sportininkas;
import exercises.sportininkai.SportininkuKomanduKlaida;
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

public class StudentuGrupe {

    private static final String STUDENTU_SARASAS_FILE_PATH =
            "D:\\Dokumentai\\Coding\\Pamokos\\JavaMokslai\\OOPTryliktaPaskaita\\src\\main\\resources\\studentai.csv";

    private ArrayList<Studentas> studentai;

    public StudentuGrupe() {
        studentai = new ArrayList<>();
    }

    public void rikiavimasPagalPavardeCollectionMetodu() throws StudentuGrupiuKlaida{
        getStudentai();
        System.out.println("Kitas rikiavimo budas naudojant Collections metoda.");
        Collections.sort(studentai,((o1, o2) -> o1.getPavarde().compareTo(o2.getPavarde())));
        studentai.forEach(studentas -> System.out.println(studentas));
    }

    public ArrayList<Studentas> rikiavimasPagalPavardes(SortOrder sortOrder) {
        System.out.println("Rikiavimas pagal pavardes "+sortOrder.name()+ " tvarka.");
        if (SortOrder.ASCENDING.equals(sortOrder)) {
            studentai.sort((o1, o2) -> o1.getPavarde().compareTo(o2.getPavarde()));
            studentai.forEach(studentas -> System.out.println(studentas));
        }

        if (SortOrder.DESCENDING.equals(sortOrder)) {
            studentai.sort((o1, o2) -> o2.getPavarde().compareTo(o1.getPavarde()));
            studentai.forEach(studentas -> System.out.println(studentas));
        }
        return studentai;
    }

    public void geriausiaVidurkiTurintisStudentasNurodytojeGrupeje(String group) throws StudentuGrupiuKlaida {
        getStudentai();
        double maxVidurkis = 0;
        Studentas geriausiaiBesimokantisStudentas = null;
        for (Studentas studentas : studentai) {
            if (studentas.getGrupe().equals(group) && maxVidurkis < studentas.getVidurkis()) {
                maxVidurkis = studentas.getVidurkis();
                if (studentas.getGrupe().equals(group) && maxVidurkis == studentas.getVidurkis()) {
                    geriausiaiBesimokantisStudentas = studentas;
                }
            }
        }
        System.out.println(geriausiaiBesimokantisStudentas);
    }

    public void studentoPaieskaNurodziusVardaPavardeGrupe(String name,String surname,String group) throws StudentuGrupiuKlaida {
        getStudentai();

        for (Studentas studentas : studentai) {
            if (studentas.getVardas().equals(name) && studentas.getPavarde().equals(surname)&&studentas.getGrupe().equals(group)) {
                System.out.println(studentas);
            }
        }
    }

    public void studentuSarasasNurodziusVidurkiuIntervala(Double nuo,Double iki) throws StudentuGrupiuKlaida {
        getStudentai();

        for (Studentas studentas : studentai) {
            if (studentas.getVidurkis()>nuo && studentas.getVidurkis()<iki) {
                System.out.println(studentas);
            }
        }
    }

    public void pasalintiIsSaraso(Studentas studentas) throws StudentuGrupiuKlaida {
        getStudentai();
        studentai.removeIf(s -> s.getVardas().equals(studentas.getVardas()) && s.getPavarde().equals(studentas.getPavarde()));
        perkrautiFaila();
        getStudentai();
    }

    public void papildytiSarasa(Studentas studentas) throws StudentuGrupiuKlaida {
        studentai.add(studentas);
        perkrautiFaila();
        getStudentai();
    }

    private void perkrautiFaila() throws StudentuGrupiuKlaida {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(STUDENTU_SARASAS_FILE_PATH));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

            for (Studentas studentasIsSaraso : studentai) {
                csvPrinter.printRecord(Arrays.asList(studentasIsSaraso.getVardas(), studentasIsSaraso.getPavarde(),
                        studentasIsSaraso.getGrupe(), studentasIsSaraso.getVidurkis()));
                csvPrinter.flush();
            }

            csvPrinter.close();
            writer.close();
        } catch (IOException e) {
            throw new StudentuGrupiuKlaida("Deja, nepavyko irasyti studento i saraso failiuka", e);
        }

    }

    public void perziuretiStudentus() throws StudentuGrupiuKlaida {
        getStudentai();
        studentai.forEach(studentas -> System.out.println(studentas));
    }


    private void getStudentai() throws StudentuGrupiuKlaida {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STUDENTU_SARASAS_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            nuskaitytiNuoFailo(csvParser);
            csvParser.close();
            reader.close();
        } catch (IOException e) {
            throw new StudentuGrupiuKlaida("Deja, nepavyko nuskaityti studentu saraso failiuko", e);
        }
    }

    private void nuskaitytiNuoFailo(CSVParser csvParser) throws StudentuGrupiuKlaida {
        studentai = new ArrayList<>();

        for (CSVRecord csvRecord : csvParser) {
            String vardas = csvRecord.get(0);
            String pavarde = csvRecord.get(1);
            String grupe = csvRecord.get(2);

            double vidurkis;

            try {
                vidurkis = Double.parseDouble(csvRecord.get(3));
            } catch (NumberFormatException e) {
                throw new StudentuGrupiuKlaida("Deja, bet nepavyko konvertuoti teksto i skaiciu", e);
            }

            studentai.add(new Studentas(vardas, pavarde, grupe, vidurkis));
        }
    }

}
