package com.example.MobileStoreSystem.Service;

import com.example.MobileStoreSystem.entity.Payment;

public interface PaymentService {

	Payment getPaymentById(int paymentId);
	Payment addPayment( Payment payment);

	Payment updateDb(int paymentId,Payment payment);

	void deleteDb(int paymentId);


}
