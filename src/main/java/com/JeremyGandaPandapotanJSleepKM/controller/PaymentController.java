package com.JeremyGandaPandapotanJSleepKM.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {


    @JsonAutowired(filepath = "src/json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;


    @PostMapping("/{id}/accept")
    public boolean accept ( @RequestParam int id) {
    	 Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
         if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
             payment.status = Invoice.PaymentStatus.SUCCESS;
             return true;
         }
        return false;
    }

    @PostMapping("/payment")
    public boolean cancel (@RequestParam int id) {
    	Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/create")
    public Payment create (
    		@RequestParam int buyerId, 
    		@RequestParam int renterId, 
    		@RequestParam int roomId, 
    		@RequestParam String from, 
    		@RequestParam String to
    		)throws ParseException {
    	Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId && pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId && pred.accountId == roomId);
    	
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(acc.balance >= price && acc != null && room != null  ){
            Payment payment = new Payment(acc.id, buyerId, renterId, roomId, fromDate, toDate);
            acc.balance -= price;
            payment.status=Invoice.PaymentStatus.WAITING;
            payment.makeBooking(fromDate, toDate, room);
            paymentTable.add(payment);
            return payment;
        }
        return null;
    }

    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
}
