package com.youyi.dormitory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Dormitory;
import com.youyi.dormitory.entity.Student;
import com.youyi.dormitory.service.DormitoryService;
import com.youyi.dormitory.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping(value = "/querydormitories")
    public DormitoryResult queryDormitories(){
        DormitoryResult result = dormitoryService.queryDormitories();
        return result;
    }
    @GetMapping(value = "/querydormitorybyid/{did}")
    public DormitoryResult queryDormitoryById(@PathVariable("did") int did){
        DormitoryResult result = dormitoryService.queryDormitoryById(did);
        return result;
    }
    @PostMapping(value = "/adddormitory")
    public DormitoryResult addDormitory(HttpServletRequest request){
        String dormitoryStr = HttpServletRequestUtil.getString(request, "dormitoryStr");
        Dormitory dormitory = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            dormitory = mapper.readValue(dormitoryStr, Dormitory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = dormitoryService.addDormitory(dormitory);
        return result;
    }
    @PostMapping(value = "/modifydormitory")
    public DormitoryResult modifyDomitory(HttpServletRequest request){
        String dormitoryStr = HttpServletRequestUtil.getString(request, "dormitoryStr");
        Dormitory dormitory = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            dormitory = mapper.readValue(dormitoryStr, Dormitory.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result =  dormitoryService.modifyDormitory(dormitory);
        return result;
    }
    @GetMapping(value = "/deletedormitory/{did}")
    public DormitoryResult deleteDormitory(@PathVariable("did") int did){
        DormitoryResult result = dormitoryService.deleteDormitory(did);
        return result;
    }
}
