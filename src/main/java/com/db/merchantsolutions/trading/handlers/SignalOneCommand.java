package com.db.merchantsolutions.trading.handlers;

import com.db.merchantsolutions.trading.model.Command;
import org.springframework.stereotype.Component;

@Component
public class SignalOneCommand  extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().setUp();
        command.getAlgo().setAlgoParam(1, command.getParam1());
        command.getAlgo().performCalc();
        command.getAlgo().submitToMarket();
    }
}
