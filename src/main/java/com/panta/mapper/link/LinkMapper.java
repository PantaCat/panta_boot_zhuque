package com.panta.mapper.link;

import com.panta.model.link.LinkModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {
    List<LinkModel> queryDataList();
    int saveData(LinkModel lm);
    int deleteData(LinkModel lm);
}
