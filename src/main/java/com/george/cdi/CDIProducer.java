package com.george.cdi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.solder.core.ExtensionManaged;

public class CDIProducer {

    @Produces @CustomerDatabase @ApplicationScoped
    public Map<String,AtomicInteger> createCustomerDB() {
        return new HashMap<String, AtomicInteger>();
    }
    
    
    
    @Produces
    @ExtensionManaged
    @CustomerDatabase
    @PersistenceContext(name="exemplo-web")
    EntityManager customer;
}
