package lt.bit.antr.uzduotis2.DestytojoAliaus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static final String FILE_NAME = "zmones.tab";
    public static final String CHAR_ENCODING = "UTF-8";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pasirinkimas;
        do {
            System.out.println("1. paziureti visus");
            System.out.println("2. ivesti nauja");
            System.out.println("3. istrinti");
            System.out.println("0. baigti");
            try {
                pasirinkimas = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Ismok naudotis klaviatura, asile");
                pasirinkimas = -1;
            } finally {
                sc.nextLine();
            }
            switch (pasirinkimas) {
                case 1: {
                    List<Zmogus> zmones = getFileContent();
                    zmones.sort((z1, z2) -> z1.compareTo(z2));
                    for (Zmogus zmogus : zmones) {
                        System.out.println(zmogus);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Ivesk varda: ");
                    String vardas = sc.nextLine();
                    System.out.println("Ivesk pavarde: ");
                    String pavarde = sc.nextLine();
                    getFileContent();
                    appendRecord(new Zmogus(vardas, pavarde));
                    break;
                }
                case 3: {
                    System.out.println("Ivesk zmogaus id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    List<Zmogus> zmones = getFileContent();
                    for (Zmogus zmogus : zmones) {
                        if (zmogus.getId() == id) {
                            zmones.remove(zmogus);
                            break;
                        }
                    }
                    saveFileContent(zmones);
                    break;
                }
            }
        } while (pasirinkimas != 0);

    }

    public static List<Zmogus> getFileContent() {
        List<Zmogus> list = new ArrayList();
        try (
                InputStream is = new FileInputStream(FILE_NAME);
                Reader r = new InputStreamReader(is, CHAR_ENCODING);
                BufferedReader br = new BufferedReader(r);
        ) {
            String line;
            int lineNo = 0;
            while ( (line = br.readLine()) != null) {
                lineNo++;
                if (!line.trim().equals("")) {
                    String[] parts = line.split("\t");
                    if (parts.length < 3) {
                        throw new BadRecordException(lineNo, line);
                    }
                    try {
                        list.add(new Zmogus(Integer.parseInt(parts[0]), parts[1], parts[2]));
                    }
                    catch (NumberFormatException ex) {
                        throw new BadRecordException(lineNo, line);
                    }
                }
            }
        }
        catch (BadRecordException ex) {
            System.err.println(
                    "Data file contains bad record at line " +
                            ex.getLineNo() +
                            ": " +
                            ex.getLine()
            );
            list.clear();
        }
        catch (FileNotFoundException ex) {
            System.err.println("File " + FILE_NAME + " does not exist");
        }
        catch (IOException ex) {
            System.err.println(
                    "Failed to read data from file " +
                            FILE_NAME +
                            ": " +
                            ex.getMessage()
            );
            list.clear();
        }
        return list;
    }

    public static void appendRecord(Zmogus z) {
        try (
                OutputStream os = new FileOutputStream(FILE_NAME, true);
                Writer w = new OutputStreamWriter(os, CHAR_ENCODING);
                BufferedWriter bw = new BufferedWriter(w);
        ) {
            bw.append(z.getId() + "\t" + z.getVardas() + "\t" + z.getPavarde() + "\n");
        }
        catch (IOException ex) {
            System.err.println(
                    "Failed to write data to file " +
                            FILE_NAME +
                            ": " +
                            ex.getMessage()
            );
        }
    }

    public static void saveFileContent(List<Zmogus> list) {
        try (
                OutputStream os = new FileOutputStream(FILE_NAME);
                Writer w = new OutputStreamWriter(os, CHAR_ENCODING);
                BufferedWriter bw = new BufferedWriter(w);
        ) {
            for (Zmogus z : list) {
                bw.append(z.getId() + "\t" + z.getVardas() + "\t" + z.getPavarde() + "\n");
            }
        }
        catch (IOException ex) {
            System.err.println(
                    "Failed to write data to file " +
                            FILE_NAME +
                            ": " +
                            ex.getMessage()
            );
        }
    }
}
