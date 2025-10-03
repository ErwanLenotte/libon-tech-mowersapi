package com.libon.mowersapi.domain;

import com.libon.mowersapi.application.restapiadapter.dto.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MowersUpdateUseCase {
    public MowersUpdatedDto updateMowers(MowersDetailsDto mowersDetailsDto) {

        MowersDetailsDto details = Optional.ofNullable(mowersDetailsDto).orElse(new MowersDetailsDto(new FieldDto(0, 0), Collections.emptyList()));
        final FieldDto field = details.field();
        List<MowerUpdatedDto> mowersUpdated = details.mowers().stream()
                .map(mower -> this.moveMovers(field,mower))
                .map(Mower::applyInstructions)
                .map(this::mapToUpdateMower).toList();

        return new MowersUpdatedDto(mowersUpdated);
    }

    private MowerUpdatedDto mapToUpdateMower(Mower mower) {
        return new MowerUpdatedDto(mower.getId(),new PositionDto(mower.getX(), mower.getY()),mower.getOrientation().toString());
    }

    private Mower moveMovers(FieldDto field, MowerDto mowerDto) {
        PositionDto positionDto = mowerDto.startPosition();
        List<InstructionEnum> instructions = mowerDto.instructions().stream().map(InstructionEnum::valueOf).toList();

        return new Mower(mowerDto.id(), field.maxX(), field.maxX(), positionDto.x(), positionDto.y(),
                OrientationEnum.valueOf(mowerDto.orientation()),instructions);
    }
}
