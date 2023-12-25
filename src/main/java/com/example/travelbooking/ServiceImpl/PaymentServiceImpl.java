package com.example.MobileStoreSystem.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MobileStoreSystem.Exception.ResourceNotFoundException;
import com.example.MobileStoreSystem.Repository.PaymentRepo;
import com.example.MobileStoreSystem.Service.PaymentService;
import com.example.MobileStoreSystem.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {


	@Autowired
	PaymentRepo paymentRepo;
	
	public Payment getPaymentById(int  paymentId) {
		Optional<Payment> rm=Optional.ofNullable(paymentRepo.findById( paymentId));
		Payment payment;
		if(rm.isPresent())
		{
			payment=rm.get();
		}else {
				throw new ResourceNotFoundException();
			}
		return payment;
	  
	}

	public Payment addPayment( Payment payment) {
		return paymentRepo.save( payment);
	}

	public Payment updateDb(int paymentId,Payment payment) {
		
		
		Payment s1 = paymentRepo.findById( paymentId);
		
		if(s1!=null) {
			s1.setPrice(payment.getPrice());   
			s1.setPaymentType(payment.getPaymentType());
			s1.setPassengerId(payment.getPaymentId());
		return paymentRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	public void deleteDb(int paymentId) {
	
		
		Payment s2 = paymentRepo.findById( paymentId);
		
		if(s2!=null) {
			paymentRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}}
