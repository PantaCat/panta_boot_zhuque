package com.panta.service.link;


import com.panta.model.link.LinkModel;

import java.util.List;

public interface ILinkService {
    
    List<LinkModel> queryDataList();
    void saveData(LinkModel lm);
}
