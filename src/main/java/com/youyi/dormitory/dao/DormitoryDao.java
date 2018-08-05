package com.youyi.dormitory.dao;

import com.youyi.dormitory.entity.Dormitory;
import java.util.List;

public interface DormitoryDao {
    List<Dormitory> queryDormitories();
    Dormitory queryDormitoryById(int did);
    int insertDormitory(Dormitory dormitory);
    int updateDormitory(Dormitory Dormitory);
    int deleteDormitory(int did);
    int deleteDormitoryByBid(int bid);
}
