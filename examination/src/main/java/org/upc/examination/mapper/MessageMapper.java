package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.Message;


import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 创建信息
     * */
    int insert(Message msg);

    /**
     * 通过studentId来找出这个学生所能够查看的通知信息，会是一个List
     * */
    List<String> selectByStudentId(int studentId);


}
