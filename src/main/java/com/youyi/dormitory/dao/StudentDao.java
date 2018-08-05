package com.youyi.dormitory.dao;

import com.youyi.dormitory.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryStudents();
    Student queryStudentBySid(int sid);
    List<Student> queryStudentByDid(int did);
    int queryStudentCountByDid(int did);
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int sid);
    int deleteStudentByDid(int did);
    int updateStudentDidToNull(int did);
}
