package org.upc.examination;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.upc.examination.mapper.UserMapper;
import org.upc.examination.service.UserFaceInfoService;
import org.upc.examination.utils.FileUtils;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ExaminationApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserFaceInfoService userFaceInfoService;

    String baseDir = "D:\\img\\temp";

    @Test
    void three(){
        userFaceInfoService.compressRegister("资料");
    }

    @Test
    void merge(){
        String fileName = "资料.zip";
        FileUtils.mergeFile(fileName,baseDir,6);
    }

    @Test
    void unCompressOne(){
        String fileName = "资料.zip";
        boolean result = FileUtils.unZip(fileName,baseDir);
        System.out.println(result);
    }

    @Test
    void one(){
        String fileName = "imgs";
        List failList = userFaceInfoService.compressRegister(fileName);
        System.out.println(failList.toString());
    }
}
