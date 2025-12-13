package com.ecom.customer.dto;

import com.ecom.customer.entity.Address;

public record CustomerResponse(
        Long id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
