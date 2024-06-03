package com.panta.service.link.impl;

import com.panta.mapper.link.LinkMapper;
import com.panta.model.link.LinkModel;
import com.panta.service.link.ILinkService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {
    
   @Resource 
   private LinkMapper linkMapper;
    
    @Override
    public List<LinkModel> queryDataList() {
        return linkMapper.queryDataList();
    }

    @Override
    public void saveData(LinkModel lm) {
        linkMapper.saveData(lm);
    }

    @Override
    public void updateData(LinkModel lm) {
        linkMapper.updateData(lm);
    }
    
    @Override
    public void deleteData(LinkModel lm) {
        linkMapper.deleteData(lm);
    }
}
