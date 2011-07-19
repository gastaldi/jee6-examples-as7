package com.george.seam.exception;

import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.jboss.seam.exception.control.CaughtException;
import org.jboss.seam.exception.control.Handles;
import org.jboss.seam.exception.control.HandlesExceptions;
import org.jboss.seam.international.status.Messages;

@HandlesExceptions
public class MyExceptionHandler {

    @Inject
    Messages messages;

    public void handleEJBException(@Handles CaughtException<Throwable> pe, Logger log) {
        log.info("An error has occurred", pe.getException());
        messages.error("A strange error occurred: {0}", pe.getException().getMessage());
        pe.markHandled();
    }

}
