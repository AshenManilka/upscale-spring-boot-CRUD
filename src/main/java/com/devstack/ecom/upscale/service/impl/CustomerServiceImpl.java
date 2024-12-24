package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.response.ResponceCustomerDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;
import com.devstack.ecom.upscale.entity.Customer;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.CustomerRepo;
import com.devstack.ecom.upscale.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public void create(RequestCustomerDto dto) {

        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .isActive(dto.isActive())
                .build();
        customerRepo.save(customer);
    }

    @Override
    public ResponceCustomerDto findById(String id) {
       Optional <Customer> selectedCustomer = customerRepo.findById(id);
       if(selectedCustomer.isEmpty()){
           throw  new EntryNotFoundException("Customer not found");
       }
       return toResponceCustomerDto(selectedCustomer.get());
    }

    @Override
    public void update(String id, RequestCustomerDto dto) {
        Optional <Customer> selectedCustomer = customerRepo.findById(id);
        if(selectedCustomer.isEmpty()){
            throw  new EntryNotFoundException("Customer not found");
        }

        Customer customer =  selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setActive(dto.isActive());
        customerRepo.save(customer);
    }

    @Override
    public CustomerPaginateDto findAll(String searchText, int page, int size) {

        return CustomerPaginateDto.builder()
                .dataList( customerRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::toResponceCustomerDto).toList())
                .count(customerRepo.countAllWithSearchText(searchText))
                .build();
    }

    @Override
    public void delete(String id) {
        customerRepo.deleteById(id);
    }


    private ResponceCustomerDto toResponceCustomerDto(Customer customer) {
        return  ResponceCustomerDto.builder()
                .propertyId(customer.getPropertyId())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .name(customer.getName())
                .active(customer.isActive())
                .email(customer.getEmail())
                .build();
    }
}