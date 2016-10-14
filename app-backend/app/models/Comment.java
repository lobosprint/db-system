package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Comment extends Model {
    public String description;

    Comment(){
        description = "";
    }

    public Comment(String description){
        this.description = description;
    }
}
