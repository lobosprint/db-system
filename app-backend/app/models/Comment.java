package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Comment extends Model {
    public int      idComment;
        public String   description;

    Comment(){
        idComment = 0;
        description = "";
    }

    public Comment(int idComment, String description){
        this.idComment = idComment;
        this.description = description;
    }
}
