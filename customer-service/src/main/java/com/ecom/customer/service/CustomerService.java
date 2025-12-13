package com.ecom.customer.service;

import com.ecom.customer.dto.CustomerRequest;
import com.ecom.customer.dto.CustomerResponse;
import com.ecom.customer.entity.Customer;
import com.ecom.customer.exception.CustomerNotFoundException;
import com.ecom.customer.mapper.CustomerMapper;
import com.ecom.customer.repository.CustomerRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        return customerMapper.fromCustomer(customerRepository.save(customerMapper.toCustomer(customerRequest)));
    }

    public void updateCustomer(Long customerId,CustomerRequest request) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
                ));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstName(request.firstname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return  customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
