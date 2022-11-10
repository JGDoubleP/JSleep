package com.JeremyGandaPandapotanJSleepKM;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.JeremyGandaPandapotanJSleepKM.controller.BasicGetController;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

public class PaymentController implements BasicGetController<Payment> {


    @JsonAutowired(filepath = "src/json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;


    @PostMapping("/payment")
    public boolean accept (int id) {
        return false;
    }

    @PostMapping("/payment")
    public boolean cancel (int id) {
        return false;
    }

    @PostMapping("/payment")
    public Payment create (int id) {
        return null;
    }

    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment")
    public boolean submit (int id, String receipt) {
        return false;
    }

    @PostMapping("/payment")
    private static boolean timekeeper (Payment payment) {
        return false;
    }

    @PostMapping("/create")
    public PaymentController create() {
        return null;
    }

    @PostMapping("/{id}/accept")
    public PaymentController accept() {
        return null;
    }

    @PostMapping("/{id}/cancel")
    public PaymentController cancel() {
        return null;
    }

    @PostMapping("/{id}/submit")
    public PaymentController submit() {
        return null;
    }
}
