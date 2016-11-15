package persistence;

import models.Administrative;
import models.Position;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOAdministrative implements DAOGeneric{
    DAOPosition daoPosition = new DAOPosition();

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

    public Object getAllAdministrativesOfJob(Integer idArea, Integer idJob) {
        ArrayList<Administrative> admins = new ArrayList<Administrative>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT  DISTINCT id_administrative FROM administrative as a " +
                         "INNER JOIN position_type as b ON a.id_position = b.id_position " +
                         "WHERE id_area = ? AND id_job = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idArea);
            stmt.setInt(2, idJob);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                admins.add((Administrative) this.getObjectById(rs.getInt("id_administrative")));
            }
            rs.close();
        } catch (Exception e){
            System.out.println("Fallo extrayendo la informacion");
            e.printStackTrace();
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
//
//        for(int i = 0; i < students.size(); i++){
//            System.out.println("Student ID: " + students.get(i).getIdStudent() + "Person ID: " + students.get(i).getIdPerson());
//        }
        return admins;
    }

}
