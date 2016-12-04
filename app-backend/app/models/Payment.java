package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Payment extends Model {
    private int         idPayment;
    private Integer     confirmationNumber;
    private DateTime    datePayment;
    private String      cardType;
    private double      cardNumber;
    private DateTime    dateExpiration;


    public Payment(){
        idPayment = 0;
        confirmationNumber = 0;
        datePayment = null;
        cardType = "";
        cardNumber = 0;
        dateExpiration = null;
    }

    public Payment(int idPayment, Integer confirmationNumber, DateTime datePayment, String cardType, double cardNumber, DateTime dateExpiration) {
        this.idPayment = idPayment;
        this.confirmationNumber = confirmationNumber;
        this.datePayment = datePayment;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.dateExpiration = dateExpiration;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(Integer confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public DateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(DateTime datePayment) {
        this.datePayment = datePayment;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(double cardNumber) {
        this.cardNumber = cardNumber;
    }

    public DateTime getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(DateTime dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
