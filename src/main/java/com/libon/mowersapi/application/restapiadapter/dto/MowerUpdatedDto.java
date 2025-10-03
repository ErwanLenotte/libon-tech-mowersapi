package com.libon.mowersapi.application.restapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MowerUpdatedDto(
        @NotEmpty
        @Schema(description = "This is the mower's id",example = "mower1")
        String id,

        @JsonProperty("end_position")
        @NotNull
        @Valid
        @Schema(description = "This is the mower's end position")
        PositionDto endPosition,

        @Schema(description = "This is final mower's orientation ",example = "W")
        @NotNull
        @Pattern(regexp = "[NSEW]", message = "Orientation can only be N, S, E, W")
        String orientation
) {}
