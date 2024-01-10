package com.tasks.appwithspringboot.controller;

import com.tasks.appwithspringboot.dto.ActivityResponseDto;
import com.tasks.appwithspringboot.dto.AddGroupRequestDto;
import com.tasks.appwithspringboot.dto.GetGroupRequestDto;
import com.tasks.appwithspringboot.dto.ResponseForGroupDto;
import com.tasks.appwithspringboot.exeption.MyOwnException;
import com.tasks.appwithspringboot.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping (path = "/groups")
@Slf4j
@Api("group controller for group")
public class GroupController {
    private final GroupService groupService;
    private final RestTemplate restTemplate;

    public GroupController(GroupService groupService, RestTemplate restTemplate) {
        this.groupService = groupService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @ApiOperation("getting groups list with all groups")
    public ResponseEntity<ResponseForGroupDto> getAllGroup () {
        log.debug("Получение всех групп");
        ResponseForGroupDto allGroup = groupService.getAllGroup();
        return ResponseEntity.ok()
                .body(allGroup);
    }

    @PostMapping (path = "/getByNumber")
    @ApiOperation("getting Groups by number")
    public ResponseEntity<ResponseForGroupDto> getGroupByNumber (
            @RequestBody GetGroupRequestDto getGroupRequestDto ) {
        log.debug("Получение группы по номеру");
        ResponseForGroupDto groupByNumber = groupService.getGroupByNumber(getGroupRequestDto);
        return ResponseEntity.status(200)
                .header("qwerty", "456")
                .header("ok")
                .body(groupByNumber);
    }

    @PostMapping (path = "/add")
    @ApiOperation("adding groups by number")
    public void addGroup (@RequestBody AddGroupRequestDto addGroupRequestDto) {
        log.debug("Добавление группы в бд по номеру группы " + addGroupRequestDto);
        groupService.addGroup(addGroupRequestDto);

            }

    @GetMapping(path = "test")
    public void testRestTemplate () {
        String url = "http://www.boredapi.com/api/activity/";

        ResponseEntity<ActivityResponseDto> forEntity =
                restTemplate.getForEntity(url, ActivityResponseDto.class);
        ActivityResponseDto body = forEntity.getBody();

        if (forEntity.getStatusCode().isError()) {
            throw new MyOwnException();
        }

        }
    }

