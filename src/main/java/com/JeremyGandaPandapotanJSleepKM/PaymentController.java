package com.JeremyGandaPandapotanJSleepKM;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.JeremyGandaPandapotanJSleepKM.controller.BasicGetController;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonAutowired;
import com.JeremyGandaPandapotanJSleepKM.dbjson.JsonTable;

public class PaymentController implements BasicGetController<Payment> {

    public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERED_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;

    @JsonAutowired(filepath = "E:\\Kuligan\\Sem 3\\OOP\\Modul 1\\JSleep\\src\\json\\payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;
    //public static ObjectPoolThread<Payment> poolThread;

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
