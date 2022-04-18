package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.PaperInformation;

import java.util.List;

@Mapper
public interface PaperInformationMapper {
/**
 * 执行插入操作，是可以插入paperId字段
 *
 * */
    int insert(PaperInformation paperInformation);
/**
 * 执行插入操作，不会插入paperId，paperId执行自增
 * */
    int insert2(PaperInformation paperInformation);
/**
 * 根据paperId来找出PaperInformation
 * */
     PaperInformation selectById(int index);
/**
 * 根据科目来筛选出此科目的PaperInformation
 * */
     List<PaperInformation> selectBySubjects(String subject);




}
