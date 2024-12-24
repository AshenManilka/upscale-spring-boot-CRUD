package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.util.CommonFileSavedBinaryDataDto;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService {
    @Override
    public CommonFileSavedBinaryDataDto create(MultipartFile file, String directory, String bucket) {
        return null;
    }

    @Override
    public void delete(String fileName, String directory, String bucket) {

    }
}
