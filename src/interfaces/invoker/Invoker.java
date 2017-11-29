package interfaces.invoker;

import interfaces.command.Command;

/**
 * 
 */
public interface Invoker {

    /**
     * @param cmd
     * @return
     */
    void setCommand(Command cmd );

}