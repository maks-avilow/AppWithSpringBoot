package com.tasks.appwithspringboot.service;

import com.tasks.appwithspringboot.dto.AddGroupRequestDto;
import com.tasks.appwithspringboot.dto.GetGroupRequestDto;
import com.tasks.appwithspringboot.dto.ResponseForGroupDto;
import com.tasks.appwithspringboot.entity.Group;
import com.tasks.appwithspringboot.entity.Student;
import com.tasks.appwithspringboot.repository.GroupRepository;
import com.tasks.appwithspringboot.service.GroupServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {
    @Mock
    private GroupRepository groupRepository;
    @InjectMocks
    private GroupServiceImpl groupService;

    @Test
    void testAddGroup() {
        AddGroupRequestDto addGroupRequestDto = new AddGroupRequestDto();
        addGroupRequestDto.setGroupNumberFromAddDto("TestGroups");

        Group group = new Group();
        group.setGroupNumber("TestGroups");

        groupService.addGroup(addGroupRequestDto);

        verify(groupRepository, times(1)).save(group);
    }
    @Test
    void testGetAllGroup() {
        List<Group> groups = new ArrayList<>();
        Group group1 = new Group();
        group1.setId(1);
        group1.setGroupNumber("Group1");

        Group group2 = new Group();
        group2.setId(2);
        group2.setGroupNumber("Group2");

        groups.add(group1);
        groups.add(group2);

        when(groupRepository.findAll()).thenReturn(groups);

        ResponseForGroupDto response = groupService.getAllGroup();

        assertEquals(2, response.getStudents().size());
    }
    @Test
    void testGetGroupByNumber() {
        GetGroupRequestDto getGroupRequestDto = new GetGroupRequestDto();
        getGroupRequestDto.setGroupNumberFromGetDto("IT404");

        Group group = new Group();
        group.setGroupNumber("IT404");

        when(groupRepository.findGroupByGroupNumber("TestGroup")).thenReturn(group);

        ResponseForGroupDto response = groupService.getGroupByNumber(getGroupRequestDto);

        assertEquals("TestGroup", response.getGroupNumber());
    }
}
