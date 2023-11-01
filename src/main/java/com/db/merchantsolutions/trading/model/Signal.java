package com.db.merchantsolutions.trading.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Signal {


    @Id
    private int signal;

    private int param1;

    private int param2;

    public Signal() {

    }

    public Signal(Builder builder) {
        this.signal = builder.signal;
        this.param1 = builder.param1;
        this.param2 = builder.param2;
    }

    public static final class Builder {

        private int signal;
        private int param1;
        private int param2;

        public Builder setSignal(int signal) {
            this.signal = signal;
            return this;
        }

        public Builder setParam1(int param1) {
            this.param1 = param1;
            return this;
        }

        public Builder setParam2(int param2) {
            this.param2 = param2;
            return this;
        }

        public Signal build() {
            return new Signal(this);
        }
    }

    @Override
    public String toString() {
        return "signal=" + signal +
                ", param1=" + param1 +
                ", param2=" + param2;
    }
}
