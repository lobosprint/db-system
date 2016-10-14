package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Payment extends Model {
    public Integer  confirmationNumber;
    public DateTime date;

    Payment(){
        confirmationNumber = 0;
        date = null;
    }

    public Payment(Integer confirmationNumber, DateTime date) {
        this.confirmationNumber = confirmationNumber;
        this.date = date;
    }
}
