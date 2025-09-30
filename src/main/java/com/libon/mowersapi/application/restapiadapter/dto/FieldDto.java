package com.libon.mowersapi.application.restapiadapter.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record FieldDto (
        @JsonProperty("max_x")
        Integer maxX,
        @JsonProperty("max_y")
        Integer maxY
) {}
