package com.libon.mowersapi.application.restapiadapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MowersDetailsDto(
        @Valid
        @NotNull(message = "field can't be null")
        @Schema(description = "This is the grid representation")
        FieldDto field,

        @NotNull(message = "mowers can't be null")
        @Schema(description = "This is  the list of mowers to update")
        @Valid
        List<MowerDto> mowers
) {
}
