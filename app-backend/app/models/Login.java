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

     Login(){
         mail = "";
         pass = "";
     }

    public Login(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }
}
