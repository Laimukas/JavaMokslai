package zmoneswebdb;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZmogusDb {

    public static List<Zmogus> getList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gimimo_data, alga from zmones order by vardas, pavarde");) {
            return ZmogusDb.fromResultSet(rs);
        }
    }

    public static Zmogus getById(Connection connz, Integer idz) throws SQLException {
        if (idz == null) {
            return null;
        }
        try (
                Statement st = connz.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gimimo_data, alga from zmones where id = " + idz);) {
            List<Zmogus> list = ZmogusDb.fromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static List<Zmogus> fromResultSet(ResultSet rs) throws SQLException {
        List<Zmogus> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String vardas = rs.getString("vardas");
            String pavarde = rs.getString("pavarde");
            Date gimimoData = rs.getDate("gimimo_data");
            BigDecimal alga = rs.getBigDecimal("alga");
            list.add(new Zmogus(id, vardas, pavarde, gimimoData, alga));
        }
        return list;
    }

    public static Zmogus add(Connection conn, String vardas, String pavarde, Date gimimoData, BigDecimal alga) throws SQLException {
        Zmogus z = new Zmogus(null, vardas, pavarde, gimimoData, alga);
        try (
                PreparedStatement pst = conn.prepareStatement("insert into zmones (vardas, pavarde, gimimo_data, alga) values (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setString(1, vardas);
            pst.setString(2, pavarde);
            if (gimimoData != null) {
                pst.setDate(3, new java.sql.Date(gimimoData.getTime()));
            } else {
                pst.setNull(3, Types.DATE);
            }
            if (alga != null) {
                pst.setBigDecimal(4, alga);
            } else {
                pst.setNull(4, Types.DECIMAL);
            }
            pst.execute();
            try (
                    ResultSet rs = pst.getGeneratedKeys();) {
                if (rs.next()) {
                    z.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Id was not generated");
                }
                return z;
            }
        }
    }

    public static Zmogus update(Connection conn, Zmogus editable) throws SQLException {
        Zmogus z = getById(conn, editable.getId());
        if (z == null) {
            return null;
        }
        try (
                PreparedStatement st = conn.prepareStatement("update zmones set vardas =?, pavarde =?, gimimo_data = ?, alga =? where id=?");
        ) {
            st.setString(1, editable.getVardas());
            st.setString(2, editable.getPavarde());
            if (editable.getGimimoData() != null) {
                st.setDate(3, new java.sql.Date(editable.getGimimoData().getTime()));
            } else {
                st.setNull(3, Types.DATE);
            }
            st.setBigDecimal(4, editable.getAlga());
            st.setInt(5, editable.getId());
            st.execute();
            return z;
        }
    }

    public static Zmogus deleteById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }

        Zmogus z = getById(conn, id);
        if (z == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
        ) {
            st.execute("delete from zmones where id = " + id);
            return z;
        }
    }

    public static Zmogus getZmogusByKontaktas(Connection conn, Kontaktas k) {
        if (k == null) {
            return null;
        }
        try (

                Statement st = conn.createStatement();
                ResultSet rsk = st.executeQuery("select zmones.id,zmones.vardas,zmones.pavarde,zmones.gimimo_data,zmones.alga from zmones join kontaktai on zmones.id=zmogus_id where kontaktai.id=" + k.getId());) {

            List<Zmogus> list = ZmogusDb.fromResultSet(rsk);
            return list.isEmpty() ? null : list.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//------------------nuo cia kontaktu metodai

    public static List<Kontaktas> getKontaktaiListByZmogusId(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, tipas, reiksme from kontaktai where zmogus_id="+id);) {
            return ZmogusDb.fromResultSetKontaktas(rs);
        }
    }

    public static List<Kontaktas> getKontaktaiList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, tipas, reiksme from kontaktai order by tipas, reiksme");) {
            return ZmogusDb.fromResultSetKontaktas(rs);
        }
    }

    public static Kontaktas getKontaktasById(Connection conn, Integer idk) throws SQLException {
        if (idk == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
                ResultSet rsk = st.executeQuery("select id, tipas, reiksme from kontaktai where id = " + idk);) {
            List<Kontaktas> list = ZmogusDb.fromResultSetKontaktas(rsk);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static Kontaktas addKontaktas(Connection conn, Kontaktas kontaktas) throws SQLException {
        Kontaktas k = new Kontaktas( );
        try (
                PreparedStatement pst = conn.prepareStatement("insert into kontaktai (tipas, reiksme) values (?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setString(1, k.getTipas());
            pst.setString(2, k.getReiksme());
            pst.execute();
            try (
                    ResultSet rs = pst.getGeneratedKeys();) {
                if (rs.next()) {
                    k.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Id was not generated");
                }
                return k;
            }
        }
    }

    public static Kontaktas updateKontaktas(Connection conn, Kontaktas editable) throws SQLException {
        Kontaktas k = getKontaktasById(conn, editable.getId());
        if (k == null) {
            return null;
        }
        try (
                PreparedStatement st = conn.prepareStatement("update kontaktai set tipas =?, reiksme =? where id=?");
        ) {
            st.setString(1, editable.getTipas());
            st.setString(2, editable.getReiksme());
            st.setInt(3, editable.getId());
            st.execute();
            return k;
        }
    }

    public static Kontaktas deleteKontaktasById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }

        Kontaktas k = getKontaktasById(conn, id);
        if (k == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
        ) {
            st.execute("delete from kontaktai where id = " + id);
            return k;
        }
    }

    public static List<Kontaktas> fromResultSetKontaktas(ResultSet rs) throws SQLException {
        List<Kontaktas> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String tipas = rs.getString("tipas");
            String reiksme = rs.getString("reiksme");
            list.add(new Kontaktas(id, tipas, reiksme));
        }
        return list;
    }
}
