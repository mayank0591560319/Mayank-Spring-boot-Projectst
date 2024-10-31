package com.mayank.file_application.dao;

import lombok.Data;

@Data
public class FileDetailsFields {
    String filename;
    Long fileSize;
    String fileContent;
    String filetype;
    byte[]arr;
}
