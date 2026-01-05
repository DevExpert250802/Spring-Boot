
package com.conceptandcoding.learnspringboot.Service;

import com.conceptandcoding.learnspringboot.DTO.PaymentRequest;
import com.conceptandcoding.learnspringboot.DTO.PaymentResponse;
import com.conceptandcoding.learnspringboot.Entity.PaymentEntity;
import com.conceptandcoding.learnspringboot.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
        PaymentEntity paymentModel = paymentRepository.getPaymentById(internalRequestObj);

        // map it to response obj
        PaymentResponse paymentResponse = mapModelToResponseDTO(paymentModel);
        return paymentResponse;
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentEntity.getId());
        response.setAmount(paymentEntity.getPaymentAmount());
        response.setCurrency(paymentEntity.getPaymentCurrency());
        return response;
    }
}
