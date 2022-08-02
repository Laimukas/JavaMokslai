package db.zmonesdb;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZmogusDb {

    public static List<Zmogus> getList(Connection conn) throws SQLException {
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gim_data, alga from zmones order by vardas, pavarde");) {
            return ZmogusDb.fromResultSet(rs);
        }
    }

    public static Zmogus getById(Connection conn, Integer id) throws SQLException {
        if (id == null) {
            return null;
        }
        try (
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select id, vardas, pavarde, gim_data, alga from zmones where id = " + id);) {
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
            Date gimimoData = rs.getDate("gim_data");
            BigDecimal alga = rs.getBigDecimal("alga");
            list.add(new Zmogus(id, vardas, pavarde, gimimoData, alga));
        }
        return list;
    }

    public static Zmogus add(Connection conn, String vardas, String pavarde, Date gimimoData, BigDecimal alga) throws SQLException {
        Zmogus z = new Zmogus(null, vardas, pavarde, gimimoData, alga);
        try (
                PreparedStatement pst = conn.prepareStatement("insert into zmones (vardas, pavarde, gim_data, alga) values (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
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
}
