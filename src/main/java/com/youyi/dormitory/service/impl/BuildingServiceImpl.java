package com.youyi.dormitory.service.impl;

import com.youyi.dormitory.dao.BuildingDao;
import com.youyi.dormitory.dao.DormitoryDao;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Building;
import com.youyi.dormitory.entity.Dormitory;
import com.youyi.dormitory.exception.DormitoryException;
import com.youyi.dormitory.service.BuildingService;
import com.youyi.dormitory.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService{
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private DormitoryService dormitoryService;
    @Override
    public DormitoryResult queryBuildingById(int bid) {
        if(bid<1){
            return DormitoryResult.notFount("查询条件错误");
        }
        Building building = buildingDao.queryBuildingById(bid);
        //判断是否查询到结果
        if (building != null) {
            return DormitoryResult.ok(building);
        }
        return DormitoryResult.notFount("查询失败");
    }

    @Override
    public DormitoryResult queryBuildings() {
        List<Building>  buildingList = buildingDao.queryBuildings();
        if(buildingList != null && buildingList.size()>0){
            return DormitoryResult.ok(buildingList);
        }else {
            return DormitoryResult.notFount("查询失败");
        }
    }

    @Override
    public DormitoryResult addBuilding(Building building){
        if(building == null){
            return DormitoryResult.notFount("添加内容为空");
        }
        try{
            int effectedNum = buildingDao.insertBuilding(building);
            if(effectedNum <0){
                return DormitoryResult.notFount("添加building失败");
            }
            return DormitoryResult.ok();
        }catch (Exception e){
            throw new DormitoryException("添加building失败:"+e.getMessage());
        }

    }

    @Override
    public DormitoryResult modifyBuilding(Building building){
        if(building != null){
            try{
                int effectedNum = buildingDao.updateBuilding(building);
                if(effectedNum<0){
                    return DormitoryResult.notFount("修改building失败");
                }
                return DormitoryResult.ok();
            }catch (Exception e){
                throw new DormitoryException("添加building失败:"+e.getMessage());
            }

        }
        return DormitoryResult.notFount("修改内容为空");
    }

    @Override
    public DormitoryResult deleteBuilding(int bid){
        if(bid <1){
            return DormitoryResult.notFount("删除内容错误");
        }
        try{
            int effectedNum = buildingDao.deleteBuilding(bid);
            if(effectedNum<0) {
                return DormitoryResult.notFount("删除building失败");
            }else{
                return DormitoryResult.ok();
            }
        }catch (Exception e){
            throw new DormitoryException("删除building异常："+e.getMessage());
        }

    }
}
