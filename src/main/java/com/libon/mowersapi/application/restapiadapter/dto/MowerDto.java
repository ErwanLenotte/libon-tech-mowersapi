package com.libon.mowersapi.application.restapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MowerDto(
        String id,

        @JsonProperty("start_position")
        PositionDto startPosition,

        String orientation,

        List<String> instructions) {
}
