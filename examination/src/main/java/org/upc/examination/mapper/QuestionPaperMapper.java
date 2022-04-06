package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.PaperInformation;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.entity.QuestionPaper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionPaperMapper {


    int insert(QuestionPaper questionPaper);

    /**
     * 根据试卷序号来选择题目
     * */
    List<QuestionPaper> selectByPaperId(int index);

    List<Integer>  isSame(int paperId);

    //List<Integer> randomSelectFromBank(String subject);


}
