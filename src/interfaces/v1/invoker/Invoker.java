package interfaces.v1.invoker;


import interfaces.v1.command.Command;

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