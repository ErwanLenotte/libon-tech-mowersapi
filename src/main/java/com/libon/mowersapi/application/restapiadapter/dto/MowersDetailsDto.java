package com.libon.mowersapi.application.restapiadapter.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MowersDetailsDto(
        @Valid
        @NotNull(message = "field can't be null")
        FieldDto field,

        @NotNull(message = "mowers can't be null")
        @Valid
        List<MowerDto> mowers
) {
}
