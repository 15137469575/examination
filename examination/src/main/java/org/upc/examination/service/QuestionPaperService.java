package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.QuestionPaper;

public interface QuestionPaperService {

    int doInsert(QuestionPaper questionPaper);


    PageInfo<QuestionPaper> selectByPaperId(int pageNum, int pageSize, int paperId);
}
