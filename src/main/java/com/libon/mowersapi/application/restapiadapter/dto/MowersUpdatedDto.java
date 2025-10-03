package com.libon.mowersapi.application.restapiadapter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MowersUpdatedDto(
        @NotNull
        @Schema(description = "This is the list of updated mowers")
        List<MowerUpdatedDto> mowers
) {}
