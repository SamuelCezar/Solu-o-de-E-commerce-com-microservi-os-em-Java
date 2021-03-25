package com.projectDIO.ecommerce.checkout.resource.checkout;

//import com.projectDIO.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.projectDIO.ecommerce.checkout.entity.CheckoutEntity;
import com.projectDIO.ecommerce.checkout.service.CheckoutService;
//import com.projectDIO.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = checkoutService.create(checkoutRequest).orElseThrow();
        final CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}



//        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
//                .setCheckoutCode("123")
//                .build();
////        checkoutCreatedSource.output().send(MessageBuilder.withPayload("asdasdasd").build());
//        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());