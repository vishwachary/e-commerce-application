package com.ecom.customer.controller;


import com.ecom.customer.dto.CustomerRequest;
import com.ecom.customer.dto.CustomerResponse;
import com.ecom.customer.entity.Customer;
import com.ecom.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return "welcome " + "  " +name + "to customer service";
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequest));
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<Void> updateCustomer(
            @PathVariable Long customerId,
            @Valid @RequestBody CustomerRequest customerRequest
    ) {
        customerService.updateCustomer(customerId, customerRequest);
        return ResponseEntity.noContent().build(); // 204
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> delete(
            @PathVariable("customerId") Long customerId
    ) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }


}
