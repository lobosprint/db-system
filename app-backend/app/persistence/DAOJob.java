package persistence;

import models.Administrative;
import models.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOJob implements DAOGeneric{

    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        Job job = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_job, name_job, description FROM job WHERE id_job = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                job = new Job(id, rs.getString("name_job"), rs.getString("description"));
            }
            rs.close();
        } catch (Exception e){
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
//        System.out.println("Informacion que retorna Nombre: " + job.getName() + " Description: " + job.getDescription() + " ID JOB: " + job.getIdJob());
        return job;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }

}
