package com.db.merchantsolutions.trading.model;

import com.db.merchantsolutions.trading.handlers.*;
import lombok.Getter;

public enum SignalType {
    SIGNAL_1(1, new SignalOneCommand()),
    SIGNAL_2(2, new SignalTwoCommand()),
    SIGNAL_3(3, new SignalThreeCommand()),
    DEFAULT(0, new DefaultSignalCommand());

    @Getter
    private final int signal;
    private final SignalCommand command;

    SignalType(int signal, SignalCommand command) {
        this.signal = signal;
        this.command = command;
    }

    public static SignalCommand getHandler(int signal) {
        for (SignalType signalType : SignalType.values()) {
            if (signalType.getSignal() == signal) {
                return signalType.command;
            }
        }
        return DEFAULT.command;
    }
}
