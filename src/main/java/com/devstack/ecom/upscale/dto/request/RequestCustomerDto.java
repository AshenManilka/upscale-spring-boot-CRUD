package com.devstack.ecom.upscale.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCustomerDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean active;

}
