import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private Socket socket;
    private File file;
    private InputStream in;
    private OutputStream out;
    private int count;
    long speed;
    private boolean tested;

    public Client(int fileSize, String host, int port) throws IOException {
        System.out.println("Starting file transfer client!");
        socket = new Socket(host, port);
        FileGen fg = new FileGen();
        file = fg.getFile(fileSize);
        byte[] bytes = new byte[16 * 1024];
        in = new FileInputStream(file);
        out = socket.getOutputStream();
        count = 0;
        long start = System.currentTimeMillis();
        while (true) {

                if (!((count = in.read(bytes)) > 0)) break;

                out.write(bytes, 0, count);
        }
        long end = System.currentTimeMillis();
        final long BYTES_IN_KB = 1024;
        long transferred = BYTES_IN_KB * fileSize;
        System.out.println("File transfered!");
        speed = transferred/(end-start);
        System.out.println("Speed: " + speed + "KB/s");
        tested = true;
        out.close();
        in.close();
        socket.close();
    }

    public long getSpeed(){
        if(tested) {
            return speed;
        } else return -1;
    }
}