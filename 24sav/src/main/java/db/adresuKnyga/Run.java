package db.adresuKnyga;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Run {

    //1. zmoniu sarasas -> turi atspausdinti visa zmoniu sarasa
    //
    //2. ivesti nauja zmogu -> turi paklausti vardo, pavarde, gimimo datos (jei neivesta - i DB eina NULL), algos (jei neivesta - i DB eina NULL) ir irasyti i DB
    //
    //3. istrinti zmogu -> paklausti id ir istrinti zmogu su nurodytu id
    //
    //4. kontaktu sarasas -> paklausti id ir parodyti zmogaus kontaktu sarasa
    //
    //5. naujas kontaktas -> paklausti (zmogaus) id, tipo, reiksmes ir prideti nauja kontakta
    //
    //6. istrinti kontakta -> paklausti (kontakto) id ir istrinti nurodyta kontakta
    //
    //0. baigti darba


    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("org.postgresql.Driver");
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            System.out.println("Prisijungem");
            Statement st = conn.createStatement();
//            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            int funkcija = 0;

            do {
                System.out.println("Galimos funkcijos:");
                System.out.println("1-Zmoniu sarasas");
                System.out.println("2-Ivesti nauja zmogu");
                System.out.println("3-Istrinti zmogu");
                System.out.println("4-Kontaktu sarasas");
                System.out.println("5-Naujas kontaktas");
                System.out.println("6-Istrinti kontakta");
                System.out.println("7-Adresu sarasas");
                System.out.println("8-Naujas adresas");
                System.out.println("9-Istrinti adresa");
                System.out.println("0-Baigti darba");
                System.out.println("-----------------------");
                System.out.println("Ka renkiesi?");
                funkcija = sc.nextInt();
                switch (funkcija) {

                    case 0 -> System.out.println("Pabaiga.");
                    case 1 -> gaunamZmoniuSarasa();
                    case 2 -> irasinesimNaujusZmones();
                    case 3 -> trinamZmogu();
                    case 4 -> zmogausKontaktuSarasas();
                    case 5 -> kuriamNaujaKontakta();
                    case 6 -> trinamKontakta();
                    case 7 -> zmogausAdresuSarasas();
                    case 8 -> kuriamNaujaAdresa();
                    case 9 -> trinamAdresa();
                    default -> System.out.println("Tokios funkcijos nera.Pasirink ka nors geresnio.");
                }


            } while (funkcija != 0);


        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
        System.out.println("Atsijungem");
    }

    public static void gaunamZmoniuSarasa() throws SQLException {
        //*************----------- gaunam zmoniu sarasa
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from zmones");
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Vardas: " + rs.getString("vardas"));
                System.out.println("Pavarde: " + rs.getString("pavarde"));
                System.out.println("Gimimo data: " + rs.getDate("gimimo_data"));
                System.out.println("Alga: " + rs.getInt("alga"));

                System.out.println("-----------");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }

    }

    public static void irasinesimNaujusZmones() {
        // ***************----irasinesim naujus zmones-----
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {

            System.out.println("Ivesk varda:");
            String vardas = sc.nextLine();
            System.out.println("Ivesk pavarde:");
            String pavarde = sc.nextLine();
            System.out.println("Ivesk gimimo data(yyyy-MM-dd):");
            String dataS = sc.nextLine();
            Date d = null;
            try {
                d = sdf.parse(dataS);
            } catch (Exception ex) {
                // ignore
            }
            System.out.println("Ivesk alga:");
            Integer alga = Integer.valueOf(sc.nextLine());


//            insert into cekiai (data, parduotuve, aprasymas) values ('2022-07-01', 'Rimi', 'daug isleidau');
            String sql = "insert into zmones (vardas, pavarde, gimimo_data, alga) values (?, ?, ?, ?);";
//            System.out.println(sql);
            try (PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
                pst.setString(1, vardas);
                pst.setString(2, pavarde);
                if ("".equals(dataS)) {
                    pst.setNull(3, Types.DATALINK);
                } else {
                    pst.setDate(3, new java.sql.Date(d.getTime()));
//                    pst.setString(3, aprasymas);
                }
                if ("".equals(alga)) {
                    pst.setNull(4, Types.INTEGER);
                } else {
                    pst.setInt(4, alga);
                }
                pst.execute();
                try (ResultSet rst = pst.getGeneratedKeys();) {
                    int ai = -1;
                    if (rst.next()) {
                        ai = rst.getInt(1);
                    }
                    System.out.println("Naujo iraso id=" + ai);
                } catch (SQLException ex) {
                    System.out.println("Failed to retrieve generated id: " + ex.getMessage());
                }
            } catch (SQLException ex) {
                System.out.println("Failed to execute statement: " + ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }

    public static void trinamZmogu() {
        //******---------istrinti zmogu--------
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {

            System.out.println("Ivesk zmogaus id, kuri nori istrinti: ");
            int id = sc.nextInt();
            sc.nextLine();
            try (
                    Statement stt = conn.createStatement();
            ) {
                stt.execute("delete from zmones where id = " + id + ";");
            } catch (SQLException ex) {
                System.out.println("Failed to delete record: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }

    }

    public static void zmogausKontaktuSarasas() {
        //******------paklausti id ir parodyti zmogaus kontaktu sarasa
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            Statement st = conn.createStatement();
            System.out.println("Ivesk zmogaus id, kurio kontaktus nori pamatyti: ");
            int idz = sc.nextInt();
            sc.nextLine();
            ResultSet rss = st.executeQuery("select * from kontaktai where zmogus_id=" + idz + ";");

            while (rss.next()) {
                System.out.println("Kontakto id: " + rss.getInt("id"));
                System.out.println("Tipas: " + rss.getString("tipas"));
                System.out.println("Reiksme: " + rss.getString("reiksme"));
                System.out.println("-----------");
            }

        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }

    }

    public static void kuriamNaujaKontakta() {
        //**********-------- kuriam nauja kontakta,reik zmogaus_id,tipo,reiksmes
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            System.out.println("Ivesk zmogaus id kuriam pridesi nauja kontakta:");
            Integer zmogaus_id = Integer.valueOf(sc.nextLine());
            System.out.println("Ivesk kontakto tipa:");
            String tipas = sc.nextLine();
            System.out.println("Ivesk kontakto reiksme:");
            String reiksme = sc.nextLine();

//            insert into cekiai (data, parduotuve, aprasymas) values ('2022-07-01', 'Rimi', 'daug isleidau');
            String sqll = "insert into kontaktai (zmogus_id, tipas, reiksme) values (?, ?, ?);";
//            System.out.println(sql);
            try (PreparedStatement pst = conn.prepareStatement(sqll, Statement.RETURN_GENERATED_KEYS);) {
                pst.setInt(1, zmogaus_id);
                pst.setString(2, tipas);
                pst.setString(3, reiksme);
                pst.execute();
                try (ResultSet rst = pst.getGeneratedKeys();) {
                    int ai = -1;
                    if (rst.next()) {
                        ai = rst.getInt(1);
                    }
                    System.out.println("Naujo iraso id=" + ai);
                } catch (SQLException ex) {
                    System.out.println("Failed to retrieve generated id: " + ex.getMessage());
                }
            } catch (SQLException ex) {
                System.out.println("Failed to execute statement: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }

    public static void trinamKontakta() {
        //************-------------istrinti kontakta
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            System.out.println("Ivesk kontakto id, kuri nori istrinti: ");
            int idk = sc.nextInt();
            sc.nextLine();
            try (
                    Statement stt = conn.createStatement();
            ) {
                stt.execute("delete from kontaktai where id = " + idk + ";");
            } catch (SQLException ex) {
                System.out.println("Failed to delete record: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }

public static void zmogausAdresuSarasas() {
    //******------paklausti id ir parodyti zmogaus kontaktu sarasa
    Scanner sc = new Scanner(System.in);
    try (
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
    ) {
        Statement st = conn.createStatement();
        System.out.println("Ivesk zmogaus id, kurio adresus nori pamatyti: ");
        int idz = sc.nextInt();
        sc.nextLine();
        ResultSet rss = st.executeQuery("select * from adresai where zmogus_id=" + idz + ";");

        while (rss.next()) {
            System.out.println("Adreso id: " + rss.getInt("id"));
            System.out.println("Adresas: " + rss.getString("adresas"));
            System.out.println("Miestas: " + rss.getString("miestas"));
            System.out.println("Pasto kodas: " + rss.getString("pasto_kodas"));
            System.out.println("Salis: " + rss.getString("salis"));
            System.out.println("-----------");
        }

    } catch (SQLException ex) {
        System.out.println("Failed to connect to DB: " + ex.getMessage());
    }

}

    public static void kuriamNaujaAdresa() {
        //**********-------- kuriam nauja kontakta,reik zmogaus_id,tipo,reiksmes
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            System.out.println("Ivesk zmogaus id kuriam pridesi nauja adresa:");
            Integer zmogaus_id = Integer.valueOf(sc.nextLine());
            System.out.println("Ivesk adresa:");
            String adresas = sc.nextLine();
            System.out.println("Ivesk miesta:");
            String miestas = sc.nextLine();
            System.out.println("Ivesk pasto koda:");
            String pasto_kodas = sc.nextLine();
            System.out.println("Ivesk sali:");
            String salis = sc.nextLine();


//            insert into cekiai (data, parduotuve, aprasymas) values ('2022-07-01', 'Rimi', 'daug isleidau');
            String sqll = "insert into adresai (zmogus_id, adresas, miestas, pasto_kodas, salis) values (?, ?, ?, ?, ?);";
//            System.out.println(sql);
            try (PreparedStatement pst = conn.prepareStatement(sqll, Statement.RETURN_GENERATED_KEYS);) {
                pst.setInt(1, zmogaus_id);
                pst.setString(2, adresas);
                if ("".equals(miestas)) {
                    pst.setNull(3, Types.VARCHAR);
                } else {
                    pst.setString(3, miestas);
                }
                if ("".equals(pasto_kodas)) {
                    pst.setNull(4, Types.VARCHAR);
                } else {
                    pst.setString(4, pasto_kodas);
                }
                if ("".equals(salis)) {
                    pst.setNull(5, Types.VARCHAR);
                } else {
                    pst.setString(5, salis);
                }
                pst.execute();
                try (ResultSet rst = pst.getGeneratedKeys();) {
                    int ai = -1;
                    if (rst.next()) {
                        ai = rst.getInt(1);
                    }
                    System.out.println("Naujo iraso id=" + ai);
                } catch (SQLException ex) {
                    System.out.println("Failed to retrieve generated id: " + ex.getMessage());
                }
            } catch (SQLException ex) {
                System.out.println("Failed to execute statement: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }

    public static void trinamAdresa() {
        //************-------------istrinti kontakta
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adresu_knyga", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            System.out.println("Ivesk adreso id, kuri nori istrinti: ");
            int idk = sc.nextInt();
            sc.nextLine();
            try (
                    Statement stt = conn.createStatement();
            ) {
                stt.execute("delete from adresai where id = " + idk + ";");
            } catch (SQLException ex) {
                System.out.println("Failed to delete record: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }
}



