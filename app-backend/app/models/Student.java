package models;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Student extends Person{
    public boolean handiecap;

    public Student(){
        new Person();
        handiecap = false;
    }
}
