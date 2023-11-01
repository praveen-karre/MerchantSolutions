package com.db.merchantsolutions.trading.handlers;

import com.db.merchantsolutions.trading.model.Command;
import org.springframework.stereotype.Component;

@Component
public class SignalThreeCommand  extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().setAlgoParam(1, command.getParam1());
        command.getAlgo().setAlgoParam(2, command.getParam2());
        command.getAlgo().performCalc();
        command.getAlgo().submitToMarket();
    }
}
