package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.QuestionBank;

public interface QuestionBankService {

    int doInsert(QuestionBank questionBank);

    PageInfo<QuestionBank> doQuery(String object, int pageNum, int pageSize);

    QuestionBank doQueryById(int index);

    int update(QuestionBank questionBank);

    PageInfo<QuestionBank> doQueryByType(String type, int pageNum, int pageSize);

    int doDelete(int index);

    int deDeleteArray(int[] list);

    PageInfo<QuestionBank> doQueryByObjectAndType(String object,String type,int pageNum,int pageSize);

    PageInfo<QuestionBank> doQueryByAnyParams(QuestionBank questionBank,int pageNum,int pageSize);

}
