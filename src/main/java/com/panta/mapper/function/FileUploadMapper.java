package com.panta.mapper.function;

import com.panta.model.function.FileUploadModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileUploadMapper {
    List<FileUploadModel> queryDataList();
    void saveData(FileUploadModel model);
    void deleteData(String fileUid);

}
