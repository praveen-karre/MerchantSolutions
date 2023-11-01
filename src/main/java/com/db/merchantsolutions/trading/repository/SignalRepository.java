package com.db.merchantsolutions.trading.repository;

import com.db.merchantsolutions.trading.model.Signal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends MongoRepository<Signal, String> {
}
