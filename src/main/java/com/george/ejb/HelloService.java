package com.george.ejb;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.george.cdi.CustomerDatabase;

/**
 * Session Bean implementation class HelloService
 */
@Stateless
@LocalBean
@Path("/hello")
public class HelloService {
    
    @Inject @CustomerDatabase
    private Map<String,AtomicInteger> customerMap;
    
    /**
     * Default constructor. 
     */
    public HelloService() {
    }
    
    @GET
    public String getName(@QueryParam("name") @DefaultValue("World") String name) {
        AtomicInteger ai = customerMap.get(name);
        if (ai == null) {
            ai = new AtomicInteger();
            customerMap.put(name, ai);
        }
        int value = ai.incrementAndGet();
        return "Hello "+name+ " ! =>"+value;
    }

}
