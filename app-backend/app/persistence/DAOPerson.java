package persistence;

import models.Person;
import models.Student;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by cristian on 11-07-16.
 */
public class DAOPerson implements DAOGeneric{
    @Override
    public ArrayList<Student> getAllObjetcs() {
        return null;
    }

    @Override
    public Person getObjectById(Integer id) {
        Person person = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT first_name, middle_name, last_name, date_birth, phone, email, rum_id FROM person WHERE id_person=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                person = new Person(id, rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), new DateTime(rs.getDate("date_birth")),
                        rs.getString("phone"), rs.getString("email"), rs.getString("rum_id"));
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
        //System.out.println("Informacion que retorna first_name: " + person.getName() + " middle_name: " + person.getMiddleName() + " last_name: " + person.getLastName());
        return person;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }
}
