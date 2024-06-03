package com.panta.controller;

import com.panta.model.link.LinkModel;
import com.panta.model.SftpModel;
import com.panta.service.link.ILinkService;
import com.panta.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/queryDataList")
    public List<LinkModel> queryDataList(){
        List<LinkModel> lmList = linkService.queryDataList();
        return lmList;
    }

    @PostMapping("/saveData")
    public ResponseEntity<String> saveData(@RequestBody LinkModel lm) {
        linkService.saveData(lm);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/updateData")
    public ResponseEntity<String> updateData(@RequestBody LinkModel lm) {
        linkService.updateData(lm);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        String fileName = imgFile.getOriginalFilename();
        InputStream input = imgFile.getInputStream();
        FtpUtil.uploadFile(input, fileName,SftpModel.imgBasePath);
        return ResponseEntity.ok(SftpModel.imgBaseUrl+fileName);
    }

    @PostMapping("/deleteData")
    public ResponseEntity<String> deleteData(@RequestBody LinkModel lm) {
        linkService.deleteData(lm);
        return ResponseEntity.ok("ok");
    }
    
}
