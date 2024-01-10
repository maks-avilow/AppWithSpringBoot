package com.tasks.appwithspringboot.controller;


import com.tasks.appwithspringboot.dto.AddStudentsRequestDto;
import com.tasks.appwithspringboot.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/students")
@Api("StudentController - controller for students crud operation")
public class StudentController {

    private final StudentService studentService;

    public StudentController(@Autowired StudentService studentService) {
           this.studentService = studentService;
    }


    @PostMapping(path = "/addStudent")
    @ApiOperation("adding student full name in having group")
    public void addStudent(@RequestBody AddStudentsRequestDto addStudentsRequestDto) {
        log.debug("добавляем студента..." + addStudentsRequestDto.toString()) ;

        studentService.addStudent(addStudentsRequestDto);
        System.out.println();
    }


}
