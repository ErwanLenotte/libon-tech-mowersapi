package com.libon.mowersapi.application.restapiadapter.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

public record FieldDto (
        @JsonProperty("max_x")
        @Schema(description = "This is max x for the grid",example = "5")
        @Min(value=0,message = "max_x can't be negative")
        Integer maxX,

        @JsonProperty("max_y")
        @Schema(description = "This is max y for the grid",example = "5")
        @Min(value=0,message = "max_y can't be negative")
        Integer maxY
) {}
