package com.example.eurekafeignuploadclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "eureka-feign-upload-server",configuration = FeignMultipartSupportConfig.class)
public interface UploadService {

  @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String ocrIdCard(@RequestPart(value = "file") MultipartFile file);

}