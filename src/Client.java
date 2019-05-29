import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private Socket socket;
    private File file;
    private InputStream in;
    OutputStream out;
    private int count;
    long speed;
    private boolean tested;

    Client(String host, int port)  {
        System.out.println("Starting file transfer client!");
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert socket != null;
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void speedTest(int fileSize) throws IOException {
        FileGen fg = new FileGen();
        file = fg.getFile(fileSize);
        byte[] bytes = new byte[16 * 1024];
        in = new FileInputStream(file);
        count = 0;
        long start = System.currentTimeMillis();

        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        long end = System.currentTimeMillis();
        final long BYTES_IN_KB = 1024;
        long transferred = BYTES_IN_KB * fileSize;
        System.out.println("File transfered!");
        speed = transferred /(end-start);
        System.out.println("Speed: " + speed + "KB/s");
        tested = true;
        in.close();
    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }

    public long getSpeed(){
        if(tested) {
            return speed;
        } else {
            try {
                speedTest(2);
            } catch (IOException e) {
                e.printStackTrace();
            } return speed;
        }
    }
}