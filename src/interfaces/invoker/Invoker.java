package interfaces.invoker;

import interfaces.command.Command;

/**
 * 
 */
public interface Invoker {

    /**
     * @param cmd {@link Command} to execute
     */
    void setCommand(Command cmd ) throws NoSuchMethodException;

}