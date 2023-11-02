package com.db.merchantsolutions.trading.services;

import com.db.merchantsolutions.trading.handlers.SignalCommand;
import com.db.merchantsolutions.trading.model.Command;
import com.db.merchantsolutions.trading.model.Signal;
import com.db.merchantsolutions.trading.repository.SignalRepository;
import com.db.merchantsolutions.trading.utilis.AlgoProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignalServiceImpl implements SignalService {

    private final SignalCommand signalCommand;

    private final SignalRepository signalRepository;

    public SignalServiceImpl(SignalCommand signalCommand, SignalRepository signalRepository) {
        this.signalCommand = signalCommand;
        this.signalRepository = signalRepository;
    }
    public void handleSignal(Signal signal) {
        this.saveToRepo(signal);
        this.signalCommand
                .setCommand(this.buildCommand(signal.getParam1(), signal.getParam2()))
                .handleSignal(signal.getSignal());
    }

    @Transactional
    public void saveToRepo(Signal signal) {
        this.signalRepository.save(signal);
    }

    private Command buildCommand(int param1, int param2) {
        return new Command.Builder()
                .setAlgo(AlgoProvider.INSTANCE.getAlgo())
                .setParam1(param1)
                .setParam2(param2)
                .build();
    }
}
