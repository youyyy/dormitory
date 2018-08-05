package com.youyi.dormitory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Student;
import com.youyi.dormitory.entity.Zszt;
import com.youyi.dormitory.service.ZsztService;
import com.youyi.dormitory.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ZsztController {
    @Autowired
    private ZsztService zsztService;
    @GetMapping(value = "/queryzszts")
    public DormitoryResult queryZszts(){
        DormitoryResult result = zsztService.queryZszts();
        return result;
    }
    @GetMapping(value = "/queryzsztbyzid/{zid}")
    public DormitoryResult queryZsztByZid(@PathVariable("zid") int zid){
        DormitoryResult result = zsztService.queryZsztByZid(zid);
        return result;
    }
    @GetMapping(value = "/queryzsztbydate/{date}")
    public DormitoryResult queryZsztByDate(@PathVariable("date") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date thedate = sdf.parse(date);
        DormitoryResult result = zsztService.queryZsztByDate(thedate);
        return result;
    }
    @GetMapping(value = "/queryzsztbydid/{did}")
    public DormitoryResult queryZsztByDid(@PathVariable("did") int did){
        DormitoryResult result = zsztService.queryZsztByDid(did);
        return result;
    }
    @PostMapping(value = "/addzszt")
    public DormitoryResult addZszt(HttpServletRequest request){
        String zsztStr = HttpServletRequestUtil.getString(request, "zsztStr");
        Zszt zszt = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            zszt = mapper.readValue(zsztStr, Zszt.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = zsztService.addZszt(zszt);
        return result;
    }
    @PostMapping(value = "/modifyzszt")
    public DormitoryResult modifyZszt(HttpServletRequest request){
        String zsztStr = HttpServletRequestUtil.getString(request, "zsztStr");
        Zszt zszt = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            zszt = mapper.readValue(zsztStr, Zszt.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = zsztService.modifyZszt(zszt);
        return result;
    }
    @GetMapping(value = "/deletezsztbyzid/{zid}")
    public DormitoryResult deleteZsztByZid(@PathVariable("zid") int zid){
        DormitoryResult result = zsztService.deleteZsztByZid(zid);
        return result;
    }
    @GetMapping(value = "/deletezsztbydid/{did}")
    public DormitoryResult deleteZsztByDid(@PathVariable("did") int did){
        DormitoryResult result = zsztService.deleteZsztByDid(did);
        return result;
    }
    @GetMapping(value = "/deletezsztbydate/{date}")
    public DormitoryResult deleteZsztByDate(@PathVariable("date") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date thedate = sdf.parse(date);
        DormitoryResult result = zsztService.deleteZsztByDate(thedate);
        return result;
    }

}
