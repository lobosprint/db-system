package persistence;

import models.Area;
import models.Job;
import models.Location;
import models.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOPosition implements DAOGeneric {
    DAOGeneric DaoArea = new DAOArea();
    DAOGeneric DaoJob = new DAOJob();
    DAOGeneric DaoLocation = new DAOLocation();
    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        Position position = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_position, id_area, id_job, id_place FROM position_type where id_position = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                position = new Position(id, (Area) DaoArea.getObjectById(rs.getInt("id_area")), (Job) DaoJob.getObjectById(rs.getInt("id_job")), (Location) DaoLocation.getObjectById(rs.getInt("id_place")));
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
        return position;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }
}
