package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.PaperInformation;

import java.util.List;

@Mapper
public interface PaperInformationMapper {

    int insert(PaperInformation paperInformation);

     List<PaperInformation> selectById(int index);

     PaperInformation selectBySubjects(String subject);



}
