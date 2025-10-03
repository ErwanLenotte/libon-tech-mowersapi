package com.libon.mowersapi.application.restapiadapter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record MowerDto(
        @NotBlank(message = "id can't be empty")
        String id,

        @JsonProperty("start_position")
        @Valid
        @NotNull(message = "start_position can't be null")
        PositionDto startPosition,

        @NotBlank(message = "orientation can't be empty")
        String orientation,

        @NotNull(message = "instructions can't be null")
        List<@Pattern(regexp = "[ADG]", message = "Instruction can only be A, D, G") String> instructions
) {}
