package com.devstack.ecom.upscale.dto.request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long qty;
    private Double unitPrice;
    private String description;

}
