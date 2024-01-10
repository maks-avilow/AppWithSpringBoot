package com.tasks.appwithspringboot.service;

import com.tasks.appwithspringboot.dto.AddGroupRequestDto;
import com.tasks.appwithspringboot.dto.GetGroupRequestDto;
import com.tasks.appwithspringboot.dto.ResponseForGroupDto;
import com.tasks.appwithspringboot.dto.StudentResponseDto;
import com.tasks.appwithspringboot.entity.Group;
import com.tasks.appwithspringboot.repository.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Profile("prod")
@Service
@Slf4j
//@ConditionalOnProperty(value = "group.service.test.mode", havingValue = "false")
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(@Autowired GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        log.debug("Добавляем группу по номеру с фронт" + addGroupRequestDto.getGroupNumberFromAddDto());

        Group group = new Group();
        group.setGroupNumber(addGroupRequestDto.getGroupNumberFromAddDto());

        groupRepository.save(group);
    }

    @Override
    public ResponseForGroupDto getAllGroup() {
        log.debug("Получаю все группы {} ", ResponseForGroupDto.class);
        List<Group> allGroups = groupRepository.findAll();
        ResponseForGroupDto responseGroup = new ResponseForGroupDto();
        List<StudentResponseDto> studentList = new ArrayList<>();

        for (Group group : allGroups) {
            ResponseForGroupDto responseForGroupDto = new ResponseForGroupDto();
            responseForGroupDto.setId(group.getId());
            responseForGroupDto.setGroupNumber(group.getGroupNumber());
            responseForGroupDto.setStudents(group.getStudents()
                    .stream()
                    .map(student -> {
                        StudentResponseDto studentResponseDto = new StudentResponseDto();
                        studentResponseDto.setId(student.getId());
                        studentResponseDto.setSurname(student.getSurname());
                        return studentResponseDto;
                    }).collect(Collectors.toList()));
            studentList.addAll(responseForGroupDto.getStudents());
        }
        responseGroup.setStudents(studentList);
        return responseGroup;
    }

    @Override
    public ResponseForGroupDto getGroupByNumber(GetGroupRequestDto getGroupRequestDto) {
        log.debug("Получаем группу по номеру {} ",  getGroupRequestDto.getGroupNumberFromGetDto());
        Group group = groupRepository.findGroupByGroupNumber(getGroupRequestDto.getGroupNumberFromGetDto());

        ResponseForGroupDto responseForGroupDto = new ResponseForGroupDto();
        responseForGroupDto.setGroupNumber(group.getGroupNumber());
        responseForGroupDto.setId(group.getId());
        responseForGroupDto.setStudents(group.getStudents()
                .stream()
                .map(Student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setId(studentResponseDto.getId());
                    studentResponseDto.setSurname(studentResponseDto.getSurname());
                    return studentResponseDto;
                }).collect(Collectors.toList()));
        return responseForGroupDto;
    }
}

