import java.io.*;
import java.net.Socket;

/**
 * Sends files to calculate transfer speed
 */
public class Client {

    private Socket socket;
    private File file;
    private InputStream in;
    OutputStream out;
    private int count;
    long speed;
    private boolean tested;

    /**
     * Tries to connect to the target IP and port.
     * A server must be running and ready to accept the connection.
     * @param host Target IP
     * @param port Target port
     */
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

    /**
     * @param fileSize Filesize for transfer in MB
     * @throws IOException
     * Runs speedtest with automatically fetched or generated file
     */
    void speedTest(int fileSize) throws IOException {
        //  Gets file from FileGen
        FileGen fg = new FileGen();
        file = fg.getFile(fileSize);
        byte[] bytes = new byte[16 * 1024];
        in = new FileInputStream(file);
        count = 0;
        //  Gets time for speedtest calculation
        long start = System.currentTimeMillis();
        //  Sends file
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        //  Calculates and prints time
        long end = System.currentTimeMillis();
        final long BYTES_IN_KB = 1024;
        long transferred = BYTES_IN_KB * fileSize;
        System.out.println("File transfered!");
        speed = transferred /(end-start);
        System.out.println("Speed: " + speed + "KB/s");
        tested = true;
        in.close();
    }

    /**
     * @throws IOException
     * Closes and stops socket
     */
    public void close() throws IOException {
        out.close();
        socket.close();
    }

    /**
     * @return speed in KB/s
     */
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