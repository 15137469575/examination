package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.QuestionBank;

public interface QuestionBankService {

    int doInsert(QuestionBank questionBank);

    PageInfo<QuestionBank> doQuery(String object, int pageNum, int pageSiza);

    QuestionBank doQueryById(int index);

}
