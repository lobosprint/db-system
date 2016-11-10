package persistence;

import models.Administrative;
import models.Student;
import models.Turn;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cristian on 11-07-16.
 */
public class DAOTurn implements DAOGeneric {

    DAOStudent daoStudent = new DAOStudent();
    DAOAdministrative daoAdministrative = new DAOAdministrative();

    @Override
    public ArrayList<Turn> getAllObjetcs() {
        return null;
    }

    @Override
    public Turn getObjectById(Integer id) {
        Turn turn = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_turn, id_student, id_administrative, penalty_cost, start_time, finish_time, description, attended FROM turn WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turn = new Turn(id, (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                                rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"),
                                rs.getBoolean("attended"));
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
        return turn;
    }

    @Override
    public void updateObject(Object object) {
    }

    @Override
    public void deleteObject(Object object) {
    }

    public Object getAllPeopleInLineByAdmin(Integer idArea, Integer idJob, Integer idAdmin){
        ArrayList<Turn> turns = new ArrayList<Turn>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT a.id_turn as id_turn, a.id_student as id_student, a.id_administrative as id_administrative, penalty_cost, start_time, finish_time, description, attended  " +
                            "FROM turn as a INNER JOIN administrative as b ON a.id_administrative = b.id_administrative " +
                            "INNER JOIN position_type as c ON b.id_position = c.id_position " +
                            "WHERE a.id_administrative = ? AND c.id_area = ? AND c.id_job = ? AND a.attended = FALSE";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAdmin);
            stmt.setInt(2, idArea);
            stmt.setInt(3, idJob);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turns.add(new Turn(rs.getInt("id_turn"), (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                        rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"),
                        rs.getBoolean("attended")));
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
        return turns;
    }

    public Object getAllTurnsPendingByStudent(Integer idStudent){
        ArrayList<Turn> turns = new ArrayList<Turn>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT id_turn, id_student, id_administrative, penalty_cost, start_time, finish_time, description, attended FROM turn " +
                            "WHERE attended = FALSE AND id_student = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idStudent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turns.add(new Turn(rs.getInt("id_turn"), (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                        rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"),
                        rs.getBoolean("attended")));
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
        return turns;
    }

    public Object getAllTurnsPendingByAdmin(Integer idAdministrative){
        ArrayList<Turn> turns = new ArrayList<Turn>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT id_turn, id_student, id_administrative, penalty_cost, start_time, finish_time, description, attended FROM turn " +
                            "WHERE attended = FALSE AND id_administrative = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAdministrative);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turns.add(new Turn(rs.getInt("id_turn"), (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                        rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"),
                        rs.getBoolean("attended")));
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
        return turns;
    }

    public Object getAllTurnsPendingByAdminJob(Integer idAdministrative, Integer idJob){
        ArrayList<Turn> turns = new ArrayList<Turn>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT id_turn, id_student, a.id_administrative as id_administrative, penalty_cost, start_time, finish_time, description, attended " +
                            "FROM turn as a " +
                            "INNER JOIN administrative as b ON a.id_administrative = b.id_administrative " +
                            "INNER JOIN position_type as c ON b.id_position = c.id_position " +
                            "WHERE a.id_administrative = ? AND c.id_job = ? AND attended = FALSE";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAdministrative);
            stmt.setInt(2, idJob);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turns.add(new Turn(rs.getInt("id_turn"), (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                        rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"),
                        rs.getBoolean("attended")));
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
        return turns;
    }

}
