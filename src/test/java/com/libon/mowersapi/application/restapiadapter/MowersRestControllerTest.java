package com.libon.mowersapi.application.restapiadapter;


import com.libon.mowersapi.application.restapiadapter.dto.*;
import com.libon.mowersapi.domain.MowersUpdateUseCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MowersRestControllerTest {

    @Test
    void given_valid_mowersdetails_should_return_updated_mowers(){
        MowersUpdateUseCase mowersUpdate =  mock();

        List<MowerUpdatedDto> mowerUpdatedDto = getMowerUpdatedDto();
        MowersDetailsDto mowersDetailsDto = getMowersDetailsDto();
        MowersUpdatedDto details = new MowersUpdatedDto(mowerUpdatedDto);

        when(mowersUpdate.updateMowers(mowersDetailsDto)).thenReturn(details);

        MowersRestController controller = new MowersRestController(mowersUpdate);
        MowersUpdatedDto mowersUpdatedDto = controller.updateMowersPosition(mowersDetailsDto);

        assertThat(mowersUpdatedDto).isNotNull();

        List<MowerUpdatedDto> mowersActual = mowersUpdatedDto.mowers();
        assertThat(mowersActual).isNotNull().isNotEmpty()
                .isEqualTo(mowerUpdatedDto);
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