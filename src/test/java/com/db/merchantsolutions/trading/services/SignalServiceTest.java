package com.db.merchantsolutions.trading.services;

import com.db.merchantsolutions.trading.handlers.SignalCommand;
import com.db.merchantsolutions.trading.model.Command;
import com.db.merchantsolutions.trading.model.Signal;
import com.db.merchantsolutions.trading.repository.SignalRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource(locations= "classpath:application-test.properties")
public class SignalServiceTest {

    @Mock
    private SignalCommand signalCommand;

    @Mock
    private SignalRepository signalRepository;

    @InjectMocks
    private SignalServiceImpl signalService;

    @Test
    public void givenSignal_whenSignalService_thenSuccess() {
        //given
        Signal signal = new Signal.Builder().setSignal(new Random().nextInt(5)).setParam1(10).setParam2(20).build();
        when(signalCommand.setCommand(any(Command.class))).thenReturn(signalCommand);

        //when
        signalService.handleSignal(signal);

        //then
        verify(signalRepository, atLeastOnce()).save(signal);
        verify(signalCommand, atLeastOnce()).setCommand(any(Command.class));
        verify(signalCommand, times(1)).handleSignal(signal.getSignal());
    }
}
