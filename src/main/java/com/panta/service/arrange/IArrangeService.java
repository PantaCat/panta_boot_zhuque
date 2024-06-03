package com.panta.service.arrange;


import com.panta.model.arrange.ArrangeModle;
import java.util.List;

public interface IArrangeService {
    
    List<ArrangeModle> queryDataList();
    void saveData(ArrangeModle am);

    void updateData(ArrangeModle am);
    void deleteData(ArrangeModle am);
    void arrangeData(ArrangeModle am);

}
