package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.PaperInformation;

@Mapper
public interface PaperInformationMapper {

    int insert(PaperInformation paperInformation);
}
