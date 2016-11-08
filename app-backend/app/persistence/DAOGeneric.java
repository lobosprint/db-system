package persistence;

import models.Student;

import java.util.ArrayList;

/**
 * Created by cristian on 11-07-16.
 */
public interface DAOGeneric {
    public Object getAllObjetcs();
    public Object getObjectById(Integer id);
    public void updateObject(Object object);
    public void deleteObject(Object object);
}
