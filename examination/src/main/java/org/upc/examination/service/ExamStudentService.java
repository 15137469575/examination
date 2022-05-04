package org.upc.examination.service;

import java.util.List;

public interface ExamStudentService {
    /**
     * 根据前台传来的examId和一个Integer类型的List的studentIds
     * 返回值是学生数量
     * */
    int insert(int examId, List<Integer> studentIds);
}
