package com.panta.mapper.arrange;

import com.panta.model.arrange.ArrangeModle;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ArrangeMapper {
    List<ArrangeModle> queryDataList();
    int saveData(ArrangeModle lm);

    int updateData(ArrangeModle lm);
    int deleteData(ArrangeModle lm);
}
