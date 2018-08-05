package com.youyi.dormitory.dao;

import com.youyi.dormitory.entity.Building;
import java.util.List;
public interface BuildingDao {
    List<Building> queryBuildings();
    Building queryBuildingById(int bid);
    int insertBuilding(Building building);
    int updateBuilding(Building building);
    int deleteBuilding(int bid);
}
