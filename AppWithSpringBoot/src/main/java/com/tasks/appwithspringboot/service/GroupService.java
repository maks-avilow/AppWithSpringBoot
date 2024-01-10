package com.tasks.appwithspringboot.service;
import com.tasks.appwithspringboot.dto.AddGroupRequestDto;
import com.tasks.appwithspringboot.dto.GetGroupRequestDto;
import com.tasks.appwithspringboot.dto.ResponseForGroupDto;



public interface GroupService {

    void addGroup (AddGroupRequestDto addGroupRequestDto);

    ResponseForGroupDto getAllGroup ();

    ResponseForGroupDto getGroupByNumber (GetGroupRequestDto getGroupRequestDto);
}
