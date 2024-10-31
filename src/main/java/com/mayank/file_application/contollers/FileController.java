package com.mayank.file_application.contollers;

import com.mayank.file_application.config.PropertyConfig;
import com.mayank.file_application.constants.AppConstant;
import com.mayank.file_application.dao.FileDetailsFields;
import com.mayank.file_application.services.FileReaderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class FileController {
    @Autowired
    PropertyConfig propertyConfig;

    @Autowired
    FileReaderServices fileReaderServices;

    @Autowired
    FileDetailsFields fileDetailsFields;

    @GetMapping("/uploadFile")
    public ResponseEntity getFileContent(@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        Map<String, Object> fileDetails = new LinkedHashMap<>();
        try {

            Long fileSize = multipartFile.getSize();
            byte[] noOfBytes = multipartFile.getBytes();
            String fileType = multipartFile.getContentType();
            fileDetails.put("fileSize", fileSize);
            fileDetails.put("noOfBytes", noOfBytes);
            fileDetails.put("fileType", fileType);
            if (fileSize < propertyConfig.maxSize) {
                String fileContent = fileReaderServices.readFileService(multipartFile);
                fileDetails.put("fileContent", fileContent);
            } else {
                return new ResponseEntity(AppConstant.MAX_FILE_EXCEEDED_LIMIT, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(fileDetails,HttpStatus.OK);
    }
}
