package com.libon.mowersapi.application.restapiadapter;

import com.libon.mowersapi.application.restapiadapter.dto.MowersUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersDetailsDto;
import com.libon.mowersapi.domain.mower.MowersUpdateUseCase;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MowersRestController {

    private final MowersUpdateUseCase mowersUpdateUseCase;

    public MowersRestController(MowersUpdateUseCase mowersUpdateUseCase) {
        this.mowersUpdateUseCase = mowersUpdateUseCase;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MowersDetailsDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content) })

    @PostMapping("mowers")
    public MowersUpdatedDto updateMowersPosition(@RequestBody @Valid MowersDetailsDto mowersDetailsDto){
        return mowersUpdateUseCase.updateMowers(mowersDetailsDto);
    }
}
