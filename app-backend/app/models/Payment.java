package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Payment extends Model {
    public Integer  confirmationNumber;
    public Date     date;

    Payment(){
        confirmationNumber = 0;
        date = null;
    }
}
