package com.libon.mowersapi.application.restapiadapter;

import com.libon.mowersapi.application.restapiadapter.dto.MowerUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersUpdatedDto;
import com.libon.mowersapi.application.restapiadapter.dto.MowersDetailsDto;
import com.libon.mowersapi.application.restapiadapter.dto.PositionDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MowersRestController {

    @PutMapping("mowers")
    public MowersUpdatedDto updateMowersPosition(@RequestBody MowersDetailsDto mowersDetailsDto){
        return new MowersUpdatedDto(List.of(new MowerUpdatedDto("mower1",new PositionDto(2,3) ,"N"), new MowerUpdatedDto("mower2", new PositionDto(2,3),"N")));
    }
}
