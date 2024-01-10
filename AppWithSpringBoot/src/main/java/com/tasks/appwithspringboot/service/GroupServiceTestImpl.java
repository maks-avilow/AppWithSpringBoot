package com.tasks.appwithspringboot.service;

import com.tasks.appwithspringboot.dto.AddGroupRequestDto;
import com.tasks.appwithspringboot.dto.GetGroupRequestDto;
import com.tasks.appwithspringboot.dto.ResponseForGroupDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;



//@Profile("test")
@Service
@ConditionalOnProperty(value = "group.service.test.mode", havingValue = "true")
public class GroupServiceTestImpl implements GroupService {

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        //System.out.println("например тут мы якобы ходим во внешние сервисы");
    }
    @Override
    public ResponseForGroupDto getAllGroup() {
           return null;
    }
    @Override
    public ResponseForGroupDto getGroupByNumber(GetGroupRequestDto getGroupRequestDto) {

        return null;
    }
}
