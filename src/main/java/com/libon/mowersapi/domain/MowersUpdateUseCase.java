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
        List<MowerUpdatedDto> mowersUpdated = details.mowers().stream().map(mower -> this.moveMovers(field,mower)).map(this::mapToUpdateMower).toList();

        return new MowersUpdatedDto(mowersUpdated);
    }

    private MowerUpdatedDto mapToUpdateMower(Mower mower) {
        return new MowerUpdatedDto(mower.getId(),new PositionDto(mower.getX(), mower.getY()),mower.getOrientation().toString());
    }

    private Mower moveMovers(FieldDto field, MowerDto mowerDto) {
        PositionDto positionDto = mowerDto.startPosition();
        Mower mower = new Mower(mowerDto.id(), field.maxX(), field.maxX(), positionDto.x(), positionDto.y(), OrientationEnum.valueOf(mowerDto.orientation()));

        for (String instruction : mowerDto.instructions()){
            InstructionEnum instructionEnum = InstructionEnum.valueOf(instruction);
            switch (instructionEnum){
                case G,D -> mower.changeDirection(instructionEnum);
                case A -> mower.advance();
            }
        }
        return mower;
    }
}
