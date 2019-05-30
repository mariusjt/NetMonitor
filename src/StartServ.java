import java.io.IOException;

public class StartServ {

    /**
     * Starts server
     * @param args None
     *
     */
    public static void main (String[] args) {
        try {
            Server srv = new Server(3333);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
