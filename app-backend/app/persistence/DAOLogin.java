package persistence;

import models.Administrative;
import models.Job;
import models.Person;
import models.Student;
import org.joda.time.DateTime;
import play.mvc.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static play.libs.Json.toJson;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by cristian on 11-15-16.
 */
public class DAOLogin implements DAOGeneric{

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
        Administrative administrative = null;
        Student student = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT a.id_person as id_person, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id, id_administrative, id_position " +
                            "FROM person as a NATURAL JOIN administrative WHERE email = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mail);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                administrative = new Administrative(rs.getInt("id_person"), rs.getInt("id_administrative"), rs.getString("first_name"), rs.getString("middle_name"),
                        rs.getString("last_name"), new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"),
                        rs.getString("rum_id"));
                rs.close();
                return ok(toJson(administrative));
            }else{
                try {
                    sql =   "SELECT a.id_person as id_person, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id, id_student, handiecap " +
                            "FROM person as a NATURAL JOIN student WHERE email = ? AND password = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, mail);
                    stmt.setString(2, pass);
                    rs = stmt.executeQuery();
                    if(rs.next()) {
                        student = new Student(rs.getInt("id_person"), rs.getInt("id_student"), rs.getString("first_name"), rs.getString("middle_name"),
                                rs.getString("last_name"), new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"),
                                rs.getString("rum_id"), rs.getBoolean("handiecap"));
                    rs.close();
                    return ok(toJson(student));
                    } else {
                        return badRequest("El usuario no esta registrado en la plataforma por favor verifique sus credenciales.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return ok(toJson(null));
    }
}
