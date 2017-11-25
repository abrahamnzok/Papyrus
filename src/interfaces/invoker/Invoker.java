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
    public void setCommand(Command cmd );

}