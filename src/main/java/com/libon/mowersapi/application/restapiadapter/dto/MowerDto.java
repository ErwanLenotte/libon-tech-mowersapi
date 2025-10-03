package com.libon.mowersapi.application.restapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record MowerDto(
        @NotBlank(message = "id can't be empty")
        @Schema(description = "Id of the mower",example = "mower1")
        String id,

        @JsonProperty("start_position")
        @Valid
        @NotNull(message = "start_position can't be null")
        @Schema(description = "This is starting position of mower in the grid")
        PositionDto startPosition,

        @NotBlank(message = "orientation can't be empty")
        @Schema(description = "This is starting orientation of the mower in the grid",example = "N")
        String orientation,

        @NotNull(message = "instructions can't be null")
        @Schema(description = "This is list of instructions to apply on a mower ",example = "[A,G,D]")
        List<@Pattern(regexp = "[ADG]", message = "Instruction can only be A, D, G") String> instructions
) {}
