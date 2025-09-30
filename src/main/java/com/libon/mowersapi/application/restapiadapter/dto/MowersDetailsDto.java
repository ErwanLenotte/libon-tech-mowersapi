package com.libon.mowersapi.application.restapiadapter.dto;

import java.util.List;

public record MowersDetailsDto(
        FieldDto field,
        List<MowerDto> mowers
) {
}
