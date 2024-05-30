package com.panta.controller;

import com.panta.model.link.LinkModel;
import com.panta.service.link.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> saveData(@RequestBody LinkModel lm){
        linkService.saveData(lm);
        return ResponseEntity.ok("ok");
    }
}
