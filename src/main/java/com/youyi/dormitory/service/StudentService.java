package com.youyi.dormitory.service;

import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Student;

import java.util.Map;

public interface StudentService {
    DormitoryResult queryStudents();
    DormitoryResult queryStudentBySid(int sid);
    DormitoryResult queryStudentsByDid(int did);
    Map<String,Object> queryStudentCountByDid(int did);
    DormitoryResult addStudent(Student student);
    DormitoryResult updateStudent(Student student);
    DormitoryResult deleteStudent(int sid);

}
