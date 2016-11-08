package persistence;

import models.Location;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOLocation implements DAOGeneric {

    @Override
    public Object getAllObjetcs() {
        return null;
    }

    @Override
    public Object getObjectById(Integer id) {
        Location location = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_place, office, building, longitude, latitude FROM place WHERE id_place = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                location = new Location(id, rs.getString("office"), rs.getString("building"), rs.getString("longitude"), rs.getString("latitude"));
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
//        System.out.println("Informacion que retorna building: " + location.getBuilding() + " Office: " + location.getOffice() + " ID Location: " + location.getIdLocation());
        return location;
    }

    @Override
    public void updateObject(Object object) {
    }

    @Override
    public void deleteObject(Object object) {

    }
}
