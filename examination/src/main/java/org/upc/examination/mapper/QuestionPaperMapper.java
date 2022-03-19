package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.QuestionPaper;

@Mapper
public interface QuestionPaperMapper {


    int insert(QuestionPaper questionPaper);
}
