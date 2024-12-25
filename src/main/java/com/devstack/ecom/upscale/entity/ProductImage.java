package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product_image")
public class ProductImage {


    @Id
    @Column(name = "property_id")
    private String propertyId;

    @Lob
    @Column(name =  "file_name" ,  nullable = false)
    private String fileName;

    @Lob
    @Column(name = "resource_url", nullable = false)
    private String resourceUrl;

    @Lob
    @Column(name = "hash",nullable = false)
    private String hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" ,
            referencedColumnName = "product_id")

    private Product product;
}
