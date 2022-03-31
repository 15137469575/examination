package org.upc.examination.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.upc.examination.entity.PaperInformation;
import org.upc.examination.mapper.PaperInformationMapper;
import org.upc.examination.service.PaperInformationService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperInformationServiceImpl implements PaperInformationService {

    @Resource
    private PaperInformationMapper paperInformationMapper;
    @Override
    public int doInsert(PaperInformation paperInformation) {

        if(paperInformation.getPaperId()==null){
            paperInformationMapper.insert2(paperInformation);
            return paperInformation.getPaperId();
        }
        else {
            paperInformationMapper.insert(paperInformation);
            return paperInformation.getPaperId();
        }
    }

    @Override
    public PaperInformation selectById(int index) {
        PaperInformation paperInformation = new PaperInformation();
        paperInformation = paperInformationMapper.selectById(index);
        return paperInformation;
    }

    @Override
    public PageInfo<PaperInformation> selectBySubjects(int pageNum, int pageSize, String subject) {
        PageInfo<PaperInformation> pages = null;

        PageHelper.startPage(pageNum, pageSize);

        List<PaperInformation> paperInformation =
                paperInformationMapper.selectBySubjects(subject);

        pages = new PageInfo<>(paperInformation,10);

        return pages;

    }


}
