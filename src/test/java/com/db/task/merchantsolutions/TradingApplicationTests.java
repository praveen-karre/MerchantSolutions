package com.db.task.merchantsolutions;

import com.db.merchantsolutions.trading.TradingApplication;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TradingApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
class TradingApplicationTests {

    public final Logger LOG = LoggerFactory.getLogger(TradingApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setupClass() {
        LOG.info("executing integration tests");
    }

}
