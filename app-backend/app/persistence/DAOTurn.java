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

    DAOGeneric daoStudent = new DAOStudent();
    DAOGeneric daoAdministrative = new DAOAdministrative();

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
            String sql = "SELECT id_turn, id_student, id_administrative, penalty_cost, start_time, finish_time, description FROM turn WHERE id_turn = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                turn = new Turn(id, (Student) daoStudent.getObjectById(rs.getInt("id_student")), (Administrative) daoAdministrative.getObjectById(rs.getInt("id_administrative")) ,
                                rs.getString("description"), new DateTime(rs.getTimestamp("start_time")), new DateTime(rs.getTimestamp("finish_time")), rs.getInt("penalty_cost"));
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
}
