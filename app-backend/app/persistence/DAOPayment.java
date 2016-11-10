package persistence;

import models.*;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cristian on 11-10-16.
 */
public class DAOPayment implements DAOGeneric {

    DAOTurn daoTurn = new DAOTurn();

    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        Payment payment = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_payment, confirmation_number, date_payment FROM payment WHERE id_payment = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payment = new Payment(id, rs.getInt("confirmation_number"), new DateTime(rs.getDate("date_payment")));
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
        return payment;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }

    public Object getPenaltiesByStudent(Integer idStudent) {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT d.id_payment as id_payment, d.confirmation_number as confirmation_number, d.date_payment as date_payment " +
                            "FROM penalty as a " +
                            "INNER JOIN turn as b ON a.id_turn = b.id_turn " +
                            "INNER JOIN student as c ON b.id_Student = c.id_Student " +
                            "INNER JOIN payment as d ON a.id_payment = d.id_payment " +
                            "WHERE a.id_Payment IS NOT NULL AND c.id_Student = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idStudent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payments.add(new Payment(rs.getInt("id_payment"), rs.getInt("confirmation_number") , new DateTime(rs.getDate("date_payment"))));
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
        return payments;
    }
}
