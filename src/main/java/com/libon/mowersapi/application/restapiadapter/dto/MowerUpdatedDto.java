package com.libon.mowersapi.application.restapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MowerUpdatedDto(
        String id,
        @JsonProperty("end_position")
        PositionDto endPosition,
        String orientation) {
}
