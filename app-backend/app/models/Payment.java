package models;

import java.util.Date;

/**
 * Created by cristian on 10-14-16.
 */
public class Payment {
    public Integer  confirmationNumber;
    public Date     date;

    public Payment(){
        confirmationNumber = 0;
        date = null;
    }
}
