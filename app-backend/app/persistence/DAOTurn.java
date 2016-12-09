package persistence;

import models.*;
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

    public Object getAllJobsofTurnsPendingByAdmin(Integer idAdministrative){
        ArrayList<Job> jobs = new ArrayList<Job>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT DISTINCT d.id_job as id_job, name_job, d.description as description " +
                            "FROM turn as a " +
                            "INNER JOIN administrative as b ON a.id_administrative = b.id_administrative " +
                            "INNER JOIN position_type as c ON b.id_position = c.id_position  " +
                            "INNER JOIN job as d ON c.id_job = d.id_job " +
                            "WHERE attended = FALSE AND a.id_administrative = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAdministrative);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                jobs.add(new Job(rs.getInt("id_job"), rs.getString("name_job"), rs.getString("description")));
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
        return jobs;
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

    public Object getAllTurnsByStudentNumber(Integer idStudent){
        ArrayList<Turn> turns = new ArrayList<Turn>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT id_turn, t.id_student, id_administrative,"+
                    "penalty_cost, start_time, finish_time, description, attended "+
                    "FROM turn as t "+
                    "INNER JOIN student as s on t.id_student=s.id_student "+
                    "INNER JOIN person as p on s.id_person=p.id_person " +
                    "WHERE attended = FALSE AND rum_id = ?  ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Integer.toString(idStudent));
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
        return turns;
    }

    public Object getAllCommentsByTurn(Integer idTurn) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_comment, id_turn, description FROM commentary WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idTurn);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                comments.add(new Comment(rs.getInt("id_comment"), idTurn, rs.getString("description")));
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
        return comments;
    }

    public Result addTurn(Integer id_student, Integer id_administrative, Integer id_position, Integer penalty_cost, String description) {
        Turn turn = new Turn();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "INSERT INTO public.turn( id_student, id_administrative, id_position, penalty_cost, description, attended) " +
                            "VALUES (?, ?, ?, ?, ?, FALSE)";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_student);
            stmt.setInt(2, id_administrative);
            stmt.setInt(3, id_position);
            stmt.setInt(4, penalty_cost);
            stmt.setString(5, description);
            stmt.executeUpdate();
            ResultSet TurnInsert = stmt.getGeneratedKeys();
            if (TurnInsert.next()) {
                turn = new Turn(   TurnInsert.getInt(1), (Student) daoStudent.getObjectById(id_student),
                                        (Administrative) daoAdministrative.getObjectByIdAndPosition(id_administrative, id_position), description, penalty_cost, Boolean.FALSE);
            }
        } catch (Exception e){
            return badRequest("Error agregando el turno, informacion mal ingresada");
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
        return ok(toJson(turn));
    }

    public Result addStartTime(Integer id_turn) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE turn SET start_time= now() WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_turn);
            stmt.executeUpdate();
        } catch (Exception e){
            return badRequest("Error asignando la hora de comienzo del turno, informacion mal ingresada");
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
        return ok("Tiempo de inicio del turno registrado satisfactoriamente.");
    }

    public Result addFinishTime(Integer id_turn) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE turn SET finish_time= now(), attended = TRUE WHERE id_turn = ? AND now() > start_time";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_turn);
            stmt.executeUpdate();
        } catch (Exception e){
            return badRequest("Error asignando la hora de finalizacion del turno, informacion mal ingresada");
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
        return ok("Tiempo de finalizacion del turno registrado satisfactoriamente.");
    }

    public Result addAttendedTurn(Integer id_turn) {
        Penalty penalty = new Penalty();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE turn SET start_time = NULL, finish_time= NULL, attended = FALSE WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_turn);
            stmt.executeUpdate();
            sql = "INSERT INTO penalty(id_turn) VALUES (?);";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_turn);
            stmt.executeUpdate();
            ResultSet penaltyInsert = stmt.getGeneratedKeys();
            if (penaltyInsert.next()) {
                penalty = new Penalty(penaltyInsert.getInt(1), getObjectById(id_turn));
            }
        } catch (Exception e){
            return badRequest("Error registrando la ausencia del estudiante al turno, informacion mal ingresada");
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
        return ok(toJson(penalty));
    }

    public Result addCommentTurn(Integer idTurn, String description){
        Comment comment = new Comment();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO commentary(id_turn, description) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTurn);
            stmt.setString(2, description);
            stmt.executeUpdate();
            ResultSet commentInsert = stmt.getGeneratedKeys();
            if (commentInsert.next()) {
                comment = new Comment(commentInsert.getInt(1), idTurn, description);
            }
        } catch (Exception e){
            return badRequest("Error agregando el turno, informacion mal ingresada");
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
        return ok(toJson(comment));
    }

    public Result updateComment(Integer id_comment, Integer id_turn, String description) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE commentary SET description = ? WHERE id_comment = ? AND id_turn = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, description);
            stmt.setInt(2, id_comment);
            stmt.setInt(3, id_turn);
            stmt.executeUpdate();
        } catch (Exception e){
            return badRequest("Error actualizando la descripcion del turno, informacion mal ingresada");
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
        return ok("Descripcion del turno actualizada satisfactoriamente.");
    }

    public Result deleteComment(Integer id_comment, Integer id_turn) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM commentary WHERE id_comment = ? AND id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_comment);
            stmt.setInt(2, id_turn);
            stmt.executeUpdate();
        } catch (Exception e){
            return badRequest("Error eliminando el comentario del turno, informacion mal ingresada");
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
        return ok("Turno eliminado satisfactoriamente.");
    }


    public Result deleteTurn(Integer id_turn) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM turn WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_turn);
            stmt.executeUpdate();
        } catch (Exception e){
            return badRequest("Error eliminando el turno, ID del turno incorrecto");
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
        return ok("Turno eliminado satisfactoriamente.");
    }
}
