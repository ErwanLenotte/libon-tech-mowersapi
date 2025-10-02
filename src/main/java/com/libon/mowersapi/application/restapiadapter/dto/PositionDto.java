package com.libon.mowersapi.application.restapiadapter.dto;

import jakarta.validation.constraints.Min;

public record PositionDto(
        @Min(value=0,message = "x can't be negative")
        Integer x,

        @Min(value=0,message = "y can't be negative")
        Integer y
) {}
