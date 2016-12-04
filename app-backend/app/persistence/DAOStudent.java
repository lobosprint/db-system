package persistence;

import models.Student;
import org.joda.time.DateTime;
import play.mvc.Result;
import services.ExampleMail;

import java.sql.*;
import java.util.*;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by cristian on 11-07-16.
 */
public class DAOStudent implements DAOGeneric{
    @Override
    public ArrayList<Student> getAllObjetcs() {
        ArrayList<Student> students = new ArrayList<Student>();
        Connection conn = DbConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql =    "SELECT id_person, id_student, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id, handiecap" +
                            " FROM Student NATURAL JOIN Person";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                students.add(new Student(rs.getInt("id_Person"), rs.getInt("id_student"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
                        new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"), rs.getString("rum_id"), rs.getBoolean("handiecap")));
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
        return students;
    }

    @Override
    public Object getObjectById(Integer id) {
        Student student = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_person, id_student, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id, handiecap FROM student NATURAL JOIN Person WHERE id_student = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                student = new Student(  rs.getInt("id_Person"), id, rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
                        new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"), rs.getString("rum_id"),
                        rs.getBoolean("handiecap"));
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
        return student;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }

    public Object getObjectByIdPerson(Integer idPerson){
        Student student = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_person, id_student, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id, handiecap FROM student NATURAL JOIN Person WHERE id_person = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPerson);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                student = new Student(  idPerson, rs.getInt("id_student"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
                        new DateTime(rs.getDate("date_birth")), rs.getString("phone"), rs.getString("email"), rs.getString("password"), rs.getString("rum_id"),
                        rs.getBoolean("handiecap"));
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
        return student;
    }

    public Result addStudent(Boolean handiecap, String first_name, String middle_name, String last_name, String date_birth, String phone, String email, String password, String rum_id){
        ExampleMail mail = new ExampleMail();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO person(first_name, middle_name, last_name, date_birth, phone, email, password, rum_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, first_name);
            stmt.setString(2, middle_name);
            stmt.setString(3, last_name);
            stmt.setString(4, date_birth);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setString(7, password);
            stmt.setString(8, rum_id);
            stmt.executeUpdate();
            ResultSet personInsert = stmt.getGeneratedKeys();
            if (personInsert.next()) {
                String sql2 = "INSERT INTO student(id_person, handiecap) " +
                        "VALUES (?, ?)";
                stmt = conn.prepareStatement(sql2);
                stmt.setInt(1,personInsert.getInt(1));
                stmt.setBoolean(2, handiecap);
                stmt.executeUpdate();
            }
            mail.sendGet(email, "Registro Turn4U", "Gracias por registrarte en nuestro sitio web esperamos sigas disfrutando de nuestros servicios.");
        } catch (Exception e){
            return badRequest("Error agregando el estudiante, informacion mal ingresada");
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
        return ok("Estudiante agregado satisfactoriamente.");
    }

}
