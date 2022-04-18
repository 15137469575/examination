package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.PaperInformation;

import java.util.List;

public interface PaperInformationService {
    /**
     * 插入试卷信息
     *如果paperId是null，那么执行paperInformationMapper.insert2(paperInformation);
     * 反之，paperInformationMapper.insert(paperInformation);
     * 返回值是paperId
     * */
    int doInsert(PaperInformation paperInformation);
    /**
     * 根据paperId来找出PaperInformation
     * */
    PaperInformation selectById(int index);
    /**
     * 通过科目来筛选试卷
     * 未使用
     * */
    PageInfo<PaperInformation> selectBySubjects(int pageNum,int pageSize,String subject);
}
