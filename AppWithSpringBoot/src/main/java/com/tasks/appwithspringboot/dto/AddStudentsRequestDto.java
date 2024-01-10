package com.tasks.appwithspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api("") //TODO
public class AddStudentsRequestDto {

    @JsonProperty
    @ApiModelProperty("...")
    private String surname;
    @JsonProperty
    @ApiModelProperty("...")
    private Integer groupId;

}
