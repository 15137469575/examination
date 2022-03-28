package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.QuestionBank;

import java.util.List;

@Mapper
public interface QuestionBankMapper {

    int insert(QuestionBank questionBank);

    List<QuestionBank> queryPage(String object);

    QuestionBank queryById(int index);

    int update(QuestionBank questionBank);

    List<QuestionBank> queryByType(String type);

}
