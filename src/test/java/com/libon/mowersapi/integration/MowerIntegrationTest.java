package com.libon.mowersapi.integration;

import com.libon.mowersapi.application.restapiadapter.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MowerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void update_mowers_position(){
        MowersDetailsDto mowersDetailsDto = getMowersDetailsDto();

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MowersDetailsDto> entity = new HttpEntity<>(mowersDetailsDto,headers);

        ResponseEntity<MowersUpdatedDto> response = restTemplate.exchange(getUrl(), HttpMethod.PUT, entity, MowersUpdatedDto.class);
        MowersUpdatedDto  actual = response.getBody();


        assertThat(actual).isNotNull();
        assertThat(actual.mowers()).isEqualTo(getMowerUpdatedDto());
    }

    private String getUrl() {
        return "http://localhost:" + port + "/api/v1/mowers";
    }

    private List<MowerUpdatedDto> getMowerUpdatedDto() {
        return List.of(new MowerUpdatedDto("mower1",new PositionDto(2,3),"N"),
                new MowerUpdatedDto("mower2",new PositionDto(2,3),"N"));
    }

    private static MowersDetailsDto getMowersDetailsDto() {
        FieldDto field = new FieldDto(5, 5);
        List<String> instructionsOne = List.of("G", "A", "G", "A", "G", "A", "G", "A", "A");
        MowerDto mowerOne = new MowerDto("mower1", new PositionDto(1, 2), "N", instructionsOne);

        List<String> instructionsTwo = List.of("G", "A", "G", "A", "G", "A", "G", "A", "A");
        MowerDto mowerTwo = new MowerDto("mower2", new PositionDto(3, 3), "E", instructionsTwo);

        return new MowersDetailsDto(field, List.of(mowerOne, mowerTwo));
    }


}
