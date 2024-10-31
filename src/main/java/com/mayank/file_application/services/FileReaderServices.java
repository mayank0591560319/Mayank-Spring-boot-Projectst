package com.mayank.file_application.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
public class FileReaderServices {

    public String readFileService(MultipartFile file) {
        try {

            String content = new BufferedReader(
                    new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            System.out.println("File Content:");
            System.out.println(content);
            return "File content:\n" + content;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to read file content.";
        }
    }

}
