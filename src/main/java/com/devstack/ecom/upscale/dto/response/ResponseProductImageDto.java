package com.devstack.ecom.upscale.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class ResponseProductImageDto {

    private String propertyId;
    private String directory;
    private String resourceUrl;
    private String hash;
    private String fileName;
}
