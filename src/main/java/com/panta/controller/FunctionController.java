package com.panta.controller;

import com.panta.model.SftpModel;
import com.panta.model.function.FileUploadModel;
import com.panta.service.function.IFileUploadService;
import com.panta.utils.FtpUtil;
import com.panta.utils.LinuxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private IFileUploadService fileUploadService;

    @PostMapping("/fileUpload/queryDataList")
    public List<FileUploadModel> queryDataList(){
        List<FileUploadModel> fileList = fileUploadService.queryDataList();
        return fileList;
    }


    @PostMapping("/fileUpload/commitFileUpload")
    public ResponseEntity commitFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream input = file.getInputStream();
        FtpUtil.uploadFile(input, fileName, SftpModel.fileBasePath);
        FileUploadModel model = new FileUploadModel();
        model.setFileUid(UUID.randomUUID().toString());
        model.setFileName(fileName);
        model.setFileUrl(SftpModel.fileBaseUrl+fileName);
        fileUploadService.saveData(model);

        return ResponseEntity.ok(model);
    }

    @PostMapping("/fileUpload/deleteFileUpload")
    public ResponseEntity deleteFileUpload(@RequestParam("fileUid") String fileUid) throws IOException {
        fileUploadService.deleteData(fileUid);
        return ResponseEntity.ok("ok");
    }


    
}
