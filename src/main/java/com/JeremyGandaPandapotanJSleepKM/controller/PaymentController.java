package com.JeremyGandaPandapotanJSleepKM.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JeremyGandaPandapotanJSleepKM.Account;
import com.JeremyGandaPandapotanJSleepKM.Algorithm;
import com.JeremyGandaPandapotanJSleepKM.Payment;
import com.JeremyGandaPandapotanJSleepKM.Room;
import com.JeremyGandaPandapotanJSleepKM.*;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

/**
 * The PaymentController class provides REST API endpoints for creating and managing payments.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {


    @JsonAutowired(filepath = "src/json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;


    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id){
        Payment payCheck = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        if (Invoice.PaymentStatus.WAITING.toString().equals("WAITING") && payCheck != null ) {
            payCheck.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * The cancel() method cancels the payment with the given ID and updates its status to FAILED.
     * The method also refunds the buyer's balance with the payment amount.
     *
     * @param id The ID of the payment to be cancelled.
     *
     * @return true if the payment is successfully cancelled, or false if the payment does not exist or is not in a WAITING status.
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id){

        Payment payCheck = Algorithm.<Payment>find(paymentTable, payment -> payment.id == id);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, account -> account.id == payCheck.buyerId);
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == payCheck.getRoomId());

        if (payCheck != null && Invoice.PaymentStatus.WAITING.toString().equals("WAITING")) {
            payCheck.status = Invoice.PaymentStatus.FAILED;
            accountCheck.balance += roomCheck.price.price;
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/create")
    public Payment create( @RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId,  @RequestParam String from,@RequestParam String to){
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromTgl = sdf.parse(from);
            Date toTgl = sdf.parse(to);
            long day = toTgl.getTime() - fromTgl.getTime();
            double totalPay = roomCheck.price.price * (TimeUnit.MILLISECONDS.toDays(day));
            if(accountCheck != null && roomCheck != null && totalPay <= accountCheck.balance && Payment.availability(fromTgl, toTgl, roomCheck)){
                Payment paid = new Payment(buyerId, renterId, roomId, fromTgl, toTgl);
                accountCheck.balance -= totalPay;
                paid.totalPrice = totalPay;
                paid.status = Invoice.PaymentStatus.WAITING;
                Payment.makeBooking(fromTgl, toTgl, roomCheck);
                paymentTable.add(paid);
                return paid;
            }else{
                return null;
            }
        } catch (ParseException p) {
            p.printStackTrace();
        }
        return null;
    }

    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    
    @PostMapping("/{id}/submit")
    public boolean submit(@RequestParam int id){
        return false;
    }
    
    @Override
    public Payment getById(int id) {
        return Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
    }

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
    
}
