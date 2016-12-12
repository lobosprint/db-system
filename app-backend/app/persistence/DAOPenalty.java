package persistence;

import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cristian on 11-10-16.
 */
public class DAOPenalty implements DAOGeneric{

    DAOTurn daoTurn = new DAOTurn();
    DAOPayment daoPayment = new DAOPayment();

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

    public Object getPenaltiesByStudent(Integer idStudent){
        ArrayList<Penalty> penalties = new ArrayList<Penalty>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT a.id_penalty as id_penalty, a.id_payment as id_payment, a.id_turn as id_turn  " +
                            "FROM penalty as a " +
                            "INNER JOIN turn as b ON a.id_turn = b.id_turn " +
                            "INNER JOIN student as c ON b.id_Student = c.id_Student " +
                            "WHERE c.id_Student = ? AND a.id_payment IS NULL";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idStudent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                penalties.add(new Penalty(rs.getInt("id_penalty"), (Payment) daoPayment.getObjectById(rs.getInt("id_payment")) , (Turn) daoTurn.getObjectById(rs.getInt("id_turn"))));
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
        return penalties;
    }
}
