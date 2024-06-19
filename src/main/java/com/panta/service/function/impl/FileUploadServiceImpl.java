package com.panta.service.function.impl;

import com.panta.mapper.function.FileUploadMapper;
import com.panta.model.function.FileUploadModel;
import com.panta.service.function.IFileUploadService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Resource
    private FileUploadMapper fileUploadMapper;

    @Override
    public List<FileUploadModel> queryDataList() {
        return fileUploadMapper.queryDataList();
    }

    @Override
    public void saveData(FileUploadModel model) {
         fileUploadMapper.saveData(model);
    }

    @Override
    public void deleteData(String fileUid) {
        fileUploadMapper.deleteData(fileUid);
    }
}
