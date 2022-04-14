package org.upc.examination.service;

import com.github.pagehelper.PageInfo;
import org.upc.examination.entity.QuestionPaper;

import java.util.List;

public interface QuestionPaperService {

    int doInsert(QuestionPaper questionPaper);


    List<QuestionPaper> selectByPaperId( int paperId);

    int randomInsert(int paperId,String subject);
}
