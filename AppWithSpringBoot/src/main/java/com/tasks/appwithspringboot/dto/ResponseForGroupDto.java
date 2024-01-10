package com.tasks.appwithspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.util.List;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("DTO_for_response_searching_groups")
public class ResponseForGroupDto {
    @JsonProperty
    @ApiModelProperty("...")
    private String groupNumber;
    @JsonProperty
    @ApiModelProperty("...")
    private int id;
    @JsonProperty
    @ApiModelProperty("...")
    private List<StudentResponseDto> students;




}
