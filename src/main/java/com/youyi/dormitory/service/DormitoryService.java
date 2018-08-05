package com.youyi.dormitory.service;

import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Dormitory;

public interface DormitoryService {
    DormitoryResult queryDormitoryById(int did);
    DormitoryResult queryDormitories();
    DormitoryResult addDormitory(Dormitory dormitory);
    DormitoryResult modifyDormitory(Dormitory dormitory);
    DormitoryResult deleteDormitory(int did);
}
