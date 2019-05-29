import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    InputStream in;
    FileOutputStream out;
    BufferedReader br;
    int count;
    int port;
    String curDir = System.getProperty("user.dir");
    File file = new File(curDir + File.separator + "received.txt");
    File tmp;

    public Server(int port) throws IOException, InterruptedException {
        serverSocket = null;
        this.port = port;
        System.out.println("Writing to: " + file.toString());

        socket = null;
        in = null;

        try {
            if (serverSocket != null) {
                socket = serverSocket.accept();
            }
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }
        getInput();
    }
    private void getInput() throws IOException, InterruptedException {
        if(serverSocket == null) {
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException ex) {
                System.out.println("Can't setup server on this port number. ");
            }
            System.out.println("Opened port " + port );
        } else {
            System.out.println("Server listening");
        }
        try {
            if (serverSocket != null) {
                socket = serverSocket.accept();
            }
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }
        try {
        tmp = new File(curDir + File.separator + "tmp.txt");
        if(tmp.createNewFile())
            System.out.println("tempfile created"); } catch (IOException e) {
            System.out.println(e);
        }
        try {
            if (socket != null) {
                in = socket.getInputStream();
            }
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }
        if (in!=null) {
            try {
                out = new FileOutputStream(tmp);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found. ");
                System.out.println("File created with path: " + tmp.toString());
            }

            byte[] bytes = new byte[16 * 1024];

            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            } out.close();
                if (tmp.length() > 0){
                    FileInputStream reader = new FileInputStream(tmp);
                    FileOutputStream writer = new FileOutputStream(file);
                    byte[] tempbuf = new byte[1024];
                    int read;
                    while((read = reader.read(tempbuf)) > 0){
                        writer.write(tempbuf, 0, read);
                        writer.flush();
                    }
                    writer.close();
                    reader.close();
                    Path tmpPath = tmp.toPath();
                    tmp = null;
                    Files.delete(tmpPath);
                    System.out.println("Tempfile deleted");
                }
        } else {
            System.out.println("No input stream!");
        }
        System.out.println("Receieved and reset");
        out.close();
        count = 0;
        socket.close();
        in = null;
        Thread.sleep(2000);
        getInput();
    }

    public void stop() throws IOException {
        br.close();
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
        System.out.println("CLOSED!");
    }
}