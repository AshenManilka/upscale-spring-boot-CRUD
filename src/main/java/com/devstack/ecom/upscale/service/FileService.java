package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
     public CommonFileSavedBinaryDataDto createResource  (MultipartFile file ,String directory , String bucket);
    public void deleteResource (String fileName ,String directory , String bucket);
    public byte[] downloadFile(String bucket, String fileName);
}
