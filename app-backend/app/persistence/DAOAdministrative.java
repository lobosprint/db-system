package persistence;

import models.Administrative;
import models.Area;
import models.Position;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOAdministrative implements DAOGeneric{
    DAOGeneric daoPosition = new DAOPosition();

    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        Administrative administrative = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT id_administrative, id_person, id_position, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id " +
                            "FROM Administrative NATURAL JOIN Person WHERE id_administrative = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                administrative =    new Administrative(rs.getInt("id_Person"), id, rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
                                    new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"), rs.getString("rum_id"),
                                    (Position) daoPosition.getObjectById(rs.getInt("id_position")));
            }
            rs.close();
        } catch (Exception e){
        }finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
//        System.out.println("Informacion que retorna first_name: " + administrative.getName() + " middle_name: " + administrative.getMiddleName() + " last_name: " + administrative.getLastName()
//                + " IDSTUDENT: " + administrative.getIdAdministrative() + " IDPERSON: " + administrative.getIdPerson() + " IdPosition: " + administrative.getPosition().getIdPosition()
//                + " Area: " + administrative.getPosition().getArea().getName() + " Job: " + administrative.getPosition().getJob().getName() + " Location: " + administrative.getPosition().getLocation().getOffice());
        return administrative;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }
}
