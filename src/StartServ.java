import java.io.IOException;

public class StartServ {

    /* Opens port 3333 */
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
