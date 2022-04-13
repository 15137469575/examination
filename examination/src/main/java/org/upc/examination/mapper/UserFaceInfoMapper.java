package org.upc.examination.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.upc.examination.entity.UserFaceInfo;

@Mapper
public interface UserFaceInfoMapper {

    UserFaceInfo query(int id);

    int UserFaceRegister(UserFaceInfo userFaceInfo);

}
