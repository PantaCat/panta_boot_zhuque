package com.panta.service.function;


import com.panta.model.function.FileUploadModel;

import java.util.List;

public interface IFileUploadService {
    
    List<FileUploadModel> queryDataList();

    void saveData(FileUploadModel model);
    void deleteData(String fileUid);

}
