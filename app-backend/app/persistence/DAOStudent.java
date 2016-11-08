package persistence;

import models.Student;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;

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
//
//        for(int i = 0; i < students.size(); i++){
//            System.out.println("Student ID: " + students.get(i).getIdStudent() + "Person ID: " + students.get(i).getIdPerson());
//        }

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
//        System.out.println("Informacion que retorna first_name: " + student.getName() + " middle_name: " + student.getMiddleName() + " last_name: " + student.getLastName()
//                + " IDSTUDENT: " + student.getIdStudent() + " IDPERSON: " + student.getIdPerson());
        return student;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }
}
