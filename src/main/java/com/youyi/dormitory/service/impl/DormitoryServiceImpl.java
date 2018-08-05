package com.youyi.dormitory.service.impl;

import com.youyi.dormitory.dao.DormitoryDao;
import com.youyi.dormitory.dao.StudentDao;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Dormitory;
import com.youyi.dormitory.exception.DormitoryException;
import com.youyi.dormitory.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DormitoryServiceImpl implements DormitoryService{
    @Autowired
    private DormitoryDao dormitoryDao;
    @Autowired
    private StudentDao studentDao;
    @Override
    public DormitoryResult queryDormitoryById(int did) {
        if(did<=0){
            return DormitoryResult.notFount("查询宿舍条件错误");
       }
        Dormitory dormitory = dormitoryDao.queryDormitoryById(did);
        if(dormitory == null){
            return DormitoryResult.notFount("查询宿舍结果为空");
        }
        return DormitoryResult.ok(dormitory);
    }

    @Override
    public DormitoryResult queryDormitories() {
        List<Dormitory> dormitoryList = dormitoryDao.queryDormitories();
        if(dormitoryList != null && dormitoryList.size()>0){
            return DormitoryResult.ok(dormitoryList);
        }else {
            return DormitoryResult.notFount("查询宿舍结果为空");
        }
    }

    @Override
    public DormitoryResult addDormitory(Dormitory dormitory){
        if(dormitory != null){
            try{
                int effectedNum = dormitoryDao.insertDormitory(dormitory);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                else{
                    return DormitoryResult.notFount("添加宿舍失败");
                }
            }catch (Exception e){
                throw new DormitoryException("添加宿舍错误："+e.getMessage());
            }
        }
        else {
            return  DormitoryResult.notFount("添加宿舍内容不能为空");
        }
    }

    @Override
    public DormitoryResult modifyDormitory(Dormitory dormitory) {
        if(dormitory != null){
            try{
                int effectedNum = dormitoryDao.updateDormitory(dormitory);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                else{
                    return DormitoryResult.notFount("修改宿舍失败");
                }
            }catch (Exception e) {
                throw new DormitoryException("修改宿舍错误：" + e.getMessage());
            }
        }
        else {
            return  DormitoryResult.notFount("宿舍未修改");
        }
    }

    @Override
    @Transactional
    public DormitoryResult deleteDormitory(int did) {
        if(did>0){
            //将学生对应宿舍为did的置为null
            try {
                int effected = studentDao.updateStudentDidToNull(did);
                if(effected<=0) {
                    return DormitoryResult.notFount("重置学生宿舍失败");
                }
            }catch (Exception e) {
                throw new DormitoryException("重置学生宿舍异常："+e.getMessage());
            }
            //删除宿舍
            try {
                int effectedNum = dormitoryDao.deleteDormitory(did);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                else {
                    return DormitoryResult.notFount("删除宿舍失败");
                }
            }catch (Exception e) {
                throw new DormitoryException("删除宿舍异常："+e.getMessage());
            }
        }
        else {
            return DormitoryResult.notFount("删除宿舍条件不能为空");
        }
    }
}
