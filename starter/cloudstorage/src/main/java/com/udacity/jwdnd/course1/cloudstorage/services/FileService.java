package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileService {
    private final UserMapper userMapper;
    private final FileMapper fileMapper;

    public FileService(UserMapper userMapper, FileMapper fileMapper) {
        this.fileMapper = fileMapper;
        this.userMapper = userMapper;
    }

    public File getFile(String fileName) {
        return fileMapper.getFile(fileName);
    }

    public String[] getFileById(Integer userId) {
        return fileMapper.getFileById(userId);
    }

    public void deleteFile(String fileName)  {
        fileMapper.deleteFile(fileName);
    }

    public void createFile(MultipartFile fileUpload, int userid, File file)throws IOException {
        try {
            file.setContentType(fileUpload.getContentType());
            file.setFileData(fileUpload.getBytes());
            file.setFileName(fileUpload.getOriginalFilename());
            file.setFileSize(Long.toString(fileUpload.getSize()));
            file.setUserId(userid);
        } catch (IOException e) {
            throw e;
        }
        fileMapper.insert(file);
    }
}
