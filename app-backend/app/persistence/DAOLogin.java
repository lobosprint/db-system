package persistence;

import models.Administrative;
import models.Job;
import models.Person;
import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public Object getLogin(String table, String mail, String password){
        ArrayList<Object> returns = new ArrayList<Object>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            if (table.equals(table)) {
                String sql = "SELECT DISTINCT id_person FROM person NATURAL JOIN administrative WHERE email = ? AND password = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, mail);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println("........ENTROOOOOOOO PRIMER IF........");
                    returns.add(daoAdministrative.getObjectByIdPerson(rs.getInt("id_person")));
                }
                rs.close();
            }else{
                String sql = "SELECT DISTINCT id_person FROM person NATURAL JOIN student WHERE email = ? AND password = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, mail);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    returns.add(daoStudent.getObjectByIdPerson(rs.getInt("id_person")));
                    System.out.println("........ENTROOOOOOOO SEGUNDO IF........");
                }
                rs.close();
            }
        } catch (Exception e){
            System.out.println("Fallo iniciando la sesion");
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
        return returns;
    }
}
