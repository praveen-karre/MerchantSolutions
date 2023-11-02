package com.db.merchantsolutions.trading.controllers;

import com.db.merchantsolutions.trading.model.Signal;
import com.db.merchantsolutions.trading.repository.SignalRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations= "classpath:application-test.properties")
public class SignalControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private SignalRepository signalRepository;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @BeforeEach
    public void before() {
        this.signalRepository.deleteAll();
    }

    @Test
    public void givenUser_whenValidInput_thenSucceed() throws Exception {
        // given
        Signal signal = new Signal.Builder().setSignal(new Random().nextInt(5)).setParam1(10).setParam2(20).build();

        //when
        this.mockMvc.perform(post("/api/db/signal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signal)))
                .andExpect(status().isOk());
        //then
        List<Signal> signals = this.signalRepository.findAll();
        Assertions.assertEquals(signals.get(0).getSignal(), signal.getSignal());
        Assertions.assertEquals(signals.get(0).getParam1(), signal.getParam1());
        Assertions.assertEquals(signals.get(0).getParam2(), signal.getParam2());
    }
}
