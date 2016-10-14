package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-13-16.
 */
@Entity
public class Login extends Model {
    public String mail;
    public  String pass;

     public Login(){
         mail = "";
         pass = "";

     }

}
