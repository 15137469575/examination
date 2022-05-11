package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author asus
 */
@Mapper
public interface ScoreDisplayMapper {

    List<Integer> queryAllStudent(int examId);

    List<Double> queryAllScore(List list,int examId);

}
