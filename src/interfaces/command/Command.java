package interfaces.command;

import interfaces.Receiver.Receiver;

/**
 * 
 */
public interface Command {

    /**
     *
     */
    void execute() throws NoSuchMethodException;

}