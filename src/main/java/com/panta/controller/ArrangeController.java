package com.panta.controller;

import com.panta.model.arrange.ArrangeModle;
import com.panta.service.arrange.IArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    
}
