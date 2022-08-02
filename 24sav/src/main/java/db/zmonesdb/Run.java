package db.zmonesdb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Run {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/adresu_knyga";
    private static final String USER = "prog";
    private static final String PASS = "programa1programa1";
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
        ) {
            System.out.println("done");
            int pasirinkimas = -1;
            while (pasirinkimas != 0) {
                System.out.println("1. zmoniu sarasas");
                System.out.println("2. ivesti nauja zmogu");
                System.out.println("3. istrinti zmogu");
                System.out.println("4. kontaktu sarasas");
                System.out.println("5. naujas kontaktas");
                System.out.println("6. istrinti kontakta");
                System.out.println("0. baigti darba");
                pasirinkimas = -1;
                try {
                    pasirinkimas = sc.nextInt();
                } catch (NoSuchElementException ex) {
                    // ignore
                } finally {
                    sc.nextLine();
                }
                switch (pasirinkimas) {
                    case 1:
                        try {
                            List<Zmogus> list = ZmogusDb.getList(conn);
                            if (list.isEmpty()) {
                                System.out.println("Sarasas tuscias");
                            } else {
                                list.stream().forEach(System.out::println);
                            }
                        } catch (SQLException ex) {
                            System.out.println("Failed to retrieve 'zmones' data from DB: " + ex.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Ivesk varda: ");
                        String vardas;
                        do {
                            vardas = inputString();
                        } while (vardas == null);
                        System.out.println("Ivesk pavarde: ");
                        String pavarde;
                        do {
                            pavarde = inputString();
                        } while (pavarde == null);
                        System.out.println("Ivesk gimimo data: ");
                        Date gimimoData = null;
                        String gimDataS;
                        do {
                            gimDataS = inputString();
                            if (gimDataS != null) {
                                try {
                                    gimimoData = sdf.parse(gimDataS);
                                    gimDataS = null;
                                } catch (Exception ex) {
                                    // ignore
                                }
                            }
                        } while (gimDataS != null);
                        System.out.println("Ivesk alga: ");
                        BigDecimal alga = null;
                        String algaS;
                        do {
                            algaS = inputString();
                            if (algaS != null) {
                                try {
                                    alga = new BigDecimal(algaS);
                                    algaS = null;
                                } catch (Exception ex) {
                                    // ignore
                                }
                            }
                        } while (algaS != null);
                        try {
                            Zmogus z = ZmogusDb.add(conn, vardas, pavarde, gimimoData, alga);
                            System.out.println(z + " pridetas i DB");
                        } catch (SQLException ex) {
                            System.out.println("Failed to add data to 'zmones': " + ex.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Ivesk id: ");
                        Integer id = null;
                        String idS;
                        do {
                            idS = inputString();
                            if (idS != null) {
                                try {
                                    id = Integer.decode(idS);
                                    idS = null;
                                } catch (Exception ex) {
                                    // ignore
                                }
                            }
                        } while (idS != null);
                        if (id != null) {
                            try {
                                Zmogus z = ZmogusDb.deleteById(conn, id);
                                System.out.println(z + " istrintas is DB");
                            } catch (SQLException ex) {
                                System.out.println("Failed to delete data from 'zmones': " + ex.getMessage());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("pasirinko - " + pasirinkimas);
                        break;
                    case 5:
                        System.out.println("pasirinko - " + pasirinkimas);
                        break;
                    case 6:
                        System.out.println("pasirinko - " + pasirinkimas);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Blogas pasirinkimas");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }

    private static String inputString() {
        String s = sc.nextLine();
        s = s.trim();
        if (s.equals("")) {
            return null;
        }
        return s;
    }
}
