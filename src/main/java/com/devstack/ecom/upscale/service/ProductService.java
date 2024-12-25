package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.response.ResponceCustomerDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;

public interface ProductService {
     public void create (RequestCustomerDto dto);

     public ResponceCustomerDto findById(String id);

     public void update(String id,RequestCustomerDto dto );

     public CustomerPaginateDto findAll(String searchText , int page , int size );

     public void delete(String id);

}
