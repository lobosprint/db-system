package controllers;

import com.google.inject.Inject;
import models.Payment;
import models.Payment;
import org.joda.time.DateTime;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;

import static play.libs.Json.toJson;

/**
 * Created by cristian on 10-14-16.
 */
public class PaymentController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addPayment (){
        Payment payment = formFactory.form(Payment.class).bindFromRequest().get();
        if(!payment.confirmationNumber.equals("0")){
            return ok("Added PAYMENT successfully " + payment.confirmationNumber);
        } else {
            return  internalServerError("Must provide the PAYMENT confirmation number like minimum");
        }
    }

    public Result getPayment(){
        Payment payment;
        payment = new Payment( 1230, new DateTime());
        return ok(toJson(payment));
    }

    public Result getAllPayments(){
        ArrayList<Payment> paymentsList;
        paymentsList = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Payment payment;

            payment = new Payment(147850+i, new DateTime());
            paymentsList.add(payment);
        }
        return ok(toJson(paymentsList));
    }

}
