package interfaces.command;

/**
 * 
 */
public interface Command {

    /**
     * action to perform when executing the command
     */
    void execute() throws NoSuchMethodException;

}