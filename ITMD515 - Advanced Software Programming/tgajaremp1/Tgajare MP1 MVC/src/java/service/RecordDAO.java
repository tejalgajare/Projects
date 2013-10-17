
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import model.cityRecord;
import model.countryLanguageRecord;
import model.countryRecord;

/**
 * This Data Access Object is used to establish a connection with the databases and perform
 * all the SQL related activities for all the three tables.
 * @author Tejal Gajare
 */
@Stateless
public class RecordDAO {

    @Resource(lookup = "jdbc/tgajareMp1Mvc")
    DataSource ds;

    public boolean createCountry(countryRecord c) {

        String sql = "insert into Country values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getcode());
            pstmt.setString(2, c.getname());
            pstmt.setString(3, c.getcontinent());
            pstmt.setString(4, c.getregion());
            pstmt.setFloat(5, c.getsurfaceArea());

            if (c.getindepYear() == 0) {
                pstmt.setInt(6, java.sql.Types.INTEGER);
            } else {
                pstmt.setInt(6, c.getindepYear());
            }
            pstmt.setInt(7, c.getpopulation());

            if (c.getlifeExpectancy() == 0) {
                pstmt.setFloat(8, java.sql.Types.FLOAT);
            } else {
                pstmt.setFloat(8, c.getlifeExpectancy());
            }
            pstmt.setFloat(9, c.getvGNP());

            if (c.getvGNPOld() == 0) {
                pstmt.setFloat(10, java.sql.Types.FLOAT);
            } else {
                pstmt.setFloat(10, c.getvGNPOld());
            }

            pstmt.setString(11, c.getlocalName());
            pstmt.setString(12, c.getgovernmentForm());
            pstmt.setString(13, c.getheadOfState());
            pstmt.setInt(14, c.getcapital());
            pstmt.setString(15, c.getcode2());


            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public boolean updateCountry(countryRecord c) {
        String sql = "update Country set "
                + "Name=?, "
                + "Continent=?, "
                + "Region=?, "
                + "SurfaceArea=?, "
                + "IndepYear=?, "
                + "Population=?, "
                + "LifeExpectancy=?, "
                + "GNP=?, "
                + "GNPOld=?, "
                + "LocalName=?, "
                + "GovernmentForm=?, "
                + "HeadOfState=?, "
                + "Capital=?, "
                + "Code2=? "
                + "where Code=?";

        try (Connection con = ds.getConnection()) {


            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, c.getname());
            pstmt.setString(2, c.getcontinent());
            pstmt.setString(3, c.getregion());
            pstmt.setFloat(4, c.getsurfaceArea());
            pstmt.setFloat(5, c.getindepYear());
            pstmt.setInt(6, c.getpopulation());
            pstmt.setFloat(7, c.getlifeExpectancy());
            pstmt.setFloat(8, c.getvGNP());
            pstmt.setFloat(9, c.getvGNPOld());
            pstmt.setString(10, c.getlocalName());
            pstmt.setString(11, c.getgovernmentForm());
            pstmt.setString(12, c.getheadOfState());
            pstmt.setInt(13, c.getcapital());
            pstmt.setString(14, c.getcode2());
            pstmt.setString(15, c.getcode());



            if (pstmt.executeUpdate() == 1) {
                return true;


            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public countryRecord findCountry(String code) {

        countryRecord c = null;

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("select * from Country where Code = ?");

            pstmt.setString(1, code);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                c = new countryRecord(
                        rs.getString("Code"),
                        rs.getString("Name"),
                        rs.getString("Continent"),
                        rs.getString("Region"),
                        rs.getFloat("SurfaceArea"),
                        rs.getInt("IndepYear"),
                        rs.getInt("Population"),
                        rs.getFloat("LifeExpectancy"),
                        rs.getFloat("GNP"),
                        rs.getFloat("GNPOld"),
                        rs.getString("LocalName"),
                        rs.getString("GovernmentForm"),
                        rs.getString("HeadOfState"),
                        rs.getInt("Capital"),
                        rs.getString("Code2"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return c;
    }

    public boolean deleteCountry(String code) {

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("delete from Country where Code = ?");

            pstmt.setString(1, code);

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public List<countryRecord> findAllCountries() {
        String sql = "select * from Country";

        List records = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                countryRecord c = new countryRecord(rs.getString("Code"),
                        rs.getString("Name"),
                        rs.getString("Continent"),
                        rs.getString("Region"),
                        rs.getFloat("SurfaceArea"),
                        rs.getInt("IndepYear"),
                        rs.getInt("Population"),
                        rs.getFloat("LifeExpectancy"),
                        rs.getFloat("GNP"),
                        rs.getFloat("GNPOld"),
                        rs.getString("LocalName"),
                        rs.getString("GovernmentForm"),
                        rs.getString("HeadOfState"),
                        rs.getInt("Capital"),
                        rs.getString("Code2"));
                records.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return records;
    }

    public boolean createCity(cityRecord c) {
        String sql = "insert into City values(?,?,?,?,?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, c.getvID());
            pstmt.setString(2, c.getname());
            pstmt.setString(3, c.getcountryCode());
            pstmt.setString(4, c.getdistrict());
            pstmt.setInt(5, c.getpopulation());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateCity(cityRecord c) {
        String sql = "update City set "
                + "Name=?, "
                + "CountryCode=?, "
                + "District=?, "
                + "Population=? "
                + "where ID=?";

        try (Connection con = ds.getConnection()) {


            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, c.getname());
            pstmt.setString(2, c.getcountryCode());
            pstmt.setString(3, c.getdistrict());
            pstmt.setInt(4, c.getpopulation());
            pstmt.setInt(5, c.getvID());


            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public cityRecord findCity(int cID) {

        cityRecord c = null;

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("select * from City where ID = ?");

            pstmt.setInt(1, cID);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                c = new cityRecord(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getInt("Population"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return c;
    }

    public boolean deleteCity(int ID) {
        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("delete from City where ID = ?");

            pstmt.setInt(1, ID);

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<cityRecord> findAllCities() {
        String sql = "select * from City";

        List records = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cityRecord c = new cityRecord(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getInt("Population"));
                records.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return records;
    }

    public boolean createCountryLang(countryLanguageRecord c) {
        String sql = "insert into CountryLanguage values(?,?,?,?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getcountryCode());
            pstmt.setString(2, c.getlanguage());
            pstmt.setString(3, c.getisOfficial());
            pstmt.setFloat(4, c.getpercentage());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateCountryLang(countryLanguageRecord c) {
        String sql = "update CountryLanguage set "
                + "IsOfficial=?, "
                + "Percentage=? "
                + "where CountryCode=? and Language=?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getisOfficial());
            pstmt.setFloat(2, c.getpercentage());
            pstmt.setString(3, c.getcountryCode());
            pstmt.setString(4, c.getlanguage());


            if (pstmt.executeUpdate() == 1) {
                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public countryLanguageRecord findCountryLang(String code, String lang) {

        countryLanguageRecord c = null;

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("select * from CountryLanguage where CountryCode = ? and Language = ?");

            pstmt.setString(1, code);
            pstmt.setString(2, lang);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                c = new countryLanguageRecord(
                        rs.getString("CountryCode"),
                        rs.getString("Language"),
                        rs.getString("IsOfficial"),
                        rs.getInt("Percentage"));


            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return c;
    }

    public boolean deleteCountryLang(String code, String lang) {
        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt =
                    con.prepareStatement("delete from CountryLanguage where CountryCode = ? and Language = ?");

            pstmt.setString(1, code);
            pstmt.setString(2, lang);
            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<countryLanguageRecord> findAllCountryLangs() {
        String sql = "select * from CountryLanguage";

        List records = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                countryLanguageRecord c = new countryLanguageRecord(rs.getString("CountryCode"),
                        rs.getString("Language"),
                        rs.getString("IsOfficial"),
                        rs.getFloat("Percentage"));
                records.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return records;
    }
}
