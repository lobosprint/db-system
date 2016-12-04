package persistence;

import models.Administrative;
import models.Job;
import models.Person;
import models.Student;
import play.mvc.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

/**
 * Created by cristian on 11-15-16.
 */
public class DAOLogin implements DAOGeneric{

    DAOAdministrative daoAdministrative = new DAOAdministrative();
    DAOStudent daoStudent = new DAOStudent();

    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        return null;
    }

    @Override
    public void updateObject(Object object) {
    }

    @Override
    public void deleteObject(Object object) {
    }

    public Result getLogin(String mail, String pass){
        Person person = new Person();
        String tipoUser = "";
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
//            String sql = "SELECT id_person, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id FROM person WHERE id_person = ?";
//            stmt = conn.prepareStatement(sql);
//            stmt.setInt(1, idPerson);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                student = new Student(  idPerson, rs.getInt("id_student"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
//                        new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"), rs.getString("rum_id"),
//                        rs.getBoolean("handiecap"));
//            }
//            rs.close();
        } catch (Exception e){
            System.out.println("Fallo iniciando la sesion, error: ");
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
        return ok(toJson(person));
    }
}
