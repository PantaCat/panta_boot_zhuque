package com.panta.service.arrange.impl;

import com.panta.mapper.arrange.ArrangeMapper;
import com.panta.model.arrange.ArrangeModle;
import com.panta.service.arrange.IArrangeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangeServiceImpl implements IArrangeService {
    
   @Resource 
   private ArrangeMapper arrangeMapper;
    
    @Override
    public List<ArrangeModle> queryDataList() {
        return arrangeMapper.queryDataList();
    }

    @Override
    public void saveData(ArrangeModle am) {
        arrangeMapper.saveData(am);
    }

    @Override
    public void updateData(ArrangeModle am) {
        arrangeMapper.updateData(am);
    }

    @Override
    public void deleteData(ArrangeModle am) {
        arrangeMapper.deleteData(am);
    }

    @Override
    public void arrangeData(ArrangeModle am) {
        arrangeMapper.deleteData(am);
    }
}
