package com.tasks.appwithspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel ("get group dto")
public class GetGroupRequestDto {

    @ApiModelProperty(value = "numberGroup", example = "IT404")
    @JsonProperty("group_number")
    private String groupNumberFromGetDto;

}
