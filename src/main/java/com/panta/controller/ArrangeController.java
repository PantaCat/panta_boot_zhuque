package com.panta.controller;

import com.panta.model.SftpModel;
import com.panta.model.arrange.ArrangeModle;
import com.panta.service.arrange.IArrangeService;
import com.panta.utils.FtpUtil;
import com.panta.utils.LinuxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/arrange")
public class ArrangeController {

    @Autowired
    private IArrangeService arrangeService;

    @PostMapping("/queryDataList")
    public List<ArrangeModle> queryDataList(){
        List<ArrangeModle> lmList = arrangeService.queryDataList();
        return lmList;
    }

    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(@RequestBody ArrangeModle am) {
        arrangeService.saveData(am);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/updateData")
    public ResponseEntity<String> updateData(@RequestBody ArrangeModle am) {
        arrangeService.updateData(am);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/deleteData")
    public ResponseEntity<String> deleteData(@RequestBody ArrangeModle am) {
        arrangeService.deleteData(am);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/arrangeData")
    public ResponseEntity<String> uploadFile(@RequestParam("pkgFile") MultipartFile pkgFile,@RequestParam("linuxAddress") String linuxAddress,@RequestParam("executeCommand") String executeCommand) throws IOException {
        String fileName = pkgFile.getOriginalFilename();
        InputStream input = pkgFile.getInputStream();
        FtpUtil.uploadFile(input, fileName, linuxAddress);
        CompletableFuture.supplyAsync(() -> {
            try {
                LinuxUtils.sshExec(executeCommand);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        return ResponseEntity.ok("ok");
    }
    
}
