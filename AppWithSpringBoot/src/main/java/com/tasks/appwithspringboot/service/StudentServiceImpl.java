package com.tasks.appwithspringboot.service;
import com.tasks.appwithspringboot.dto.AddStudentsRequestDto;
import com.tasks.appwithspringboot.entity.Group;
import com.tasks.appwithspringboot.entity.Student;
import com.tasks.appwithspringboot.repository.GroupRepository;
import com.tasks.appwithspringboot.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(AddStudentsRequestDto addStudentsRequestDto) {
        log.debug("Логика работы при добавлении студента в группу" + addStudentsRequestDto);

        Student student = new Student();
        student.setSurname(addStudentsRequestDto.getSurname());

        Group group = groupRepository.findById(addStudentsRequestDto.getGroupId()).orElse(null);

        student.setGroup(group);
        studentRepository.save(student);
    }
}
