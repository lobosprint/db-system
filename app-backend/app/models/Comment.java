package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Comment extends Model {
    private int      idComment;
    private int      idTurn;
    private String   description;

    public Comment(){
        idComment = 0;
        idTurn = 0;
        description = "";
    }

    public Comment(int idComment, int idTurn, String description) {
        this.idComment = idComment;
        this.idTurn = idTurn;
        this.description = description;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
