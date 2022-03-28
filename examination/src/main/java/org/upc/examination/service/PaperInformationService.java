package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.PaperInformation;

import java.util.List;

public interface PaperInformationService {

    int doInsert(PaperInformation paperInformation);

    PaperInformation selectById(int index);

    PageInfo<PaperInformation> selectBySubjects(int pageNum,int pageSize,String subject);
}
