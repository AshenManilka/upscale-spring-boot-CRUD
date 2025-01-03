package com.devstack.ecom.upscale.dto.request;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductImageDto {

    private MultipartFile image;
}
