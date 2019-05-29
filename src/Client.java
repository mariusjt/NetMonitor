import java.io.*;
import java.net.Socket;

public class Client {
Socket socket;
File file;
InputStream in;
OutputStream out;
int count;
    public Client(int fileSize) throws IOException {
        socket = new Socket("127.0.0.1", 3333);
        FileGen fg = new FileGen();
        file = fg.getFile(fileSize);
        byte[] bytes = new byte[16 * 1024];
        in = new FileInputStream(file);
        out = socket.getOutputStream();
        count = 0;
        while (true) {

                if (!((count = in.read(bytes)) > 0)) break;

                out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();


    /*
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        String host = "127.0.0.1";

        socket = new Socket(host, 5555);

        File file = new File("C:\\Dev\\Test\\1.xml");
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    } */
    }
}