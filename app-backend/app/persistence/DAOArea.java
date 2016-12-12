package persistence;

import models.Area;
import models.Job;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by cristian on 11-08-16.
 */
public class DAOArea implements DAOGeneric{

    @Override
    public Object getAllObjetcs() {
        ArrayList<Area> areas = new ArrayList<Area>();
        Connection conn = DbConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql =    "SELECT id_area, name_area FROM area";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                areas.add(new Area(rs.getInt("id_area"), rs.getString("name_area")));
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
        return areas;
    }

    @Override
    public Object getObjectById(Integer id) {
        Area area = null;
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT id_area, name_area FROM area WHERE id_area = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                area = new Area(id, rs.getString("name_area"));
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
//        System.out.println("Informacion que retorna Nombre de Area: " + area.getName() + " ID area: " + area.getIdArea());
        return area;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }

    public Object getAllJobsOfArea(Integer id) {
        ArrayList<Job> jobs = new ArrayList<Job>();
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql =    "SELECT DISTINCT b.id_job as id_job, b.name_job as name_job, b.description as description " +
                    "FROM position_type as a " +
                    "INNER JOIN administrative as c ON a.id_position = c.id_position\n " +
                    "INNER JOIN job as b ON a.id_job = b.id_job " +
                    "WHERE id_area = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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
//
//        for(int i = 0; i < students.size(); i++){
//            System.out.println("Student ID: " + students.get(i).getIdStudent() + "Person ID: " + students.get(i).getIdPerson());
//        }
        return jobs;
    }

}
