package com.projectDIO.ecommerce.checkout.listener;

import com.projectDIO.ecommerce.checkout.entity.CheckoutEntity;
import com.projectDIO.ecommerce.checkout.repository.CheckoutRepository;
import com.projectDIO.ecommerce.checkout.streaming.PaymentPaidSink;
import com.projectDIO.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APROVED);
        checkoutRepository.save(checkoutEntity);

    }
}
