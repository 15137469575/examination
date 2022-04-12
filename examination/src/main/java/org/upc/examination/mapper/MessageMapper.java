package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Message;

import java.util.List;

@Mapper
public interface MessageMapper {

    int insert(Message msg);

    List<String> selectByStudentId(int studentId);
}
