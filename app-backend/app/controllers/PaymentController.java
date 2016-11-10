package controllers;

import com.google.inject.Inject;
import models.Payment;
import models.Payment;
import org.joda.time.DateTime;
import persistence.DAOPayment;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by cristian on 10-14-16.
 */
public class PaymentController extends Controller{

    DAOPayment daoPayment = new DAOPayment();

    @Inject
    private FormFactory formFactory;

    public Result addPayment (){
        Payment payment = formFactory.form(Payment.class).bindFromRequest().get();
        if(!payment.confirmationNumber.equals("1")){
            return ok("Added PAYMENT successfully " + payment.confirmationNumber);
        } else {
            return  internalServerError("Must provide the PAYMENT confirmation number like minimum");
        }
    }

    public Result getPayment(Integer id){
        return ok(toJson(daoPayment.getObjectById(id)));
    }

    public Result getAllPayments(){
        ArrayList<Payment> paymentsList;
        paymentsList = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Payment payment;

            payment = new Payment((i+1), 147850+i, new DateTime());
            paymentsList.add(payment);
        }
        return ok(toJson(paymentsList));
    }

    public Result getPaymentsByStudent(Integer idStudent){
        return ok(toJson((List<Payment>) daoPayment.getPenaltiesByStudent(idStudent)));
    }

}
