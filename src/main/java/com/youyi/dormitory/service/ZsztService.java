package com.youyi.dormitory.service;

import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Zszt;

import java.util.Date;

public interface ZsztService {
    DormitoryResult queryZszts();
    DormitoryResult queryZsztByZid(int cid);
    DormitoryResult queryZsztByDate(Date date);
    DormitoryResult queryZsztByDid(int did);
    DormitoryResult addZszt(Zszt zszt);
    DormitoryResult modifyZszt(Zszt zszt);
    DormitoryResult deleteZsztByZid(int zid);
    DormitoryResult deleteZsztByDid(int did);
    DormitoryResult deleteZsztByDate(Date date);
}
