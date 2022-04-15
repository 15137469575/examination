package org.upc.examination.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.upc.examination.entity.QuestionBank;
import org.upc.examination.mapper.QuestionBankMapper;
import org.upc.examination.service.QuestionBankService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

    @Resource
    private QuestionBankMapper questionBankMapper;

    @Override
    public int doInsert(QuestionBank questionBank) {
        return questionBankMapper.insert(questionBank);
    }

    @Override
    public PageInfo<QuestionBank> doQuery(String object,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionBank> lists =  questionBankMapper.queryPage(object);
        PageInfo<QuestionBank> page = new PageInfo<>(lists);
        return page;
    }

    @Override
    public QuestionBank doQueryById(int index) {
        return questionBankMapper.queryById(index);
    }

    @Override
    public int update(QuestionBank questionBank) {
        return questionBankMapper.update(questionBank);
    }

    @Override
    public PageInfo<QuestionBank> doQueryByType(String type,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionBank> lists =  questionBankMapper.queryByType(type);
        PageInfo<QuestionBank> page = new PageInfo<>(lists);
        return page;
    }

    @Override
    public int doDelete(int index) {
        return questionBankMapper.delete(index);
    }

    @Override
    public int deDeleteArray(int[] list) {
        return questionBankMapper.deleteArray(list);
    }

    @Override
    public PageInfo<QuestionBank> doQueryByObjectAndType(String object,String type,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionBank> lists =  questionBankMapper.queryByObjectAndType(object,type);
        PageInfo<QuestionBank> page = new PageInfo<>(lists);
        return page;
    }

    @Override
    public PageInfo<QuestionBank> doQueryByAnyParams(QuestionBank questionBank,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionBank> lists = questionBankMapper.queryByAnyParams(questionBank);
        PageInfo<QuestionBank> page = new PageInfo<>(lists);
        return page;
    }
}
