package com.youyi.dormitory.service.impl;

import com.youyi.dormitory.dao.StudentDao;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Student;
import com.youyi.dormitory.exception.DormitoryException;
import com.youyi.dormitory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public DormitoryResult queryStudents() {
        List<Student> studentList = studentDao.queryStudents();
        if (studentList != null && studentList.size() > 0) {
            return DormitoryResult.ok(studentList);
        } else {
            return DormitoryResult.notFount("查询失败");
        }
    }

    @Override
    public DormitoryResult queryStudentBySid(int sid) {
        if (sid <= 0) {
            return DormitoryResult.notFount("查询学生条件错误");
        } else {
            Student student = studentDao.queryStudentBySid(sid);
            if (student == null) {
                return DormitoryResult.notFount("查询学生结果为空");
            } else {
                return DormitoryResult.ok(student);
            }
        }
    }

    @Override
    public DormitoryResult queryStudentsByDid(int did) {
        if (did <= 0) {
            return DormitoryResult.notFount("查询学生条件错误");
        } else {
            List<Student> studentList = studentDao.queryStudentByDid(did);
            if (studentList != null || studentList.size() > 0) {
                return DormitoryResult.ok(studentList);
            } else {
                return DormitoryResult.notFount("查询学生结果为空");
            }
        }
    }

    @Override
    public Map<String,Object> queryStudentCountByDid(int did) {
        Map<String,Object> modleMap = new HashMap<>();
        if (did <= 0) {
            modleMap.put("status","404");
            modleMap.put("number","0");
            modleMap.put("msg","查询条件错误");
            return modleMap;
        } else {
            int number = studentDao.queryStudentCountByDid(did);
            if (number > 0) {
                modleMap.put("number",number);
                return modleMap;
            } else {
                modleMap.put("status","404");
                modleMap.put("number","0");
                modleMap.put("msg","查询结果为空");
                return modleMap;
            }
        }
    }

    @Override
    public DormitoryResult addStudent(Student student) {
        if(student == null){
            return DormitoryResult.notFount("插入学生为空");
        }else{
            try{
                int effectedNum = studentDao.insertStudent(student);
                if (effectedNum>0){
                    return DormitoryResult.ok();
                }else {
                    return DormitoryResult.notFount("添加学生失败");
                }
            }catch (Exception e){
                throw new DormitoryException("插入学生错误："+e.getMessage());
            }
        }
    }
    @Override
    public DormitoryResult updateStudent(Student student) {
        if(student == null){
            return DormitoryResult.notFount("插入学生为空");
        }else{
            try{
                int effectedNum = studentDao.updateStudent(student);
                if (effectedNum>0){
                    return DormitoryResult.ok();
                }else {
                    return DormitoryResult.notFount("修改学生失败");
                }
            }catch (Exception e){
                throw new DormitoryException("修改学生错误："+e.getMessage());
            }
        }
    }

    @Override
    public DormitoryResult deleteStudent(int sid) {
        if(sid>0){
            try{
                int effectedNum = studentDao.deleteStudent(sid);
                if(effectedNum>0){
                    return DormitoryResult.ok();
                }
                else{
                    return DormitoryResult.notFount("删除学生失败");
                }

            }catch (Exception e){
                throw new DormitoryException("删除学生错误");
            }
        }
        return DormitoryResult.notFount("删除学生条件错误");
    }
}
