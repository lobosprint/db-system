package persistence;

import models.*;
import org.joda.time.DateTime;
import play.mvc.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

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
            String sql = "SELECT id_payment, confirmation_number, date_payment, type_card, numbers_card, expiration_card FROM payment WHERE id_payment = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payment =   new Payment(id, rs.getInt("confirmation_number"), new DateTime(rs.getDate("date_payment")), rs.getString("type_card"), rs.getDouble("numbers_card"),
                            new DateTime(rs.getDate("expiration_card")));
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
            String sql =    "SELECT d.id_payment as id_payment, confirmation_number, date_payment, type_card, numbers_card, expiration_card " +
                            "FROM penalty as a " +
                            "INNER JOIN turn as b ON a.id_turn = b.id_turn " +
                            "INNER JOIN student as c ON b.id_Student = c.id_Student " +
                            "INNER JOIN payment as d ON a.id_payment = d.id_payment " +
                            "WHERE a.id_Payment IS NOT NULL AND c.id_Student = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idStudent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payments.add(new Payment(rs.getInt("id_payment"), rs.getInt("confirmation_number"), new DateTime(rs.getDate("date_payment")), rs.getString("type_card"), rs.getDouble("numbers_card"),
                        new DateTime(rs.getDate("expiration_card"))));
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

    public Result addPayment(Integer confirmation_number, String date_payment, String type_card, Integer numbers_card, String expiration_card, Integer id_penalty) {
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO payment( confirmation_number, date_payment, type_card, numbers_card, expiration_card) " +
                         "VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setInt(1, confirmation_number);
            stmt.setString(2, date_payment);
            stmt.setString(3, type_card);
            stmt.setInt(4, numbers_card);
            stmt.setString(5, expiration_card);
            stmt.executeUpdate();
            ResultSet paymentInsert = stmt.getGeneratedKeys();
            if (paymentInsert.next()) {
                String sql2 =   "UPDATE penalty SET id_payment = ? WHERE id_penalty = ?";
                stmt = conn.prepareStatement(sql2);
                stmt.setInt(1,paymentInsert.getInt(1));
                stmt.setInt(2, id_penalty);
                stmt.executeUpdate();
            }
        } catch (Exception e){
            return badRequest("Error agregando el pago, informacion mal ingresada" + e.toString());
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
        return ok("Pago agregado satisfactoriamente.");
    }


}
