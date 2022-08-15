package pirkiniai.webdb;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Db {

    public static List<Cekis> getCekisList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, data, parduotuve, aprasymas from cekiai order by data, parduotuve");) {

                 List<Cekis> list =   Db.cekisFromResultSet(rs);
                 for (  Cekis cekis :list){
                     cekis.setPrekes(Db.getPrekeListByCekisId(conn,cekis.getId()));
                 }
                 return list;
        }
    }
//    public static List<Cekis> getListOfCekisAndPrices(Connection conn) throws SQLException {
//        try (
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery("select data, parduotuve, sum(kiekis*kaina) From cekiai join prekes on cekiai.id = cekis_id group by cekiai.id, data, parduotuve");) {
//            return Db.cekisFromResultSet(rs);
//
//        }
//    }

    public static Cekis getCekisById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, data, parduotuve, aprasymas from cekiai where id = " + id);) {
            List<Cekis> list = Db.cekisFromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static BigDecimal bendraSuma (Connection conn)throws SQLException{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select sum(kiekis*kaina) from prekes");{
            BigDecimal suma = new BigDecimal((BigInteger) Db.prekeFromResultSet(rs)) ;
            return suma.equals(0) ? null : suma;
        }
    }

    public static List<Cekis> cekisFromResultSet(ResultSet rs) throws SQLException {
        List<Cekis> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Date data = rs.getDate("data");
            String parduotuve = rs.getString("parduotuve");
            String aprasymas = rs.getString("aprasymas");

            list.add(new Cekis(id, data, parduotuve, aprasymas));
        }
        return list;
    }

    public static Cekis addCekis(Connection conn, Cekis c) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("insert into cekiai (data, parduotuve, aprasymas) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {

            if (c.getData() != null) {
                pst.setDate(1, new java.sql.Date(c.getData().getTime()));
            } else {
                pst.setNull(1, Types.DATE);
            }
            pst.setString(2, c.getParduotuve());
            pst.setString(3, c.getAprasymas());
            pst.execute();
            try (
                    ResultSet rs = pst.getGeneratedKeys();) {
                if (rs.next()) {
                    c.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Id was not generated");
                }
                return c;
            }
        }
    }

    public static Cekis updateCekis(Connection conn, Cekis c) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("update cekiai set data = ?, parduotuve = ?, aprasymas = ? where id = ?;");) {

            if (c.getData() != null) {
                pst.setDate(1, new java.sql.Date(c.getData().getTime()));
            } else {
                pst.setNull(1, Types.DATE);
            }
            pst.setString(2, c.getParduotuve());
            pst.setString(3, c.getAprasymas());


            pst.setInt(4, c.getId());
            pst.execute();
            return c;
        }
    }

    public static Cekis deleteCekisById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        Cekis c = getCekisById(conn, id);
        if (c == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
        ) {
            st.execute("delete from cekiai where id = " + id);
            return c;
        }
    }
    public static Cekis getCekisByPreke(Connection conn, Preke p) throws SQLException {
        if (p == null) {
            return null;
        }
        return getCekisById(conn, p.getCekisid());
    }
    /*----------------------------------------------*/

    public static List<Preke> getPrekeListByCekisId(Connection conn, Integer cekisId) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, cekis_id, preke, kiekis, kaina, tipas_id from prekes where cekis_id = " + cekisId + " order by preke, kiekis");) {
            return Db.prekeFromResultSet(rs);
        }
    }

    public static List<Preke> getPrekeList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, cekis_id, preke, kiekis, kaina, tipas_id from prekes order by cekis_id, preke, kiekis");) {
            return Db.prekeFromResultSet(rs);
        }
    }

    public static Preke getPrekeById(Connection conn, Integer id) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, cekis_id, preke, kiekis, kaina, tipas_id from prekes where id = " + id);) {
            List<Preke> list = Db.prekeFromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static Preke addPreke(Connection conn, Preke p) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("insert into prekes (cekis_id, preke, kiekis, kaina, tipas_id) values (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setInt(1, p.getCekisid());
            pst.setString(2, p.getPreke());
            pst.setBigDecimal(3, p.getKiekis());
            pst.setBigDecimal(4, p.getKaina());
            pst.setInt(5, p.getTipasid());
            pst.execute();
            try (
                    ResultSet rs = pst.getGeneratedKeys();) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Id was not generated");
                }
                return p;
            }
        }
    }

    public static Preke updatePreke(Connection conn, Preke p) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("update prekes set cekis_id = ?, preke = ?, kiekis = ?, kaina = ?, tipas_id = ? where id = ?;");) {
            pst.setInt(1, p.getCekisid());
            pst.setString(2, p.getPreke());
            pst.setBigDecimal(3, p.getKiekis());
            pst.setBigDecimal(4, p.getKaina());
            pst.setInt(5, p.getTipasid());
            pst.setInt(6, p.getId());
            pst.execute();
            return p;
        }
    }

    public static Preke deletePrekeById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        Preke p = getPrekeById(conn, id);
        if (p == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
        ) {
            st.execute("delete from prekes where id = " + id);
            return p;
        }
    }


    public static List<Preke> prekeFromResultSet(ResultSet rs) throws SQLException {
        List<Preke> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer cekis_id = rs.getInt("cekis_id");
            String preke = rs.getString("preke");
            BigDecimal kiekis = rs.getBigDecimal("kiekis");
            BigDecimal kaina = rs.getBigDecimal("kaina");
            Integer tipas_id = rs.getInt("tipas_id");

            list.add(new Preke(id, cekis_id, preke, kiekis, kaina, tipas_id));
        }
        return list;
    }
//    public static List<Preke> getPrekesAndKainosList(Connection conn) throws SQLException {
//        try (
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery("select preke, kiekis*kaina from prekes order by preke");) {
//            List<Preke> list = Db.prekeFromResultSet(rs);
//            return list.isEmpty() ? null : list;
//        }
//    }
//
//    public static List<Preke> getPrekiuKainosList(Connection conn) throws SQLException {
//        try (
//                Statement st = conn.createStatement();
//                ResultSet rs = st.executeQuery("select preke, kiekis*kaina from prekes order by preke");) {
//            return Db.prekeFromResultSet(rs);
//        }
//    }
//
//
//    public static List<Preke> prekiuKainosFromResultSet(ResultSet rs) throws SQLException {
//        List<Preke> list = new ArrayList();
//        while (rs.next()) {
//
//            String preke = rs.getString("preke");
//            BigDecimal kiekis = rs.getBigDecimal("kiekis");
//            BigDecimal kaina = rs.getBigDecimal("kaina");
//
//
//            list.add(new Preke( preke, kiekis, kaina));
//        }
//        return list;
//    }
    //--------------------------------------------------------

    public static List<Tipas> getTipasList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, pavadinimas from tipai order by id");) {
            return Db.tipasFromResultSet(rs);
        }
    }

    public static List<Tipas> tipasFromResultSet(ResultSet rs) throws SQLException {
        List<Tipas> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String pavadinimas = rs.getString("pavadinimas");

            list.add(new Tipas(id, pavadinimas));
        }
        return list;
    }
}
