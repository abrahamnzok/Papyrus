package interfaces.v2.recorder;

import interfaces.v1.command.Command;

/**
 * 
 */
public interface Recorder {
    /**
     * @param command to store
     */
    public void record(Command command);

    /**
     *
     */
    public void replay();

    /**
     *
     */
    public void stop();

}