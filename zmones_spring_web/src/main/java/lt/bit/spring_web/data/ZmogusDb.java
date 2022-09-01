package lt.bit.spring_web.data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ZmogusDb {

//    private ArrayList<Zmogus> zmonesArray;
//
//    public ZmogusDb() {
//        zmonesArray = new ArrayList<>();
//    }
//
//    public ArrayList<Zmogus> getListOfZmones() {
//        return zmonesArray;
//    }

    private static final List<Zmogus> zmones = new ArrayList<>();

    public static List<Zmogus> getListOfZmones() {return zmones;}

    public Zmogus getOne(Integer id, File outputFile)  throws IOException  {
        ZmogusDb zmonesS = new ZmogusDb();
        if (id == null) {
            throw new NullPointerException("Zmogaus id privalomas");
        }
        for (Zmogus zmogus : zmonesS.getArrayListFromFile(outputFile)) {
            if (id.equals(zmogus.getId())) {
                System.out.println("zmogus kurio ieskom: "+zmogus);
                return zmogus;
            }
        }
        throw new IllegalArgumentException("Zmogus nerastas");
    }

//    public Zmogus add(Zmogus zmogus) {
//        if (zmogus == null) {
//            throw new NullPointerException("Zmogus privalomas");
//        }
//        if (zmogus.getId() == null) {
//            zmogus.assignId();
//        }
//        if (zmones.contains(zmogus)) {
//            throw new IllegalArgumentException("Id dubliuojasi");
//        }
//        zmones.add(zmogus);
//        return zmogus;
//    }

    public void zmogusUpdate(Zmogus z, File outputFile)  throws IOException  {
        String formattedString = "";
        ZmogusDb zmonesS = new ZmogusDb();
        if (z == null) {
            throw new NullPointerException("Zmogus privalomas");
        }
        for (Zmogus zmogus : zmonesS.getArrayListFromFile(outputFile)) {
            if (zmogus.getId().equals(z.getId())) {
                formattedString += String.format("%d %s %s %f \n", z.getId(), z.getVardas(), z.getPavarde(), z.getAmzius());
            }else {
                formattedString += String.format("%d %s %s %f \n", zmogus.getId(), zmogus.getVardas(), zmogus.getPavarde(), zmogus.getAmzius());
            }
        }
        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8,false);
    }

    public void zmogusDelete(Integer id, File outputFile)  throws IOException {
        String formattedString = "";
        ZmogusDb zmonesS = new ZmogusDb();
        if (id == null) {
            throw new NullPointerException("Zmogaus id privalomas");
        }
        for (Zmogus zmogus : zmonesS.getArrayListFromFile(outputFile)) {
            if (id.equals(zmogus.getId())) {
                System.out.println("trinam zmogu:" + zmogus);
            }else {
            formattedString += String.format("%d %s %s %f \n", zmogus.getId(), zmogus.getVardas(), zmogus.getPavarde(), zmogus.getAmzius());
            }
        }
        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8,false);
    }

    public void addZmogus(Zmogus zmogus, File outputFile) throws IOException {
        String formattedString = "";

        for (Zmogus z : zmones) {
            formattedString += String.format("%d %s %s %f \n", z.getId(), z.getVardas(), z.getPavarde(), z.getAmzius());
        }
        formattedString += String.format("%d %s %s %f \n", zmogus.getId(), zmogus.getVardas(), zmogus.getPavarde(), zmogus.getAmzius());

        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8,true);

    }

    public void writeToFileFromArrayList(ArrayList<Zmogus> zmones, File outputFile) throws IOException {
        String formattedString = "";

        for (Zmogus zmogus : zmones) {
            formattedString += String.format("%d %s %s %f \n", zmogus.getId(), zmogus.getVardas(), zmogus.getPavarde(), zmogus.getAmzius());
        }

        FileUtils.writeStringToFile(outputFile, formattedString, StandardCharsets.UTF_8);
    }

    public ArrayList<Zmogus> getArrayListFromFile(File outputFile) throws IOException {

        String textFromFile = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8);
        String[] lines = textFromFile.split("\n");

        ArrayList<Zmogus> zmones = new ArrayList<>();

        for (String line : lines) {
            String[] attributes = line.split(" ");

            Zmogus zmogus = new Zmogus(Integer.valueOf(attributes[0].trim()), (attributes[1].trim()),
                    (attributes[2].trim()), Float.valueOf(attributes[3].trim()));
            zmones.add(zmogus);
            if (zmogus.getId()>=Zmogus.nextId){
                Zmogus.nextId= zmogus.getId()+1;
            }
        }
        return zmones;
    }
}
