package com.projectDIO.ecommerce.checkout.service;

import com.projectDIO.ecommerce.checkout.entity.CheckoutEntity;
import com.projectDIO.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
