package com.db.merchantsolutions.trading.handlers;

import com.db.merchantsolutions.trading.model.Command;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DefaultSignalCommand extends SignalCommand {

    @Override
    public void execute(Command command) {
        command.getAlgo().cancelTrades();
    }
}
