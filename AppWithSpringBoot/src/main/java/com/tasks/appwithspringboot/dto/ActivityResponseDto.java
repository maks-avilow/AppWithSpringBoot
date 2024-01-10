package com.tasks.appwithspringboot.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("/////")
public class ActivityResponseDto {
            private String activity;
            private double accessibility;
            private String type;
            private int participants;
}

