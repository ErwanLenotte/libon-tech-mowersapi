package com.libon.mowersapi.application.restapiadapter;

import com.libon.mowersapi.application.restapiadapter.dto.MowerUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersDetailsDto;
import com.libon.mowersapi.application.restapiadapter.dto.PositionDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MowersRestController {

    @PostMapping("mowers")
    public MowersUpdatedDto updateMowersPosition(@RequestBody @Valid MowersDetailsDto mowersDetailsDto){
        return new MowersUpdatedDto(List.of(new MowerUpdatedDto("mower1",new PositionDto(2,3) ,"N"), new MowerUpdatedDto("mower2", new PositionDto(2,3),"N")));
    }
}
