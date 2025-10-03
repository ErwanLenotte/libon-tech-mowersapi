package com.libon.mowersapi.application.restapiadapter;

import com.libon.mowersapi.application.restapiadapter.dto.MowersUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersDetailsDto;
import com.libon.mowersapi.domain.MowersUpdateUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MowersRestController {

    private MowersUpdateUseCase mowersUpdateUseCase;

    public MowersRestController(MowersUpdateUseCase mowersUpdateUseCase) {
        this.mowersUpdateUseCase = mowersUpdateUseCase;
    }

    @PostMapping("mowers")
    public MowersUpdatedDto updateMowersPosition(@RequestBody @Valid MowersDetailsDto mowersDetailsDto){
        return mowersUpdateUseCase.updateMowers(mowersDetailsDto);
    }
}
