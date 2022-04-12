package org.upc.examination.service;

import java.util.List;

public interface ExamStudentService {

    int insert(int examId, List<Integer> studentIds);
}
