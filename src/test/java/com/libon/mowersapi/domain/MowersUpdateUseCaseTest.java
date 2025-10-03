package com.libon.mowersapi.domain;

import com.libon.mowersapi.application.restapiadapter.dto.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MowersUpdateUseCaseTest {

    @Test
    void when_given_mowersdetails_should_return_updated_mower(){
        MowersUpdateUseCase mowersUpdateUseCase = new MowersUpdateUseCase();

        MowersUpdatedDto actual = mowersUpdateUseCase.updateMowers(getMowersDetailsDto());
        assertThat(actual).isNotNull().isEqualTo(new MowersUpdatedDto(getMowerUpdatedDto()));
    }

    private List<MowerUpdatedDto> getMowerUpdatedDto() {
        return List.of(new MowerUpdatedDto("mower1",new PositionDto(1,3),"N"),
                new MowerUpdatedDto("mower2",new PositionDto(5,1),"E"));
    }

    private static MowersDetailsDto getMowersDetailsDto() {
        FieldDto field = new FieldDto(5, 5);
        List<String> instructionsOne = List.of("G", "A", "G", "A", "G", "A", "G", "A", "A");
        MowerDto mowerOne = new MowerDto("mower1", new PositionDto(1, 2), "N", instructionsOne);

        List<String> instructionsTwo = List.of("A", "A", "D", "A", "A", "D", "A", "D", "D", "A");
        MowerDto mowerTwo = new MowerDto("mower2", new PositionDto(3, 3), "E", instructionsTwo);

        return new MowersDetailsDto(field, List.of(mowerOne, mowerTwo));
    }
}
