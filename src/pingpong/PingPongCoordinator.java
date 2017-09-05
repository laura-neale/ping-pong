package pingpong;

public class PingPongCoordinator {

    private boolean pinged;

    public void mark(){
        this.pinged = !pinged;
    }

    public boolean getStatus(){
        return this.pinged;
    }
}
