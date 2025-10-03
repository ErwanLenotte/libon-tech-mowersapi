package com.libon.mowersapi.application.restapiadapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

public record PositionDto(
        @Min(value=0,message = "x can't be negative")
        @Schema(description = "This is mower's x position on the grid ",example = "3")
        Integer x,

        @Min(value=0,message = "y can't be negative")
        @Schema(description = "This is mower's y position on the grid ",example = "2")
        Integer y
) {}
