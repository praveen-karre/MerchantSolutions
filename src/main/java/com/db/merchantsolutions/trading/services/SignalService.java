package com.db.merchantsolutions.trading.services;

import com.db.merchantsolutions.trading.model.Signal;

public interface SignalService {
    public void handleSignal(Signal signal);
}
