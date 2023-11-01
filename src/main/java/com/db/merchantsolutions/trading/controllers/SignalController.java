package com.db.merchantsolutions.trading.controllers;

import com.db.merchantsolutions.trading.model.Signal;
import com.db.merchantsolutions.trading.services.SignalService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db")
@OpenAPIDefinition(info = @Info(title = "Merchant Solutions - Trading Signal Task", description = "Signal Processor", version = "v1.0"))
public class SignalController {

    private static final String SIGNAL_PATH = "/signal";
    @Autowired
    private SignalService signalService;

    @Operation(summary = "Process a signal")
    @ApiResponse(responseCode = "200", description = "Signal Processed")
    @PostMapping(value = SIGNAL_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> receiveSignal(@RequestBody Signal signal) {
        signalService.handleSignal(signal);
        return ResponseEntity.ok().build();
    }
}
