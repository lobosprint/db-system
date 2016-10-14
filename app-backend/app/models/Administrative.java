package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Administrative extends Person{
        public Position position;

    public Administrative(){
        position = new Position();
    }
}
