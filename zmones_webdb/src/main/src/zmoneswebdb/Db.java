package zmoneswebdb;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Db {

    public static List<Zmogus> getZmogusList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gimimo_data, alga from zmones order by vardas, pavarde");) {
            return Db.zmogusFromResultSet(rs);
        }
    }

    public static Zmogus getZmogusById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gimimo_data, alga from zmones where id = " + id);) {
            List<Zmogus> list = Db.zmogusFromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static Zmogus getZmogusByKontaktas(Connection conn, Kontaktas k) throws SQLException {
        if (k == null) {
            return null;
        }
        return getZmogusById(conn, k.getZmogusId());
    }

    public static Zmogus getZmogusByAdresas(Connection conn, Adresas a) throws SQLException {
        if (a == null) {
            return null;
        }
        return getZmogusById(conn, a.getZmogusId());
    }

    public static List<Zmogus> zmogusFromResultSet(ResultSet rs) throws SQLException {
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

    public static Zmogus addZmogus(Connection conn, Zmogus z) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("insert into zmones (vardas, pavarde, gimimo_data, alga) values (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setString(1, z.getVardas());
            pst.setString(2, z.getPavarde());
            if (z.getGimimoData() != null) {
                pst.setDate(3, new java.sql.Date(z.getGimimoData().getTime()));
            } else {
                pst.setNull(3, Types.DATE);
            }
            if (z.getAlga() != null) {
                pst.setBigDecimal(4, z.getAlga());
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

    public static Zmogus updateZmogus(Connection conn, Zmogus z) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("update zmones set vardas = ?, pavarde = ?, gimimo_data = ?, alga = ? where id = ?;");) {
            pst.setString(1, z.getVardas());
            pst.setString(2, z.getPavarde());
            if (z.getGimimoData() != null) {
                pst.setDate(3, new java.sql.Date(z.getGimimoData().getTime()));
            } else {
                pst.setNull(3, Types.DATE);
            }
            if (z.getAlga() != null) {
                pst.setBigDecimal(4, z.getAlga());
            } else {
                pst.setNull(4, Types.DECIMAL);
            }
            pst.setInt(5, z.getId());
            pst.execute();
            return z;
        }
    }

    public static Zmogus deleteZmogusById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        Zmogus z = getZmogusById(conn, id);
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

    public static List<Kontaktas> getKontaktasListByZmogusId(Connection conn, Integer zmogusId) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, zmogus_id, tipas, reiksme from kontaktai where zmogus_id = " + zmogusId + " order by tipas, reiksme");) {
            return Db.kontaktasFromResultSet(rs);
        }
    }

    public static Kontaktas getKontaktasById(Connection conn, Integer id) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, zmogus_id, tipas, reiksme from kontaktai where id = " + id);) {
            List<Kontaktas> list = Db.kontaktasFromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static List<Kontaktas> kontaktasFromResultSet(ResultSet rs) throws SQLException {
        List<Kontaktas> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer zmogusId = rs.getInt("zmogus_id");
            String tipas = rs.getString("tipas");
            String reiksme = rs.getString("reiksme");
            list.add(new Kontaktas(id, zmogusId, tipas, reiksme));
        }
        return list;
    }

    public static Kontaktas addKontaktas(Connection conn, Kontaktas k) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("insert into kontaktai (zmogus_id, tipas, reiksme) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setInt(1, k.getZmogusId());
            pst.setString(2, k.getTipas());
            pst.setString(3, k.getReiksme());
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

    public static Kontaktas updateKontaktas(Connection conn, Kontaktas k) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("update kontaktai set zmogus_id = ?, tipas = ?, reiksme = ? where id = ?;");) {
            pst.setInt(1, k.getZmogusId());
            pst.setString(2, k.getTipas());
            pst.setString(3, k.getReiksme());
            pst.setInt(4, k.getId());
            pst.execute();
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

    /*-----------------------*/

    public static List<Adresas> getAdresasListByZmogusId(Connection conn, Integer zmogusId) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, zmogus_id, adresas, miestas, pasto_kodas from adresai where zmogus_id = " + zmogusId + " order by miestas, adresas");) {
            return Db.adresasFromResultSet(rs);
        }
    }

    public static Adresas getAdresasById(Connection conn, Integer id) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, zmogus_id, adresas, miestas, pasto_kodas from adresai where id = " + id);) {
            List<Adresas> list = Db.adresasFromResultSet(rs);
            return list.isEmpty() ? null : list.get(0);
        }
    }

    public static List<Adresas> adresasFromResultSet(ResultSet rs) throws SQLException {
        List<Adresas> list = new ArrayList();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer zmogusId = rs.getInt("zmogus_id");
            String adresas = rs.getString("adresas");
            String miestas = rs.getString("miestas");
            String pastoKodas = rs.getString("pasto_kodas");
            list.add(new Adresas(id, zmogusId, adresas, miestas, pastoKodas));
        }
        return list;
    }

    public static Adresas addAdresas(Connection conn, Adresas a) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("insert into adresai (zmogus_id, adresas, miestas, pasto_kodas) values (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            pst.setInt(1, a.getZmogusId());
            pst.setString(2, a.getAdresas());
            pst.setString(3, a.getMiestas());
            pst.setString(4, a.getPastoKodas());
            pst.execute();
            try (
                    ResultSet rs = pst.getGeneratedKeys();) {
                if (rs.next()) {
                    a.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Id was not generated");
                }
                return a;
            }
        }
    }

    public static Adresas updateAdresas(Connection conn, Adresas a) throws SQLException {
        try (
                PreparedStatement pst = conn.prepareStatement("update adresai set zmogus_id = ?, adresas = ?, miestas = ?, pasto_kodas = ? where id = ?;");) {
            pst.setInt(1, a.getZmogusId());
            pst.setString(2, a.getAdresas());
            pst.setString(3, a.getMiestas());
            pst.setString(4, a.getPastoKodas());
            pst.setInt(5, a.getId());
            pst.execute();
            return a;
        }
    }

    public static Adresas deleteAdresasById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        Adresas a = getAdresasById(conn, id);
        if (a == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
        ) {
            st.execute("delete from adresai where id = " + id);
            return a;
        }
    }

}
