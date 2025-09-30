package com.libon.mowersapi;

import static org.assertj.core.api.Assertions.assertThat;

import com.libon.mowersapi.application.restapiadapter.MowersRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MowersapiApplicationTests {

    @Autowired
    private MowersRestController controller;

	@Test
	void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
