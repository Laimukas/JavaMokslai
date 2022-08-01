package db.pirkiniai;

import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Run {

        static {
            System.out.println("class loaderis uzkrove musu klase");
            System.out.println("ir paleido sita bloka");
            System.out.println("sitas blokas atliekamas vieninteli karta !!!");
        }

        public static void main(String[] args) throws ClassNotFoundException {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("org.postgresql.Driver");
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pirkiniai", "prog", "programa1programa1");
//                Connection connpg = DriverManager.getConnection("jdbc:postgresql://192.168.1.2:5432/devdb");
        ) {
            /*
            jdbc: - java database connectivity
            mysql - kuris dariveris turetu dirbti: MySQL
            192.168.1.2 - adresas
            3306 - portas
            pirkiniai - db pavadinimas

            jdbc: - java database connectivity
            postgresql - kuris dariveris turetu dirbti: PostgreSQL
            192.168.1.2 - adresas
            5432 - portas
            devdb - db pavadinimas
            */
            System.out.println("Prisijungem");
//            Statement st = conn.createStatement();
////            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = st.executeQuery("select aprasymas as info, id, data as pirkimo_data, parduotuve as kur from cekiai");
//            while (rs.next()) {
//                System.out.println("Id: " + rs.getInt("id"));
//                System.out.println("Data: " + rs.getDate("pirkimo_data"));
//                System.out.println("Parduotuve: " + rs.getString("kur"));
//                System.out.println("Komentaras: " + rs.getString("info"));
//                System.out.println("-----------");
//            }
////            System.out.println("--------- O dabar atgal ---------");
////            while (rs.previous()) {
////                System.out.println("Id: " + rs.getInt("id"));
////                System.out.println("Data: " + rs.getDate("data"));
////                System.out.println("Parduotuve: " + rs.getString("parduotuve"));
////                System.out.println("Komentaras: " + rs.getString("aprasymas"));
////                System.out.println("-----------");
////            }

//            System.out.println("Ivesk data:");
//            String dataS = sc.nextLine();
//            Date d = null;
//            try {
//                d = sdf.parse(dataS);
//            } catch (Exception ex) {
//                // ignore
//            }
//            System.out.println("Ivesk parduotuve:");
//            String parduotuve = sc.nextLine();
//            System.out.println("Ivesk komentara:");
//            String aprasymas = sc.nextLine();
//
////            insert into cekiai (data, parduotuve, aprasymas) values ('2022-07-01', 'Rimi', 'daug isleidau');
//            String sql = "insert into cekiai (data, parduotuve, aprasymas) values (?, ?, ?);";
//            System.out.println(sql);
//            try (PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
//                pst.setDate(1, new java.sql.Date(d.getTime()));
//                pst.setString(2, parduotuve);
//                if ("".equals(aprasymas)) {
//                    pst.setNull(3, Types.VARCHAR);
//                } else {
//                    pst.setString(3, aprasymas);
//                }
//                pst.execute();
//                try (ResultSet rs = pst.getGeneratedKeys();) {
//                    int ai = -1;
//                    if (rs.next()) {
//                        ai = rs.getInt(1);
//                    }
//                    System.out.println("Naujo iraso id=" + ai);
//                } catch (SQLException ex) {
//                    System.out.println("Failed to retrieve generated id: " + ex.getMessage());
//                }
//            } catch (SQLException ex) {
//                System.out.println("Failed to execute statement: " + ex.getMessage());
//            }

//            System.out.println("Ivesk cekio id: ");
//            int id = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Keiciam parduotuve i: ");
//            String parduotuve = sc.nextLine();
//            try (
//                    PreparedStatement pst = conn.prepareStatement("update cekiai set parduotuve = ? where id = ?;");
//            ) {
//                pst.setString(1, parduotuve);
//                pst.setInt(2, id);
//                pst.execute();
//            } catch (SQLException ex) {
//                System.out.println("Failed to update record: " + ex.getMessage());
//            }

//            System.out.println("Ivesk cekio id: ");
//            int id = sc.nextInt();
//            sc.nextLine();
//            try (
//                    Statement st = conn.createStatement();
//            ) {
//                st.execute("delete from cekiai where id = " + id + ";");
//            } catch (SQLException ex) {
//                System.out.println("Failed to delete record: " + ex.getMessage());
//            }
        }
        catch (SQLException ex) {
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
            System.out.println("Atsijungem");
        }

}
