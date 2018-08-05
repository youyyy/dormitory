package com.youyi.dormitory.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youyi.dormitory.dto.DormitoryResult;
import com.youyi.dormitory.entity.Student;
import com.youyi.dormitory.service.StudentService;
import com.youyi.dormitory.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.Oneway;
import javax.servlet.http.HttpServletRequest;
import java.io.DataInput;
import java.io.IOException;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/querystudents")
    @ResponseBody
    public DormitoryResult queryStudents(){
        DormitoryResult result = studentService.queryStudents();
        return result;
    }
    @GetMapping(value = "/querystudentbysid/{sid}")
    public DormitoryResult queryStudentBySid(@PathVariable("sid") int sid){
        DormitoryResult result = studentService.queryStudentBySid(sid);
        return result;
    }
    @GetMapping(value = "/querystudentbydid/{did}")
    public DormitoryResult queryStudentByDid(@PathVariable("did") int did){
        DormitoryResult result = studentService.queryStudentsByDid(did);
        return result;
    }
    @GetMapping(value = "/querystudentcountbydid/{did}")
    public Map<String,Object> queryStudentCountByDid(@PathVariable("did") int did){
        Map<String,Object> result = studentService.queryStudentCountByDid(did);
        return result;
    }

    @PostMapping(value = "/addstudent")
    public DormitoryResult addStudent(HttpServletRequest request){
        String studentStr = HttpServletRequestUtil.getString(request, "studentStr");
        Student student = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            student = mapper.readValue(studentStr, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = studentService.addStudent(student);
        return result;
    }
    /*@PostMapping(value = "/addstudent")
    public DormitoryResult addStudent(Student student){
        DormitoryResult result = studentService.addStudent(student);
        return result;
    }*/
    @PostMapping(value = "/updatestudent")
    public DormitoryResult updateStudent(HttpServletRequest request){
        String studentStr = HttpServletRequestUtil.getString(request, "studentStr");
        Student student = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            student = mapper.readValue(studentStr, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DormitoryResult result = studentService.updateStudent(student);
        System.out.print(result);
        return result;
    }
    /*@PostMapping(value = "/updatestudent")
    public DormitoryResult updateStudent(Student student){
        DormitoryResult result = studentService.updateStudent(student);
        return result;
    }*/
    @GetMapping(value = "/deletestudent/{sid}")
    DormitoryResult deleteStudent(@PathVariable("sid") int sid){
        DormitoryResult result = studentService.deleteStudent(sid);
        return result;
    }
}
