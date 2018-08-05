package com.youyi.dormitory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Building;
import com.youyi.dormitory.entity.Student;
import com.youyi.dormitory.service.BuildingService;
import com.youyi.dormitory.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @GetMapping(value = "/querybuildingbyid/{bid}")
    public DormitoryResult queryBuildingById(@PathVariable("bid") int bid){
        DormitoryResult result = buildingService.queryBuildingById(bid);
        return result;
    }
    @GetMapping(value = "/querybuildings")
    public DormitoryResult queryBuildings(){
        DormitoryResult result = buildingService.queryBuildings();
        return result;
    }
    @PostMapping(value = "/addbuilding")
    public DormitoryResult addBuilding(HttpServletRequest request) {
        String studentStr = HttpServletRequestUtil.getString(request, "buildingStr");
        Building building = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            building = mapper.readValue(studentStr, Building.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = buildingService.addBuilding(building);
        return result;
    }
    @PostMapping(value = "/modifybuilding")
    public DormitoryResult modifyBuilding(HttpServletRequest request){
        String studentStr = HttpServletRequestUtil.getString(request, "buildingStr");
        Building building = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            building = mapper.readValue(studentStr, Building.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = buildingService.modifyBuilding(building);
        return result;
    }
    @GetMapping(value = "/deletebuilding/{bid}")
    public DormitoryResult deleteBuilding(@PathVariable("bid") int bid){
        DormitoryResult result = buildingService.deleteBuilding(bid);
        return result;
    }


}
