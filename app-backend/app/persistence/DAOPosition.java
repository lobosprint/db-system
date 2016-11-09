package persistence;

import models.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOPosition implements DAOGeneric {

    DAOArea daoArea = new DAOArea();
    DAOJob daoJob  = new DAOJob();
    DAOLocation daoLocation = new DAOLocation();

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
                position = new Position(id, (Area) daoArea.getObjectById(rs.getInt("id_area")), (Job) daoJob.getObjectById(rs.getInt("id_job")),
                                            (Location) daoLocation.getObjectById(rs.getInt("id_place")));
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
