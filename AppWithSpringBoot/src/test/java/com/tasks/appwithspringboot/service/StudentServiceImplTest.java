package com.tasks.appwithspringboot.service;

import com.tasks.appwithspringboot.dto.AddStudentsRequestDto;
import com.tasks.appwithspringboot.entity.Group;
import com.tasks.appwithspringboot.entity.Student;
import com.tasks.appwithspringboot.repository.GroupRepository;
import com.tasks.appwithspringboot.repository.StudentRepository;
import com.tasks.appwithspringboot.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddStudent() {
        AddStudentsRequestDto addStudentsRequestDto = new AddStudentsRequestDto();
        addStudentsRequestDto.setSurname("TestStudent");
        addStudentsRequestDto.setGroupId(1);

        Group group = new Group();
        group.setId(1);

        Student student = new Student();
        student.setSurname("TestStudent");
        student.setGroup(group);

        when(groupRepository.findById(1)).thenReturn(java.util.Optional.of(group));

        studentService.addStudent(addStudentsRequestDto);

        verify(studentRepository, times(1)).save(student);
    }
}

