package com.youyi.dormitory.service;

import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Building;

public interface BuildingService {
    DormitoryResult queryBuildingById(int bid);
    DormitoryResult queryBuildings();
    DormitoryResult addBuilding(Building building);
    DormitoryResult modifyBuilding(Building building);
    DormitoryResult deleteBuilding(int bid);
}
