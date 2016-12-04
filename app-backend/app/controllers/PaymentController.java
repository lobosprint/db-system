package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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
        JsonNode json = request().body().asJson();
        Integer confirmation_number = json.findValue("conf_number").asInt();
        String date_payment = json.findValue("date_payment").asText().substring(0,10);
        String type_card = json.findValue("type_card").asText();
        String numbers_card = json.findValue("numbers_card").asText();
        String expiration_card = json.findValue("expiration_card").asText().substring(0,10);
        return daoPayment.addPayment(confirmation_number, date_payment, type_card, numbers_card, expiration_card);
    }

    public Result getPayment(Integer id){
        return ok(toJson(daoPayment.getObjectById(id)));
    }

    public Result getPaymentsByStudent(Integer idStudent){
        return ok(toJson((List<Payment>) daoPayment.getPenaltiesByStudent(idStudent)));
    }

}
