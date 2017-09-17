/**
 * Created by DevSingh on 9/15/17.
 */
public class Initiater {
    private Listener listener;

    public void addListener(Listener toAdd) {
        listener = toAdd;
    }

    public void sendCommand(String command) {
        listener.moveKey(command);
    }
}
