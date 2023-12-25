package com.example.MobileStoreSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.MobileStoreSystem.Service.PaymentService;
import com.example.MobileStoreSystem.entity.Payment;

@RestController
public class PaymentController {
	@Autowired
	
	PaymentService paymentService;
	
	@GetMapping("/payment/{Id}")
	public Payment getPaymentById(@PathVariable int paymentId) {
		return paymentService.getPaymentById(paymentId); 
	}
	
	@PostMapping("/postpay")
	public Payment addPayment(@RequestBody Payment payment) {
		
		return paymentService.addPayment(payment);
	}
	
	@PutMapping("/updatepayment")
	public Payment update(@RequestHeader int paymentId ,@RequestBody Payment payment) {
		
		return paymentService.updateDb(paymentId ,payment); 
	}
	@DeleteMapping("/deletepayment")
	public String delete(@RequestHeader int paymentId) {
		paymentService.deleteDb(paymentId);
		return "data deleted";
	}
	

}