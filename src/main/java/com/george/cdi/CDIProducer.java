package com.george.cdi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class CDIProducer {

    @Produces @CustomerDatabase @ApplicationScoped
    public Map<String,AtomicInteger> createCustomerDB() {
        return new HashMap<String, AtomicInteger>();
    }
}
