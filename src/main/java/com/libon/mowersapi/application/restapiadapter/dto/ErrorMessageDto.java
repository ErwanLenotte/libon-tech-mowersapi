package com.libon.mowersapi.application.restapiadapter.dto;

public record ErrorMessageDto(java.util.List<String> errors, java.time.LocalDateTime time) {
}
