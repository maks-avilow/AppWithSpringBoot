package com.tasks.appwithspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Student_Response_DTO")
public class StudentResponseDto {
    @JsonProperty
    @ApiModelProperty("...")
    private int id;
    @JsonProperty
    @ApiModelProperty("...")
    private String surname;

}
