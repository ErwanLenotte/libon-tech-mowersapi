package com.libon.mowersapi.application.restapiadapter.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

public record FieldDto (
        @JsonProperty("max_x")
        @Min(value=0,message = "max_x can't be negative")
        Integer maxX,

        @JsonProperty("max_y")
        @Min(value=0,message = "max_y can't be negative")
        Integer maxY
) {}
